package com.shakan.common.response;

import java.util.List;

import lombok.Data;

/*
 * Responseデータの共通オブジェクト
 */
@Data
public class JwtResponse {
	private String token;
	private String userId;

	public JwtResponse(String accessToken, String userId) {
		this.token = accessToken;
		this.userId = userId;
	}

}