package co.develhope.noSqlOrmMongoDB.controller;

import co.develhope.noSqlOrmMongoDB.entities.User;
import co.develhope.noSqlOrmMongoDB.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository userRepo;

    @PostMapping("")
    public User userCreation(@RequestBody User user){
        return userRepo.save(user);
    }

    @GetMapping("{id}")
    public User getSingleUserbyID(@PathVariable String id) throws Exception {
       Optional<User>user = userRepo.findById(id);
       if(user.isPresent()){
           return user.get();
       }else{
           throw new Exception("User not found");
       }
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable String id, @RequestBody User user){
        user.setId(id);
        return userRepo.save(user);
    }
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable String id){
        userRepo.deleteById(id);
    }
}
