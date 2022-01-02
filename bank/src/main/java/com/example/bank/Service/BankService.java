package com.example.bank.Service;

import com.example.bank.model.Bank;
import com.example.bank.repository.BankRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankService {
    @Autowired
    BankRepo repo;

    public void store(Bank Bn) {
        repo.save(Bn);
    }

    public List<Bank> getBanks() {

        List<Bank> list=repo.findAll();

        return list;
    }

    public Bank getBank(int id) {

        Bank Bn=repo.findById(id).orElse(new Bank());

        return Bn;
    }

    public void deleteBn(int id) {

        repo.deleteById(id);
    }


}
