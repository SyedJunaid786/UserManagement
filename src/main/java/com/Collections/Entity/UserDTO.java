package com.Collections.Entity;

import java.io.Serializable;
import javax.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class UserDTO implements Serializable
{
	private static final long serialVersionUID = 1L;
	
    private String username;
	private String password;
	private String email;
	private String number;
	private String address;
	    
	public UserDTO(String username, String password, String email, String number, String address)
	{
		this.username = username;
		this.password = password;
		this.email = email;
		this.number = number;
		this.address = address;
	}
	
}
