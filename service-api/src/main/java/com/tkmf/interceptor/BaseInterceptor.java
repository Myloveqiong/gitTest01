package com.tkmf.interceptor;

import com.tkmf.exception.GraceException;
import com.tkmf.grace.enums.ResponseStatusEnum;
import com.tkmf.utils.RedisOperator;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BaseInterceptor {
    @Autowired
    private RedisOperator redisOperator;
    // 判断用户是否合法
    public boolean verifyUserIdToken(String id,String token,String redisKeyPrefix){
        if(StringUtils.isNotBlank(id) && StringUtils.isNotBlank(token)) {
            String uniqueToken = redisOperator.get(redisKeyPrefix +":" + token);
            if(StringUtils.isBlank(uniqueToken)){
                GraceException.display(ResponseStatusEnum.UN_LOGIN);
                return false;
            }else {
                if(!uniqueToken.equals(id)){
                    GraceException.display(ResponseStatusEnum.TICKET_INVALID);
                    return false;
                }
            }
        }else {
            GraceException.display(ResponseStatusEnum.UN_LOGIN);
            return false;
        }
        /*
            false: 请求被拦截，被驳回，验证出现问题
            true:   请求在经过验证校验以后，是OK的，是可以放行的
         */
        return true;
    }
}