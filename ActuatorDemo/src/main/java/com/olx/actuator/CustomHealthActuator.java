package com.olx.actuator;

import java.util.Random;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health.Builder;

public class CustomHealthActuator extends AbstractHealthIndicator {

	@Override
	protected void doHealthCheck(Builder builder) throws Exception {
		// TODO Auto-generated method stub
		Random random=new Random();
		int randomValue=random.nextInt(100);
		if(randomValue%2==0) {
			builder.down();
			
			
			
			
		}else {
			builder.up();
		}
		
		
	}

}
