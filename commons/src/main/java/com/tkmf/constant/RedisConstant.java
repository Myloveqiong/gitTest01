package com.tkmf.constant;

/**
 * Created by VULCAN on 2020/9/22.
 */
public interface RedisConstant {
    String MOBILE_SMSCODE = "mobile:smscode:";
    String REDIS_USER_TOKEN = "redis_user_token";
    String REDIS_USER_INFO = "redis_user_info";
    String REDIS_ADMIN_TOKEN = "redis_admin_token";
    String REDIS_ALL_CATEGORY = "redis_all_category";
    String REDIS_WRITER_FANS_COUNTS = "writer_fans_counts";
    String REDIS_MY_FOLLOW_COUNTS = "my_follow_counts";
    String REDIS_ARTICLE_READ_COUNTS = "article_read_counts";
    String REDIS_ARTICLE_ALREADY_READ = "article_alread_counts";
    String REDIS_ARTICLE_COMMENT_COUNTS = "article_comment_counts";

    String TOKEN_PREFIX = "token_%s";
    Integer EXPIRE = 7200;//2小时

}
