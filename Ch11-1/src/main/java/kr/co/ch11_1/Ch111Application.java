package kr.co.ch11_1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("kr.co.ch11_1.dao")
public class Ch111Application {

	public static void main(String[] args) {
		SpringApplication.run(Ch111Application.class, args);
	}

}
