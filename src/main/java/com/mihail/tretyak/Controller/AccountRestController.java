package com.mihail.tretyak.Controller;

import com.mihail.tretyak.Model.Account;
import com.mihail.tretyak.Repositoriy.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping(value = "/accounts")
public class AccountRestController {

    @Autowired
    private AccountRepository accountRepository;

    @RequestMapping(method = RequestMethod.GET)
    ResponseEntity<Object> getAccount(@PathParam(value = "email") String email) {
        Account account = accountRepository.getAccount(email);
        if (account != null) {
            return ResponseEntity.ok(account);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No such email");
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Object> postAccount(@RequestBody Account account) {
        if (accountRepository.addAccount(account)) {
            return ResponseEntity.ok("ok");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("This email already exists");
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteAccount(@PathParam(value = "email") String email) {
        if (accountRepository.deleteAccount(email)) {
            return ResponseEntity.ok("ok");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("This account doesn't exist");
    }
}