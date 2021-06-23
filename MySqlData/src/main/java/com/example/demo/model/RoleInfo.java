package com.example.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "role_info")
public class RoleInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ROLEID")
	Integer id;
	
//	@Column(name = "APPLICATIONID")
//	Integer applicationId;
	
	@Column(name = "ROLECODE")
	Integer rolecode;
	@Column(name = "ROLENAME")
	String rolename;
    @Column(name = "CREATED_BY")
	String createdby;
	@Column(name = "CREATED_ON")
	Date createdon;
	@Column(name = "UPDATED_BY")
	String updatedby;
	@Column(name = "UPDATED_ON")
	Date updatedon;
	@Column(name = "ISACTIVE")
	Character isactive;
	
	
	@ManyToOne
	@JoinColumn(name="APPLICATIONID")
	Application application;

}
