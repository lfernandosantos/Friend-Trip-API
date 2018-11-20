package com.friendtrip.api.utils;

public class ConstantMessages {

	public interface Response {
		public interface StatusCode {
			public static final int SAVED_SUCCESSFULLY = 200;
			public static final int ALREADY_REGISTERED = 201;
		}
		
		public interface Message {
			public static final String SAVED_SUCCESS = "User saved successfully!";
			public static final String ALREADY_SAVE = "User already registered!";
			


		}
	}
}
