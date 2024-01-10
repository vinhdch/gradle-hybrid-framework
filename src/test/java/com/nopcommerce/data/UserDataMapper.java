package com.nopcommerce.data;

import java.io.File;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import commons.GlobalConstants;

public class UserDataMapper {

	@JsonProperty("firstName")
	private String firstName;

	@JsonProperty("lastName")
	private String lastName;

	@JsonProperty("emailAddress")
	private String emailAddress;

	@JsonProperty("password")
	private String password;

	@JsonProperty("login")
	private Login login;

	public static UserDataMapper getUserData() {
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			return mapper.readValue(new File((GlobalConstants.PROJECT_PATH + "/src/test/resources/UserData.json")), UserDataMapper.class);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static class Login {
		@JsonProperty("userName")
		private String userName;
		@JsonProperty("password")
		private String password;
	}

	public String getLoginUserName() {
		return login.userName;
	}

	public String getLoginPassword() {
		return login.password;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public String getPassword() {
		return password;
	}

}
