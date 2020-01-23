package com.layers.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.layers.Model.User;
import com.layers.Repository.UserRepository;

@Service
public class UserService
{
	@Autowired
	private UserRepository userrepo;

	public List<User> getUsers()
	{
		return userrepo.findAll();
	}

	public Boolean getUser(Long id)
	{
		 userrepo.findById(id);
		 return true;
	}

    public User save(User user) 
    {
    	user = userrepo.save(user); 
    	return user;
    }
    
    public Boolean getOne(Long id)
	{
		 userrepo.getOne(id);
		 return true;
	}
	 	    
	/*
	 * public User save(User user) throws Exception { if (user == null ||
	 * user.getId() == null) { throw new Exception("Missing Data"); } else {
	 * userrepo.save(user); return user; }
	 * 
	 * }
	 */
	/*
 	 * if (user == null || user.getId() == null) { throw new
	 * ResourceNotFoundException("Empty", "Missing Data Exception"); } else { User
	 * user = userRepository.save(user); return new Response(user.getId); }
	 */
    
	/*
	 * public ResponseEntity<User> findById(Long id) { User
	 * user=userrepo.findById(id).get(); return new
	 * ResponseEntity<User>(HttpStatus.OK); }
	 */
	 
    public Optional<User> findById(Long id) 
	{		
    	 Optional<User> user=userrepo.findById(id);
    	  return user;
	}
    	 
    
	public void deleteById(Long id) 
	{		
      userrepo.deleteById(id);
    }

}
