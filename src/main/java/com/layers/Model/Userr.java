package com.layers.Model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Userr implements Serializable
{
	@Id
    private Long id;
    private String username;
	private String password;
	private String email;
	private String number;
	private String address;
	
	public Userr(Long id, String username, String password, String email, String number, String address)
	{
		this.username = username;
		this.password = password;
		this.email = email;
		this.number = number;
		this.address = address;
	}
	
}
