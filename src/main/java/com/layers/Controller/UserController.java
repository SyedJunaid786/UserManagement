package com.layers.Controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.layers.Model.User;
import com.layers.Service.UserService;

@RestController
@RequestMapping("/users")
public class UserController 
{
	@Autowired
	private UserService userservice;

	@GetMapping("")
	@ResponseBody
	public ResponseEntity<List<User>> getUsers() 
	{
	 // read from database
	 List<User> users = userservice.getUsers();
	 return ResponseEntity.ok(users);  // return 200, with json body
	}

	@GetMapping("/{id}")
	@ResponseBody
	public ResponseEntity<User> getUser(@PathVariable("id") Long id) 
	{
		Optional<User> user = userservice.findById(id);
		if (user.isPresent()) 
		{
			return new ResponseEntity<User>(HttpStatus.OK);
		} 
		else 
		{
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}

	}
	
	@PostMapping("")
	public ResponseEntity<Void> saveUser(@Valid @RequestBody User user) throws URISyntaxException
	{
	 try
	 {
	  // save to database
	  User newUser = userservice.save(user);
	  return ResponseEntity.created(new URI("/user/"+newUser.getId())).build();
	 } 
	 catch (Exception e)
	 {
	  // log exception first, then return Conflict (409)
	  return ResponseEntity.status(HttpStatus.CONFLICT).build();
	 }
	}

	/*
	 * @PutMapping("/saveUser")
	 * 
	 * @ResponseStatus(HttpStatus.OK) public User
	 * saveOrUpdateUser(@Valid @RequestBody User user) { userservice.save(user);
	 * return user; }
	 */
	
	@PutMapping("/{id}")
	public ResponseEntity<User> saveOrUpdateUser(@RequestBody User user, @PathVariable long id)
	{

		Optional<User> userOptional = userservice.findById(id);

		if (!userOptional.isPresent())
			return ResponseEntity.notFound().build();

		user.setId(id);
		
		userservice.save(user);

		return ResponseEntity.noContent().build();
	}

	
	  @DeleteMapping("/{id}") 
	  public ResponseEntity<Void> deleteById(@PathVariable("id") Long id) 
	  {  
		  try 
		     {
			  userservice.deleteById(id);
			  return ResponseEntity.noContent().build();
			 }
		  catch (Exception e)
		     {
			  return ResponseEntity.notFound().build();
			 }
	  }
	 

	/*
	 * @DeleteMapping("/user/{id}") public ResponseEntity<?>
	 * deleteById(@PathVariable("id") long id) {
	 * logger.info("Fetching & Deleting User with id {}", id); ResponseEntity<User>
	 * user = userservice.findById(id); if (user == null) {
	 * logger.error("Unable to delete. User with id {} not found.", id); return new
	 * ResponseEntity(new CustomErrorType("Unable to delete. User with id " + id +
	 * " not found."), HttpStatus.NOT_FOUND); } userservice.deleteById(id); return
	 * new ResponseEntity<User>(HttpStatus.NO_CONTENT); }
	 */
   
}
