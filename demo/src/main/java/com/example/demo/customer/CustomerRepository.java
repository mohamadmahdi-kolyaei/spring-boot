package com.example.demo.customer;

import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

// when we annotate a class with @component , spring creates new instance the class that be annotated with singleton pattern that use one instance for when we want .
// for each class type (service,rest,DAO) we can use specific annotation
@Repository
@Primary
public interface CustomerRepository extends JpaRepository<Customer , Long> {

//  class  implements CustomerRepo   this is for when we had two fake repository to show we can switch between many repository by creating  an interface to do it
//    @Override
//    public List<Customer> getCustomers() {
//        // TODO connect to real DB
//        return Collections.singletonList(
//                new Customer(1L , "TODO. implement real DB ", "toDo", "email@gmail.com")
//        );
//    }
}
