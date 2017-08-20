package com.capgemini.discover.fingerpay.dao.impl;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.discover.fingerpay.dao.IAppRepository;
import com.capgemini.discover.fingerpay.dao.jpa.AbstractDao;
import com.capgemini.discover.fingerpay.domain.UserDetails;
import com.capgemini.discover.fingerpay.entity.UserDetailsEntity;
import com.capgemini.discover.fingerpay.rest.service.AppServiceClass;

/***
 * 
 * @author Akshay Jain
 *
 */
public class AppRepository extends AbstractDao implements IAppRepository {

	public static final Logger log = LoggerFactory.getLogger(AppServiceClass.class);

	Mapper mapper = new DozerBeanMapper();

	@Override
	public UserDetails getCardDetails(String userId) {

		try {
			TypedQuery<UserDetailsEntity> query = getEm().createNamedQuery("UserDetailsEntity.byUserId",
					UserDetailsEntity.class);
			query.setParameter("userId", userId);
			UserDetailsEntity userDetailsEntity = query.getSingleResult();
			return mapper.map(userDetailsEntity, UserDetails.class);
		}

		catch (NoResultException ex) {
			return null;
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void savePublickey(String publicKey) {

		// TODO - save key by updating the dto against userId

		// DonationDetailsEntity donationDetailsEntity =
		// mapper.map(donationDetails, DonationDetailsEntity.class);

		// getEm().persist(donationDetailsEntity);
		// getEm().flush();

	}

	@Override
	public String getPublicKey(String userId) {

		// TODO - return public key against that userId

		return "abcd";

	}

}