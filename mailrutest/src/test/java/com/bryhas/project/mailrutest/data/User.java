package com.bryhas.project.mailrutest.data;

/**
 * Author: Andrii Bryhas
 * Date: 10.06.15
 */

interface ILoginName {
	IPassword setLoginName(String loginName);
}

interface IPassword {
	IEmail setPassword(String password);
}

interface IEmail {
	IBuild setEmail(String email);
}

interface IBuild {
	IUser build();
}

public class User implements ILoginName, IPassword,
		IEmail, IBuild, IUser {
	private String loginName;
	private String password;
	private String email;
	
	private User() {
	}

	private User(String loginName, String password, String email) {
		this.loginName = loginName;
		this.password = password;
		this.email = email;
	}

	// - - - - - - - - - - - - - - - - - - - -

	public static ILoginName get() {
		return new User();
	}
	
	public IPassword setLoginName(String loginName) {
		this.loginName = loginName;
		return this;
	}

	public IEmail setPassword(String password) {
		this.password = password;
		return this;
	}

	public IBuild setEmail(String email) {
		this.email = email;
		return this;
	}

	public IUser build() {
		return this;
	}

	// - - - - - - - - - - - - - - - - - - - -

	public String getLoginName() {
		return loginName;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}

}