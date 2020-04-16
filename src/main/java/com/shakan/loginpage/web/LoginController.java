package com.shakan.loginpage.web;

import javax.inject.Inject;

import com.shakan.loginpage.service.LoginService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * ログイン画面のControllerクラス
 */
@RestController
@CrossOrigin
public class LoginController {

    @Inject
    LoginService loginService;

    /**
     * 初期表示処理
     *
     * @return ResponseEntity {@link ResponseEntity}
     */
    @RequestMapping("/init")
    public ResponseEntity<?> init() {
        // LoginForm loginForm = getWebForm(loginForm.class);
        // 何もしない
        return ResponseEntity.status(HttpStatus.OK).body(LoginForm.class);
    }

    /**
     * 再表示処理
     *
     * @return ResponseEntity {@link ResponseEntity}
     */
    @RequestMapping("/display")
    public ResponseEntity<?> display() {
        // 何もしない
        return ResponseEntity.status(HttpStatus.OK).body(LoginForm.class);
    }

    @RequestMapping("/login")
    public ResponseEntity<?> loginEvent(@RequestBody LoginForm loginForm) {
        try {
            // ログインサービス
            loginService.execute(loginForm);
            // TODO:ログ出力
            // ログイン成功！

        } catch (Exception e) {
            // TODO:ログ出力
            // ログイン失敗！

            e.printStackTrace();
        }

        return ResponseEntity.status(HttpStatus.OK).body(LoginForm.class);
    }

}
