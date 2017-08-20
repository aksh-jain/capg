package com.capgemini.discover.fingerpay.core;

import com.capgemini.discover.fingerpay.rest.request.UserDetailsRequest;

/**
 * @author Akshay Jain
 *
 */
public interface IAppManager {

	public boolean registerUser(String publicKey, UserDetailsRequest user);

	public boolean validateTransaction(UserDetailsRequest user);

}