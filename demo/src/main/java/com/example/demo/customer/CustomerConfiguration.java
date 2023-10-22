package com.example.demo.customer;

import com.example.demo.infoapp.InfoApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class CustomerConfiguration {
    // we often use this class when we want to do kind of some setup , when application starts, and we can inject  few services or classes that
    // we can use dependency injection in input method  , and sometimes we want to add something to our database  as soon as application start
    // for us to tell spring it has to be Initialised we can use @Bean which means it is instantiated for us and any cod inside here is executed

    @Value("${app.userFakeCustomerRepo:false}")
    private boolean useFakeCustomerRepo;

    @Value("${info.company.name}")  // we have the value from .properties inside here . we have injected to here . we can do this in the following example
    private String companyName;
    @Autowired
    private Environment environment;

    @Bean
    CommandLineRunner commandLineRunner(InfoApp infoApp ,CustomerRepository customerRepository){
        return args -> {
            System.out.println("hoooooooooooooooooooooooooora");
            System.out.println(companyName);
            System.out.println(environment.getProperty("info.app.version"));
            System.out.println(infoApp);
            // you see this quite a lot for bringing zdatabase username , URL into a class as we have done

//            customerRepository.save(new Customer(444L,"hadi" ,"haloo" ,"hadi@gmail.com"));
        };
    }
}
