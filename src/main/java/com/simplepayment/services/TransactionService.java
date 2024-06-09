package com.simplepayment.services;

import com.simplepayment.domain.transaction.Transaction;
import com.simplepayment.domain.user.User;
import com.simplepayment.dtos.TransactionDTO;
import com.simplepayment.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private UserService userService;

    @Transactional
    public Transaction createTransaction(TransactionDTO transaction) throws Exception {
        User sender = this.userService.findUserByIdWithLock(transaction.senderId());
        User receiver = this.userService.findUserByIdWithLock(transaction.receiverId());

        this.userService.validateTransaction(sender, transaction.value());

        Transaction newTransaction = new Transaction();
        newTransaction.setSender(sender);
        newTransaction.setReceiver(receiver);
        newTransaction.setAmount(transaction.value());
        newTransaction.setTimestamp(LocalDateTime.now());

        sender.setBalance(sender.getBalance().subtract(transaction.value()));
        receiver.setBalance(receiver.getBalance().add(transaction.value()));

        this.transactionRepository.save(newTransaction);
        this.userService.saveUser(sender);
        this.userService.saveUser(receiver);

        return newTransaction;
    }
}
