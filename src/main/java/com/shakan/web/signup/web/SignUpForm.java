package com.shakan.web.signup.web;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
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
    @NotBlank
    @Size(min = 1, max=50)
    private String userId;

    @NotNull
    @NotBlank
    @Size(min = 1, max=100)
    private String password;

}