package com.capgemini.discover.fingerpay.dao.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/***

@author Akshay Jain
 *
 */
 public class AbstractDao {

 private EntityManager em;

 /**
 * @return the em
 */
 public EntityManager getEm() {
 return em;
 }

 /**
 * @param em
 * the em to set
 */
 @PersistenceContext
 public void setEm(EntityManager em) {
 this.em = em;
 }

 }
