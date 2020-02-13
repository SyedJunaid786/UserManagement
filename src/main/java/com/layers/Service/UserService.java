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

	/*
	 * private CollectionEntry entityToform(Collection collection) { CollectionEntry
	 * collectionEntry = new CollectionEntry();
	 * collectionEntry.setId(collection.getId());
	 * collectionEntry.setName(collection.getName());
	 * collectionEntry.setNumberOfLooks(collection.getNumberOfLooks());
	 * 
	 * collectionEntry.setStylist(collection.getStylist());
	 * collectionEntry.setCollectionUrl(collection.getCollectionUrl());
	 * collectionEntry.setDisplayImage(collection.getDisplayImage());
	 * collectionEntry.setPosition(collection.getPosition()); return
	 * collectionEntry; }
	 * 
	 * private Collection formToentity(CollectionEntry collectionEntry) { Collection
	 * collection = new Collection(); collection.setId(collectionEntry.getId());
	 * collection.setName(collectionEntry.getName());
	 * collection.setNumberOfLooks(collectionEntry.getNumberOfLooks());
	 * collection.setStylist(collectionEntry.getStylist());
	 * collection.setCollectionUrl(collectionEntry.getCollectionUrl());
	 * collection.setDisplayImage(collectionEntry.getDisplayImage());
	 * collection.setPosition(collectionEntry.getPosition()); return collection; }
	 * 
	 * @CachePut(value = "masterclassCollectionByStylist", key =
	 * "#collectionEntry.stylist.id")
	 * 
	 * @CacheEvict(value = "masterclassCollectionByUidx", allEntries = true) public
	 * CollectionEntry createCollection(CollectionEntry collectionEntry) {
	 * Optional<Stylist> stylist =
	 * stylistRepository.findById(collectionEntry.getStylist().getId()); if
	 * (stylist.isPresent()) { Collection collection =
	 * formToentity(collectionEntry); collection.setStylist(stylist.get());
	 * collection = collectionRepository.save(collection); collectionEntry =
	 * entityToform(collection); } else { throw new
	 * ResourceNotFound(ErrorConstants.NO_STYLIST_FOUND); } return collectionEntry;
	 * }
	 */
	
	 
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
