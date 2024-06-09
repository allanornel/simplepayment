package com.simplepayment.services;

import com.simplepayment.domain.user.EUserType;
import com.simplepayment.domain.user.User;
import com.simplepayment.dtos.UserDTO;
import com.simplepayment.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void validateTransaction(User sender, BigDecimal amount) throws Exception {
        if (sender.getUserType() == EUserType.MERCHANT) {
            throw new Exception("Usuário do tipo Lojista não está autorizado a realizar transação.");
        }

        if (sender.getBalance().compareTo(amount) < 0) {
            throw new Exception("Saldo insuficiente.");
        }
    }

    public User findUserById(long id) throws Exception {
        return this.userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado"));
    }

    public User findUserByIdWithLock(long id) throws Exception {
        return this.userRepository.findUserByIdWithLock(id).orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado"));
    }

    public void saveUser(User user) {
        this.userRepository.save(user);
    }

    public User createUser(UserDTO userDTO) throws Exception {
        User newUser = new User(userDTO);
        this.saveUser(newUser);
        return newUser;
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
}
