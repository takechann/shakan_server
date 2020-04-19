package com.shakan.common.models;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

/*
 * ユーザテーブル
 */
@Entity
@Table(	name = "users",
		uniqueConstraints = {
			@UniqueConstraint(columnNames = "userId")
		})
@Data
// @Table(	name = "users")
public class Users {

	@NotBlank
	@Size(max = 50)
	@Id
	@Column(name = "userId") // 実際のカラム名はuser_id
    private String userId;

	@NotBlank
	@Size(max = 100)
	@Column(name = "password")
    private String password;

    // TODO：これはいらないか
    // @ManyToMany(fetch = FetchType.LAZY)
	// @JoinTable(	name = "user_roles",
	// 			joinColumns = @JoinColumn(name = "user_id"),
	// 			inverseJoinColumns = @JoinColumn(name = "role_id"))
    // private Set<Role> roles = new HashSet<>();

    public Users() {
    }

	public Users(String userId, String password) {
		this.userId = userId;
		this.password = password;
	}
}