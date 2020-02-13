package com.layers.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Customer 
{
	@Id
	@GeneratedValue
	int id;
	private String name;
	private String email;
	private String gender;
	
	@OneToMany(targetEntity = Products.class,cascade=CascadeType.ALL)
	@JoinColumn(name="cp_fk", referencedColumnName="id")
    private List<Products> products;
}
