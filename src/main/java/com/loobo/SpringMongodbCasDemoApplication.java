package com.loobo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.retry.annotation.EnableRetry;

import javax.swing.plaf.ButtonUI;
import java.util.UUID;

@SpringBootApplication
//@EnableAspectJAutoProxy
@EnableRetry
public class SpringMongodbCasDemoApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringMongodbCasDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
}
