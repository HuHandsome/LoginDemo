package com.bbs.web.controller;

import com.bbs.common.ConstUser;
import com.bbs.db.entity.UserEntity;

import javax.servlet.http.HttpServletRequest;

public class BaseController {
    static final String ERR_MSG_TAG = "errorMsg";

    void setSessionUser(HttpServletRequest request, UserEntity user) {
        request.getSession().setAttribute(ConstUser.USER_CONTEXT, user);
    }
}
