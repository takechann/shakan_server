package com.shakan.loginpage.service;

import javax.inject.Inject;

import com.shakan.loginpage.web.LoginForm;

import org.springframework.stereotype.Service;

/*
 * ログイン画面のユーザログインService
 */
@Service
public class LoginService {
    // TODO:Daoクラスのinject宣言
    // @Inject
    // private testDao testDao

    public LoginService(){}

    /**
     * ビジネスロジック処理
     * 
     */
    public void execute(LoginForm loginForm) {
        // ログイン処理
        // TODO:仮
    }

}