package com.shakan.common.response;

import lombok.Data;

/*
 * メッセージレスポンス
 */
@Data
public class MessageResponse {
	private String message;

	public MessageResponse(String message) {
	    this.message = message;
	  }
}