package com.shakan.signuppage.web;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

/*
 * サインアップ画面のFormクラス
 */
@Data
public class SignUpForm implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull
    @Size(min = 1, max=50)
    private String userId;

    @NotNull
    @Size(min = 1, max=50)
    private String password;

}