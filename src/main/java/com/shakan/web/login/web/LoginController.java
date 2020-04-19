package com.shakan.web.login.web;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import com.shakan.common.models.Users;
import com.shakan.common.repository.UserRepository;
import com.shakan.common.response.JwtResponse;
import com.shakan.common.response.MessageResponse;
import com.shakan.common.service.UserDetailsImpl;
import com.shakan.security.jwt.JwtUtils;
import com.shakan.web.signup.service.SignUpService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * ログイン画面のControllerクラス
 */
@RestController
@CrossOrigin
@RequestMapping("/Login")
public class LoginController {

	@Inject
	AuthenticationManager authenticationManager;

	@Inject
    JwtUtils jwtUtils;

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

    @RequestMapping("/auth/login")
    public ResponseEntity<?> loginEvent(@Valid @RequestBody LoginForm loginForm) {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginForm.getUserId(), loginForm.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);

		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

		return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getUserId()));
    }

}
