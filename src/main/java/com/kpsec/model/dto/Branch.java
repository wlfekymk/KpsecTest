package com.kpsec.model.dto;

import javax.persistence.Entity;
import javax.persistence.IdClass;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder @Data @NoArgsConstructor @AllArgsConstructor @Entity
public class Branch {
	@Id
	private String branchCode;
	private String branchName;
}
