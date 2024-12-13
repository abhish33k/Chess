package com.Dadhich.Chess.Repository;

import com.Dadhich.Chess.Model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {

    // Fetch users by name (query derivation)
    List<User> findByName(String name);

    // Fetch users by last name (query derivation)
    List<User> findByLastName(String lastName);

    // Fetch users by email using a custom query
    @Query("{ 'email': ?0 }")
    User findUserByEmail(String email);

    // Fetch users whose name contains a keyword (custom query with regex)
    @Query("{ 'name': { $regex: ?0, $options: 'i' } }")
    List<User> findUsersByNameContaining(String keyword);


}
