package com.layers.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Collections.Entity.OrderResponse;
import com.layers.Model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer>
{
	@Query("select new com.Collections.Entity.OrderResponse(c.name,c.email,p.productName,p.price,p.qty) From Customer c JOIN c.products p")
	public List<OrderResponse> getJoinDetails();
	
    @Query("select new com.Collections.Entity.OrderResponse(c.name,c.email,p.productName,p.price,p.qty) From Customer c JOIN c.products p where cp_fk=?1")
	public List<OrderResponse> getJoinDetailsById(Integer id);
}
