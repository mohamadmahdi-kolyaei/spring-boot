package com.example.demo.infoapp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
@Configuration
@ConfigurationProperties(prefix = "info.app")  // for this we have to annotation processor configured  , and we added a new dependency 			<artifactId>spring-boot-configuration-processor</artifactId>
@Data   // this class can not have final field because we are using this annotation  @ConfigurationProperties so we cant use record for this class
public class InfoApp {
    // we mapped our configuration to a class
    private String name;
    private String description;
    private String version;



//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public String getVersion() {
//        return version;
//    }
//
//    public void setVersion(String version) {
//        this.version = version;
//    }
//
//    @Override
//    public String toString() {
//        return "infoApp{" +
//                "name='" + name + '\'' +
//                ", description='" + description + '\'' +
//                ", version='" + version + '\'' +
//                '}';
//    }
}
