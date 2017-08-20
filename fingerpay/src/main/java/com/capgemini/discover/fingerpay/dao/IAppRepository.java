package com.capgemini.discover.fingerpay.dao;

import com.capgemini.discover.fingerpay.domain.UserDetails;

/**
 * @author Akshay Jain
 *
 */
public interface IAppRepository {

	public UserDetails getCardDetails(String userId);

	public void savePublickey(String publicKey);

	public String getPublicKey(String userId);

}