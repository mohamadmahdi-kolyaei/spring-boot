package com.example.demo.customer;

import com.example.demo.exceptions.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


// it creat a bean that we can inject in multiple places , if we inject it in different classes  we are getting the same instance instead of creating multiple object
@Service
@Slf4j
public class CustomerService {

    private final static Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);

//    private final CustomerRepo customerRepo;  we no longer need this because we are connecting to real DB

    private final CustomerRepository customerRepository;
    private final CustomerDTOMapper customerDTOMapper;

    @Autowired // it's not necessary , it's optional , I prefer to use it because I like things be documented
    public CustomerService( // @Qualifier
                            CustomerRepository customerRepository, CustomerDTOMapper customerDTOMapper) {
        this.customerRepository = customerRepository; // we can delete this constructor and use AllArgConstructor annotation
        this.customerDTOMapper = customerDTOMapper;
    }

//   public List <Customer> getCustomers(){
////        LOGGER.info("get customer was called  "); we can use lombok for logging  with @Slf4j annotation
//
//       log.info("get customer was called  ");
//       return customerRepository.findAll();
//    }


    public List <CustomerDTO> getCustomers(){
//        LOGGER.info("get customer was called  "); we can use lombok for logging  with @Slf4j annotation

        log.info("get customer was called  ");
        return customerRepository.findAll().stream().map(customer -> new CustomerDTO(customer.getName() , customer.getEmail())).collect(Collectors.toList());
    }



//    Customer getCustomer( Long id ){
//
////        return getCustomers()
////                .stream()
////                .filter(customer -> customer.getId().equals(id) )
////                .findFirst()
////                .orElseThrow( () -> new NotFoundException("customer with id  " + id + "  not found ") );
//
//        return customerRepository.findById(id)
//                .orElseThrow( ()-> {
//                    NotFoundException notFoundException = new NotFoundException("customer with id  " + id + "  not found ");
//                    LOGGER.error("error in getting costumer {} " ,id, notFoundException );
//                    return notFoundException;
//                });
//    }



    CustomerDTO getCustomer( Long id ){

//        return getCustomers()
//                .stream()
//                .filter(customer -> customer.getId().equals(id) )
//                .findFirst()
//                .orElseThrow( () -> new NotFoundException("customer with id  " + id + "  not found ") );

        return customerRepository.findById(id).map(customerDTOMapper)
                .orElseThrow( ()-> {
                    NotFoundException notFoundException = new NotFoundException("customer with id  " + id + "  not found ");
                    LOGGER.error("error in getting costumer {} " ,id, notFoundException );
                    return notFoundException;
                });
    }

}
