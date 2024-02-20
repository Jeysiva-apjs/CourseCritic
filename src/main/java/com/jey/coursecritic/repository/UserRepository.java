package com.jey.coursecritic.repository;



import org.springframework.data.repository.CrudRepository;

import com.jey.coursecritic.entity.User;


public interface UserRepository extends CrudRepository<User, Long>{

    
} 
