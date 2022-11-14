package basepackage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import basepackage.service.DataLoad;

@SpringBootApplication
@EnableAutoConfiguration
public class Application  {
    public static void main(String[] args){
        SpringApplication.run(Application.class, args);   }

}