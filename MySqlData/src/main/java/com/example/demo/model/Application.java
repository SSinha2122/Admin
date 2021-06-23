package com.example.demo.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "application")
public class Application {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "APPLICATIONID")
	Integer applicationId;

	@Column(name = "APPLICATIONNAME")
	String applicationname;

	@Column(name = "APPLICATIONKEY")
	String applicationKey;

	@Column(name = "CREATED_BY")
	String created_by;

	@Column(name = "CREATED_ON")
	Date created_on;

	@Column(name = "UPDATED_BY")
	String updated_by;

	@Column(name = "UPDATED_ON")
	Date updated_on;

//	@OneToMany(targetEntity = RoleInfo.class,cascade = CascadeType.ALL)
//	@JoinColumn(name = "APPLICATIONID",referencedColumnName = "")
//	List<RoleInfo> role;
//	
//	
	
	
	@OneToMany(mappedBy = "application")
	List<RoleInfo> role;
	
   
}
