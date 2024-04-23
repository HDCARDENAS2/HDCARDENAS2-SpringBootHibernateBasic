package com.learn.hibernate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.learn.hibernate.entity.UserEntity;

import lombok.extern.log4j.Log4j2;
@RunWith(JUnit4.class)
@Log4j2
class HibernateExampleTest {

	private static SessionFactory sessionFactory;

	@BeforeEach
	void setUp() {
		log.error("setUp");
		Configuration config = new Configuration();
        config.configure();
        sessionFactory = config.buildSessionFactory();
    }
    
	@AfterEach
    void tearDown() {
		 log.error("tearDown");
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }
	
    @Test
    void testFetchUsers() {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            List<UserEntity> users = session.createQuery("FROM UserEntity").getResultList();
            users.stream().map(a-> a.toString()).forEach(log::info);
            assertThat(users).isNotEmpty();
        
        } catch (Exception e) {
            fail("Exception occurred "+e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}