package com.capgemini.discover.fingerpay.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/***
 * Entity Containing user details**
 * 
 * @author Akshay Jain
 **/
@NamedQueries({
		@NamedQuery(name = "donorDetails.checkGoogleUser", query = "SELECT dd.donorId FROM donorDetails dd WHERE dd.emailId = :emailId"),
		@NamedQuery(name = "donorDetails.checkGuestUser", query = "SELECT dd.donorId FROM donorDetails dd WHERE dd.mobileNo = :mobileNo"),
		@NamedQuery(name = "donorDetails.fetchUserDetails", query = "SELECT dd FROM donorDetails dd WHERE dd.donorId = :donorId") })
@Entity(name = "donorDetails")
@Table(name = "DN_DONOR_DTL")
public class UserDetailsEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DONOR_ID", unique = true, nullable = false, insertable = false, updatable = false)
	private Long donorId;

	@Column(name = "DONOR_NAME", nullable = false, length = 50)
	private String name;

	@Column(name = "DONOR_EMAIL", unique = true, length = 50)
	private String emailId;

	@Column(name = "DONOR_MOBILE_NO", unique = true, length = 50)
	private Long mobileNo;

	@Column(name = "Gender", length = 1)
	private String gender;

	@Column(name = "DONOR_DOB")
	private LocalDate dateOfBirth;

	@Column(name = "DONOR_PHOTO_URL")
	private String photoUrl;

	@Column(name = "DONOR_TYPE")
	private String loginType;

}
