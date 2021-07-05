package com.spring.veeru.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author virupaksha.kuruva
 *
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

	@Id
	@SequenceGenerator(name = "user_sequence",
					   sequenceName = "user_sequence",
					   allocationSize = 1)
	@GeneratedValue(strategy =GenerationType.SEQUENCE,
					generator = "user_sequence")
	private int id;
	private String userName;
	private String password;
	private boolean enabled;
	private String roles;
	
	
	
}
