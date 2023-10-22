package com.example.demo.customer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
// we are not going to use @SpringBootTest because it isn't an integration test , this is a unit test
@DataJpaTest //  annotation is used to set up an in-memory database and configure the Spring Data JPA repositories for testing.
class CustomerServiceTest {
    @Autowired
    private CustomerRepository customerRepository;

    private CustomerService underTest;

    private final CustomerDTOMapper customerDTOMapper = new CustomerDTOMapper();

    @BeforeEach
    void setUp() {
        underTest = new CustomerService(customerRepository, customerDTOMapper);
    }

    @AfterEach
    void tearDown() {
//        customerRepository.deleteAll();
    }

    @Test
    @Transactional
    void getCustomers() {
        // given
        Customer jamila = new Customer(101L , "jamila" , "hello" ,"jamila@gmail.com" );
        Customer ali = new Customer(102L , "ali" , "hello" ,"ali@gmail.com" );
        customerRepository.saveAll(Arrays.asList(ali,jamila));

        // when

        List<CustomerDTO> customers = underTest.getCustomers();
        System.out.println(customers.size());
        // then
        assertEquals(102,customers.size());
    }

    @Test
    void getCustomer() {
        //given
        Customer jamila = new Customer(101L , "jamila" , "hello" ,"jamila@gmail.com" );
        customerRepository.save(jamila);


        // when
        CustomerDTO actual = underTest.getCustomer(101L);

        //then
//        assertEquals(101L,actual.getId());
//        assertEquals("jamila", actual.getName());
//        assertEquals("hello",actual.getPassword());
//        assertEquals("jamila@gmail.com",actual.getEmail());



        assertEquals("jamila", actual.name());
        assertEquals("jamila@gmail.com",actual.email());
    }
}