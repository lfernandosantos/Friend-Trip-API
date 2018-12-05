package com.friendtrip.api.utils;

public class ConstantMessages {

	public interface Response {
		public interface StatusCode {
			public static final int SAVED_SUCCESSFULLY = 200;
			public static final int ALREADY_REGISTERED = 201;
		}
		
		public interface Message {
			public static final String USER_SAVED_SUCCESS = "User saved successfully!";
			public static final String USER_ALREADY_SAVE = "User already registered!";
			
			//Trip
			public static final String TRIP_SAVED_SUCCESS = "Trip saved successfully!";
			public static final String TRIP_ALREADY_SAVE = "Trip already registered!";


		}
	}
}
