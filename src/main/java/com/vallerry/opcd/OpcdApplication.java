package com.vallerry.opcd;

import com.vallerry.opcd.service.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

@SpringBootApplication
public class OpcdApplication implements CommandLineRunner {

	@Resource
	StorageService storageService;

	public static void main(String[] args) {
		SpringApplication.run(OpcdApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		storageService.deleteAll();
		storageService.init();
	}
}
