package com.capgemini.discover.fingerpay.core.impl;

import javax.annotation.Resource;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import com.capgemini.discover.fingerpay.core.IAppManager;
import com.capgemini.discover.fingerpay.dao.IAppRepository;
import com.capgemini.discover.fingerpay.domain.UserDetails;
import com.capgemini.discover.fingerpay.rest.request.UserDetailsRequest;

/**
 * @author Akshay Jain
 *
 */
public class AppManager implements IAppManager {

	@Resource(name = "appRepository")
	IAppRepository appRepository;

	Mapper mapper = new DozerBeanMapper();

	@Override
	public boolean registerUser(String publicKey, UserDetailsRequest user) {

		UserDetails userDetails = appRepository.getCardDetails(user.getUserId());

		// TODO - Decrypt password

		if (!user.getPassword().equals(userDetails.getPassword())) {

			return false;
		}

		appRepository.savePublickey(publicKey);
		return true;

	}

	@Override
	public boolean validateTransaction(UserDetailsRequest user) {

		String key = appRepository.getPublicKey(user.getUserId());

		// TODO - Unsign card details using public key

		// TODO - if it get successfully unsigned, do transaction

		return false;

	}

}