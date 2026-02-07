package com.ncm.hrms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ncm.hrms.entity.Technology;

public interface TechnologyRepository extends JpaRepository<Technology, Long> {

Optional<Technology> findByName(String name);
}
