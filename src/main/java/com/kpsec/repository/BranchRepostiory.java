package com.kpsec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kpsec.model.dto.Branch;

public interface BranchRepostiory  extends JpaRepository<Branch, String> {

}
