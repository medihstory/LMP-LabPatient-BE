package com.medihstory.patient.domains.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.medihstory.lut.domains.entities.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity(name = "LmpPatientEn")
@Table(name = "lmp_patients", uniqueConstraints = {@UniqueConstraint(name="patient_phone_number_uk", columnNames="phone_number")})
public class PatientEntity extends BaseEntity{
	
	@Id
	@SequenceGenerator(name = "patient_id", sequenceName = "lmp_patient_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lmp_patient_sequence")
	@Column(name = "patient_id", updatable = false)
	private Long id;
	
//	@Column(name = "pat_system_id", updatable = false, length = 256)
//	private String patSystemId;
	
	@Column(name = "first_name", nullable = false, length = 1024)
	private String firstName;
	
	@Column(name = "middle_name", length = 1024)
	private String middleName;
	
	@Column(name = "last_name", length = 1024)
	private String lastName;
	
	 
	@Column(name = "date_of_birth")
	private LocalDateTime dateOfBirth;
	
	@Column(name = "age")
	private Integer age;
	
	@Size(min = 10, message = "Phone number should be of 10 digits")
	@Column(name = "phone_number", length = 11)
	private String phoneNumber;
	
	@Column(name = "address", length = 2048)
	private String address;
	
	@Email(message = "Email format is not valid")
	@NotBlank(message = "Email cannot be empty")
	@Column(name = "email", length = 2048)
	private String email;
	
	
	@Column(name = "referral_id", length = 2048)
	private String referralId;
	
	@Column(name = "member_count")
	private Integer memberCount;
	
	@Column(name = "balance")
	private Double balance;
	
	@Column(name = "total_credit")
	private Double totalCredit;
	
	@Column(name = "unapplied_credit")
	private Double unappliedcredit;
	
	@Column(name = "pratition_id")
	private Integer partitionId;
	
	@Column(name = "pratition_id")
	private long createdBy;
}
