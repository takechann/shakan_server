package com.shakan.signuppage.web;

import javax.inject.Inject;

import com.shakan.signuppage.service.SignUpService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * サインアップ画面のControllerクラス
 */
@RestController
@CrossOrigin
@RequestMapping("/SignUp")
public class SignUpController {

    @Inject
    SignUpService signUpService;

    /**
     * 初期表示処理
     *
     * @return ResponseEntity {@link ResponseEntity}
     */
    @RequestMapping("/init")
    public ResponseEntity<?> init() {
        // LoginForm loginForm = getWebForm(loginForm.class);
        // 何もしない
        return ResponseEntity.status(HttpStatus.OK).body(SignUpForm.class);
    }

    /**
     * 再表示処理
     *
     * @return ResponseEntity {@link ResponseEntity}
     */
    @RequestMapping("/display")
    public ResponseEntity<?> display() {
        // 何もしない
        return ResponseEntity.status(HttpStatus.OK).body(SignUpForm.class);
    }

    @RequestMapping("")
    public ResponseEntity<?> signUpEvent(@RequestBody SignUpForm signUpForm) {
        try {
            // サインアップサービス
            signUpService.execute(signUpForm);
            // TODO:ログ出力
            // サインアップ成功！

        } catch (Exception e) {
            // TODO:ログ出力
            // サインアップ失敗！

            e.printStackTrace();
        }

        return ResponseEntity.status(HttpStatus.OK).body(SignUpForm.class);
    }

}
