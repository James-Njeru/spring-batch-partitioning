package com.example.batch_project.config;

import com.example.batch_project.entity.Customer;
import com.example.batch_project.repository.CustomerRepository;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerWriter implements ItemWriter<Customer> {
    @Autowired
    CustomerRepository customerRepository;


    @Override
    public void write(Chunk<? extends Customer> chunk) throws Exception {
        System.out.println("Thread name :: "+Thread.currentThread().getName());
        customerRepository.saveAll(chunk);
    }
}
