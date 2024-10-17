package ra.testrestfullapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.testrestfullapi.model.entity.Account;
import ra.testrestfullapi.service.account.IAccountService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/accounts")
public class AccountController {
    @Autowired
    IAccountService accountService;

    @GetMapping
    public ResponseEntity<List<Account>> findAllAccount(){
        List<Account> accounts = accountService.findAll();
        if (accounts.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(accounts, HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account> findAccountById(@PathVariable("id") Integer id){
        Account account = accountService.findById(id);
        if (account == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<>(account, HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<Account> saveAccount(@RequestBody Account account){
        return new ResponseEntity<>(accountService.save(account), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Account> updateAccount(@PathVariable Integer id, @RequestBody Account account){
        Account accountOptional = accountService.findById(id);
        if (accountOptional == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<>(accountService.update(account,id), HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Account> deleteAccount(@PathVariable Integer id){
        Account account = accountService.findById(id);
        if (account == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            accountService.delete(id);
            return new ResponseEntity<>(account, HttpStatus.NO_CONTENT);
        }
    }
}
