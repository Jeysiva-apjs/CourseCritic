package com.jey.coursecritic.repository;


import org.springframework.data.repository.CrudRepository;

import com.jey.coursecritic.entity.Admin;


public interface AdminRepository extends CrudRepository<Admin, Long>{
    
}
