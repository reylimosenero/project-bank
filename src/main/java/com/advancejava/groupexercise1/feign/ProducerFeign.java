package com.advancejava.groupexercise1.feign;

import com.advancejava.groupexercise1.entity.Account;
import com.advancejava.groupexercise1.helper.model.Deposit;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "producerFeign", url = "${app.producer.url}")
public interface ProducerFeign {


    @PostMapping("/api/v1/producer/accounts")
    public void createAccount(@RequestBody Account acct);

    @PostMapping("/api/v1/producer/accounts/{id}/transactions")
    public void deposit(@RequestBody Deposit deposit, @PathVariable Integer id);
}
