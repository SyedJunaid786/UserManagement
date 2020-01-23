package com.layers.Repository;

import org.springframework.stereotype.Repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.layers.Model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long>
{

}
