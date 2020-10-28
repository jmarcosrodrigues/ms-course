package br.com.jm.hruser.recources;

import br.com.jm.hruser.entities.User;
import br.com.jm.hruser.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    private UserRepository userRepository;

    @Autowired
    public UserResource(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        User obj = userRepository.findById(id).get();
        return ResponseEntity.ok(obj);
    }

    @GetMapping(value = "/search")
    public ResponseEntity<User> findByEmail(@RequestParam String email){
        User obj = userRepository.findByEmail(email);
        return ResponseEntity.ok(obj);
    }





}
