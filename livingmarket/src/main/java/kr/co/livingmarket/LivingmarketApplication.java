package kr.co.livingmarket;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("kr.co.livingmarket")
public class LivingmarketApplication {

	public static void main(String[] args) {
		SpringApplication.run(LivingmarketApplication.class, args);
	}

}
