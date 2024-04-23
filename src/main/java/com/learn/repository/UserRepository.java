package com.learn.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.learn.hibernate.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    @Query(nativeQuery = true, name = "queries.user.findUsersCreatedToday")
    List<UserEntity> findUsersCreatedToday();
    
    Optional<UserEntity> findByName(String name);
}
