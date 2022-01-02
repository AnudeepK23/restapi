package com.example.bank.controller;


import com.example.bank.Service.BankService;
import com.example.bank.model.Bank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
//@CrossOrigin(origins="http://localhost:4200")
@RestController
public class BankController {

    @Autowired
    BankService service;

    @PostMapping( value = "/saveBan" ,consumes = MediaType.APPLICATION_JSON_VALUE ,produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<Bank> print(@RequestBody Bank Bn)
    {
        service.store(Bn);
        return new ResponseEntity<Bank>(Bn, HttpStatus.CREATED);
    }

    @GetMapping( value = "/Banks" ,produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<List<Bank>> getBns()
    {
        List<Bank> list=service.getBanks();
        return new ResponseEntity<List<Bank>>(list,HttpStatus.CREATED);
    }

    @GetMapping( value = "/Bank/{id}" ,produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<Bank> getBn(@PathVariable("id") int id)
    {
        Bank Bn=service.getBank(id);
        return new ResponseEntity<Bank>(Bn, HttpStatus.CREATED);
    }

    @PutMapping( value = "/Bank" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Bank> updateBn(@RequestBody Bank Bn)
    {
        service.store(Bn);
        return new ResponseEntity<Bank>(Bn,HttpStatus.CREATED);
    }

    @DeleteMapping( value = "/delete/{id}" ,consumes = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<String> deleteBank(@PathVariable("id") int id)
    {
        service.deleteBn(id);
        return new ResponseEntity<String>("recorded deleted",HttpStatus.CREATED);
    }





}
