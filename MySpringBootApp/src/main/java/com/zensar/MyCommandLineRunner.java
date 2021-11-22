package com.zensar;
import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class MyCommandLineRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		
		System.out.print("MyCommandLineRunner: "+Arrays.toString(args));
		// TODO Auto-generated method stub
		
	}

}
