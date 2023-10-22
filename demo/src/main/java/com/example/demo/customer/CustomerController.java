package com.example.demo.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping(path = "api/v1/customer")
@RestController  // it allows us to send http request by using some annotation( getMapping , postMapping and...) , we can handle http request
@Deprecated  // this is deprecated, and you should be using version 2 of our API
public class CustomerController {

   private final CustomerService customerService;
    @Autowired // this is optional , we don't have to do this , we are saying we want to inject(autowired) customerService in input of method .
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping (value = "all")    // tell spring that is a resource that a client can consume .  it sends data to our client, so client request data, and we send it back
    List <CustomerDTO> getCustomer(){
        return customerService.getCustomers();
    }

    @PostMapping  //with  @requestBody,  we take a json and map it to our customer class
    void creatNewCustomer( @RequestBody Customer customer){
        System.out.println("POST request...");
        System.out.println(customer);

    }

    @PutMapping
    void updateCustomer( @RequestBody Customer customer){
        System.out.println("Update request...");
        System.out.println(customer);

    }

    @DeleteMapping(path = "{customerId}")
    void deleteCustomer(@PathVariable("customerId") Long id){
        System.out.println("Delete request for customer with id " + id);
    }


}




