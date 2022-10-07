package com.vallerry.opcd.data;

import com.vallerry.opcd.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User getUserByEmailAndPassword(String email, String password);
}
