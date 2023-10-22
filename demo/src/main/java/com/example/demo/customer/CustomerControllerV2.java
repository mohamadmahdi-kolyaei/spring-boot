package com.example.demo.customer;

import com.example.demo.exceptions.ApiRequestException;
import com.example.demo.jsonplaceholder.JSONPlaceHolderClient;
import com.example.demo.jsonplaceholder.Post;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RequestMapping(path = "api/v2/customers")
@RestController  // it allows us to send http request by using some annotation( getMapping , postMapping and...) , we can handle http request
public class CustomerControllerV2 {

   private final CustomerService customerService;
    @Autowired // this is optional , we don't have to do this , we are saying we want to inject(autowired) customerService in input of method .
    public CustomerControllerV2(CustomerService customerService) {
        this.customerService = customerService;
    } // we can delete this constructor and use AllArgConstructor annotation

    @GetMapping     // tell spring that is a resource that a client can consume .  it sends data to our client, so client request data, and we send it back
    List <CustomerDTO> getCustomers(){

        return customerService.getCustomers();

    }

    @GetMapping (path = "{customerId}")    // tell spring that is a resource that a client can consume .  it sends data to our client, so client request data, and we send it back
    CustomerDTO getCustomer(@PathVariable("customerId") Long id ){

        return customerService.getCustomer(id);
    }

    @GetMapping (path = "{customerId}/exception")    // tell spring that is a resource that a client can consume .  it sends data to our client, so client request data, and we send it back
    Customer getCustomerException(@PathVariable("customerId") Long id ){

        throw new ApiRequestException("ApiRequestException for id " + id);
    }



    @PostMapping  //with  @requestBody,  we take a json and map it to our customer class
    void creatNewCustomer( @Valid @RequestBody Customer customer){
        System.out.println("POST request...");
        System.out.println(customer);

    }

    @PutMapping
    void updateCustomer( @Valid @RequestBody Customer customer){
        System.out.println("Update request...");
        System.out.println(customer);

    }

    @DeleteMapping(path = "{customerId}")
    void deleteCustomer(@PathVariable("customerId") Long id){
        System.out.println("Delete request for customer with id " + id);
    }



}




