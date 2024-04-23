package com.learn.hibernate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.learn.hibernate.entity.UserEntity;

import lombok.extern.log4j.Log4j2;
@RunWith(JUnit4.class)
@Log4j2
class JPAExampleTest {

	private static EntityManagerFactory factory;

	@BeforeEach
	void setUp() {
		log.error("setUp");
        factory = Persistence.createEntityManagerFactory("basicJPA"); 
    }
    
	@AfterEach
    void tearDown() {
		 log.error("tearDown");
        if (factory != null) {
        	factory.close();
        }
    }
	
    @Test
    void testFetchUsers() {

    	EntityManager em = factory.createEntityManager();
    	
        try {
            Query query = em.createQuery("SELECT u FROM UserEntity u");
            List<UserEntity> users = query.getResultList();
            users.stream().map(a-> a.toString()).forEach(log::info);
            assertThat(users).isNotEmpty();
        
        } catch (Exception e) {
            fail("Exception occurred "+e.getMessage());
        } finally {
            if (em != null) {
            	em.close();
            }
        }
    }

}
