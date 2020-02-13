package com.layers.Controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.Collections.Entity.CustomerDto;
import com.Collections.Entity.OrderResponse;
import com.layers.Model.Customer;
import com.layers.Repository.CustomerRepository;


@RestController
@RequestMapping(value="/api")
public class OrderController 
{
	@Autowired
	private CustomerRepository customerrepo;
	
//	@Autowired
//	private ProductsRepository productsrepo;
	
//	@PostMapping(value="/placeOrder")
//	public Customer PlaceOrder(@RequestBody OrderRequest request)
//	{	
//		return customerrepo.save(request.getCustomer());
//	}

	@PostMapping(value="/PlaceOrder")
    @ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
    public CustomerDto PlaceOrder(@RequestBody CustomerDto customerDto) throws ParseException 
	{    System.out.println("Inside placeOrder");
        Customer customer = convertToEntity(customerDto);
        Customer customerCreated = customerrepo.save(customer);
        return convertToDto(customerCreated);
    }		
	
	private Customer convertToEntity(CustomerDto customerDto) throws ParseException 
	{   System.out.println("Inside convertToEntity");
		ModelMapper modelMapper=new ModelMapper();
	    Customer customer = modelMapper.map(customerDto, Customer.class);
	    
	    System.out.println(customerDto.getId());
        
//		if (customerDto.getId() != null)
//	    {    
	    	Customer oldCustomer=customerrepo.getOne(customerDto.getId()); 
            
	        customer.setId(oldCustomer.getId());  
	        customer.setName(oldCustomer.getName());
	        customer.setEmail(oldCustomer.getEmail()); 
	        customer.setGender(oldCustomer.getGender());  
	        customer.setProducts(oldCustomer.getProducts());  
	        
//	    }    
	    return customer;
	}
	
	private CustomerDto convertToDto(Customer customer)
	{
		ModelMapper modelMapper=new ModelMapper();
	    CustomerDto customerDto = modelMapper.map(customer, CustomerDto.class);
	    customerDto.setName(customer.getName());
	    customerDto.setEmail(customer.getEmail());
	    customerDto.setGender(customer.getGender());    
	    customerDto.setProducts(customer.getProducts()); 
	    return customerDto;     
	}   

	
	  @GetMapping("/findAllOrders")
	  @ResponseBody
	  public List<CustomerDto> findAllOrders()
	  {
	    List<Customer> customers = customerrepo.findAll();
	    return customers.stream()
	                    .map(this::convertToDto)
	                    .collect(Collectors.toList());
	  }
	
	 
//	@GetMapping("/findAllOrders")
//	public List<Customer> findAllOrders()
//	{
//		return customerrepo.findAll();
//	}
	
	@GetMapping("/getJoinDetails")
	public List<OrderResponse> getJoinDetails()
	{
		return customerrepo.getJoinDetails();
	}
	
	@GetMapping("/getJoinDetailsById/{id}")
	public List<OrderResponse> getJoinDetailsById(@PathVariable Integer id)
	{
		return customerrepo.getJoinDetailsById(id);
	}
}
