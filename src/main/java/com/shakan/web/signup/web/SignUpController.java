package com.shakan.web.signup.web;

import javax.inject.Inject;
import javax.validation.Valid;

import com.shakan.common.models.Users;
import com.shakan.common.repository.UserRepository;
import com.shakan.common.response.MessageResponse;
import com.shakan.web.signup.service.SignUpService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
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

    private static final Logger logger = LoggerFactory.getLogger(SignUpController.class);

    @Inject
    SignUpService signUpService;

	@Inject
	UserRepository userRepository;

	@Inject
	PasswordEncoder encoder;

    /**
     * 初期表示処理
     *
     * @return ResponseEntity {@link ResponseEntity}
     */
    @RequestMapping("/init")
    public ResponseEntity<?> init() {
        // LoginForm loginForm = getWebForm(loginForm.class);
        // 何もしない
        logger.info("SignUp/init");
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

    /**
     * ユーザ登録処理
     *
     * @param signUpForm サインアップ画面の入力項目
     * @return ResponseEntity {@link ResponseEntity}
     */
    @RequestMapping("/auth/signup")
    public ResponseEntity<?> signUpEvent(@Valid @RequestBody SignUpForm signUpForm) {

        if (userRepository.existsByUserId(signUpForm.getUserId())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: userId is already taken!"));
		}

        // Create new user's account
		Users user = new Users(signUpForm.getUserId(),
                             encoder.encode(signUpForm.getPassword()));

        userRepository.save(user);

        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }

}
