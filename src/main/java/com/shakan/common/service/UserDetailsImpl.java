package com.shakan.common.service;

import java.util.Collection;
import java.util.Objects;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.shakan.common.models.Users;

/*
 * ユーザ情報の取得
 */
public class UserDetailsImpl implements UserDetails {
	private static final long serialVersionUID = 1L;

	private String userId;

	@JsonIgnore
	private String password;

	private Collection<? extends GrantedAuthority> authorities;

	public UserDetailsImpl(String userId, String password) {
		this.userId = userId;
		this.password = password;
	}

	public static UserDetailsImpl build(Users user) {
		// List<GrantedAuthority> authorities = user.getRoles().stream()
		// 		.map(role -> new SimpleGrantedAuthority(role.getName().name()))
		// 		.collect(Collectors.toList());

		return new UserDetailsImpl(
				user.getUserId(),
				user.getPassword());
    }

	public String getUserId() {
		return userId;
    }

	@Override
	public String getPassword() {
		return password;
	}

    // ユーザ名は使用しない
	@Override
	public String getUsername() {
		return null;
    }

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		UserDetailsImpl user = (UserDetailsImpl) o;
		return Objects.equals(userId, user.userId);
	}

}