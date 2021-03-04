package de.leuphana.shop.cartmicroservice.connector;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
@SpringBootApplication
@EnableFeignClients
@ImportResource
public class CartServiceApplication  implements CommandLineRunner{

    private static ApplicationContext applicationContext;

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public static void main(String[] args) {
        SpringApplication.run(CartServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        applicationContext = new ClassPathXmlApplicationContext("applicationcontext.xml");
    }
    
}
