package com.tkmf.user.controller;

import com.tkmf.controller.UserControllerApi;
import com.tkmf.grace.result.GraceJSONResult;
import com.tkmf.pojo.HanmaUser;
import com.tkmf.user.mapper.HanmaUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController implements UserControllerApi {
    @Autowired
    HanmaUserMapper hanmaUserMapper;
    @Override
    public GraceJSONResult findAll() {
        List<HanmaUser> hanmaUsers = hanmaUserMapper.selectAll();
        return GraceJSONResult.ok(hanmaUsers);
    }
}
