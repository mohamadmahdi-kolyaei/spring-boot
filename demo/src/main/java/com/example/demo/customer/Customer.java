package com.example.demo.customer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity // allow us to map this entity to a table
@Table
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Customer {
//    @JsonProperty("customerId")
    @Id
    private  Long id;
    @NotBlank(message = "name most not be empty")      // java spring-boot-starter-validation library
    private  String name;
    @NotBlank(message = "password most not be empty") // these annotations only works with @valid annotation . it doesn't add extra feature unless we activate them were we receive an object
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) // we couldn't post json customer because we used @JsonIgnore, and then we use this annotation to allow us to post json object
    private  String password;   // actually it allows us to send a password but not read the password from client

    @NotBlank(message = "email most not be empty")
    @Email(regexp ="^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+.com+$" )
    private  String email;



    public Customer( String name, String password, String email) {
        this.name = name;
        this.password = password;
        this.email = email;
    }



    public Long getId() {
        return id;
    }

//    public Long getCustomerId(){   jackson library use getter method for showing jason
//        return id;
//    }

    public String getName() {
        return name;
    }
    @JsonIgnore    // there are time when you don't want to send this property back to the client
    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }


}


