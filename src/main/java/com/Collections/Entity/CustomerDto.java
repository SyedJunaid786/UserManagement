package com.Collections.Entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.layers.Model.Customer;
import com.layers.Model.Products;

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
public class CustomerDto implements Serializable
{
	private static final long serialVersionUID = 1L;
	@Id
 	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	private String name;
	private String email;
	private String gender;
	
	@OneToMany(targetEntity = Products.class,cascade=CascadeType.ALL)
	@JoinColumn(name="cp_fk", referencedColumnName="id")
    private List<Products> products;
	
//	private Customer customer;
}
