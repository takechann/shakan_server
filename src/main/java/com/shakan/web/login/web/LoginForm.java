package com.shakan.web.login.web;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

/*
 * ログイン画面のFormクラス
 */
@Data
public class LoginForm implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull
    @Size(min = 1, max=50)
    private String userId;

    @NotNull
    @Size(min = 1, max=50)
    private String password;
}