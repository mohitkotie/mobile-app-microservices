package com.atombot.app.ws.shared.dto;

import java.util.Random;
import java.security.*;

import org.springframework.stereotype.Component;

@Component
public class Utils {

	private final Random RANDOM = new SecureRandom();
	private final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	private final int ITERATIONS = 10000;
	private final int KEY_LENGHT = 256;

	public String generatedUserId(int length) {
		return generatedRandomString(length);
	}

	private String generatedRandomString(int length) {

		StringBuilder returnValue = new StringBuilder(length);

		for (int i = 0; i < length; i++) {
			returnValue.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
		}

		return new String(returnValue);

	}

}
