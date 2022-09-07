package com.crio.codingame.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


import com.crio.codingame.entities.User;

public class UserRepository implements IUserRepository{

    private final Map<String,User> userMap;
    private Integer autoIncrement = 0;

    public UserRepository(){
        userMap = new HashMap<String,User>();
    }

    public UserRepository(Map<String, User> userMap) {
        this.userMap = userMap;
        this.autoIncrement = userMap.size();
    }

    @Override
    public User save(User entity) {
        if( entity.getId() == null ){
            autoIncrement++;
            User u = new User(Integer.toString(autoIncrement),entity.getName(),entity.getScore());
            userMap.put(u.getId(),u);
            return u;
        }
        userMap.put(entity.getId(),entity);
        return entity;
    }

    
    // Find all the list of User Present in the Repository
    // Tip:- Use Java Streams

    @Override
    public List<User> findAll() {
        List<User> userList = new ArrayList<>();
      for (String key:userMap.keySet()){
        userList.add(userMap.get(key));
      }
     return userList;
    }

    @Override
    public Optional<User> findById(String id) {
        return Optional.ofNullable(userMap.get(id));
    }

    @Override
    public boolean existsById(String id) {
       
        return false;
    }

    @Override
    public void delete(User entity) {
     
        
    }

    @Override
    public void deleteById(String id) {
      
        
    }

    @Override
    public long count() {
   
        return 0;
    }

  
    // Find the User Present in the Repository provided name
    // Tip:- Use Java Streams

    @Override
    public Optional<User> findByName(String name) {
   
     List<User> userName = new ArrayList<>();
        for (String key:userMap.keySet()){
            if (userMap.get(key).getName()==name){
                System.out.println(userMap.get(key));
                userName.add(userMap.get(key));
                return Optional.of(userMap.get(key));
              
            }   
        }
     return Optional.empty();
    }
    
}
