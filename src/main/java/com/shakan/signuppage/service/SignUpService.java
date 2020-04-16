package com.shakan.signuppage.service;

import javax.inject.Inject;

import com.shakan.signuppage.web.SignUpForm;

import org.springframework.stereotype.Service;

/*
 * サインアップ画面のユーザサインアップService
 */
@Service
public class SignUpService {
    // TODO:Daoクラスのinject宣言
    // @Inject
    // private testDao testDao

    public SignUpService(){}

    /**
     * ビジネスロジック処理
     *
     */
    public void execute(SignUpForm signUpForm) {
        // サインアップ処理
        // TODO:仮
    }

}