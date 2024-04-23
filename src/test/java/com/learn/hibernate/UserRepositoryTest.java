package com.learn.hibernate;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.learn.hibernate.entity.UserEntity;
import com.learn.repository.UserRepository;

import lombok.extern.log4j.Log4j2;


@RunWith(SpringRunner.class)
@TestPropertySource(value = "/application.properties")
@Transactional(propagation = Propagation.NOT_SUPPORTED)
@DataJpaTest
@AutoConfigureTestDatabase(replace= Replace.NONE)
@Log4j2
class UserRepositoryTest {

	@Autowired
	UserRepository userRepository;

    @Autowired
    TestEntityManager entityManager;
    
    @Test
    void testFindAll() {
        List<UserEntity> userList = userRepository.findAll();
        userList.stream().map(a-> a.toString()).forEach(log::info);
        assertThat(userList).isNotEmpty();
    }
    
    @Test
    void testFindUsersCreatedToday() {
        List<UserEntity> userList = userRepository.findUsersCreatedToday();
        userList.stream().map(a-> a.toString()).forEach(log::info);
        assertThat(userList).isNotEmpty();
    }
    
    @Test
    void testFindByName() {
    	Optional<UserEntity> userEntityOpt = userRepository.findByName("dog");
        assertTrue(userEntityOpt.isPresent());
    }
       
    @Test
    void testSave() {	
    	UserEntity userEntity = UserEntity.builder().build();
    	UserEntity userEntitySave = null; //TODO userRepository......
    	assertThat(userEntitySave).isNotNull();
    }
    
    @Test
    void testHQLlike() {
    	String nameToFind = "cat";
    	List<UserEntity> userList = Collections.emptyList(); //TODO userRepository......
    	assertEquals(1, userList.size());
    }
    
    @Test
    void testFindUsersCreatedByYear() {
    	Integer year = Integer.valueOf(2023);
    	List<UserEntity> userList = Collections.emptyList(); //TODO userRepository......
    	assertEquals(3, userList.size());
    }
    
    
}