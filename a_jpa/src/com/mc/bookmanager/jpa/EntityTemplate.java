package com.mc.bookmanager.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityTemplate {
	
	//EntityManagerFactory 는 thread sage하기 때문에 static에 올려놓고 사용하거나 singleTon으로 사요해도 안전
	private static final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("a_jpa");
	
	public static EntityManager getEntityManager() {
		return EMF.createEntityManager();
	}

}
