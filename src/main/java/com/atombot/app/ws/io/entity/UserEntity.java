package com.atombot.app.ws.io.entity;

import java.io.Serializable;

public class UserEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -971723885566178024L;
	
	private String id;
	private String userId;
	private String firstName;
	private String lastName;
	private String email;
	private String encryptedPassword;
	private String emailVerificationToken;
	private String emailVerificationStatus;


}
  