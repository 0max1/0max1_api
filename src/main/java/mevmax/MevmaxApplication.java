package mevmax;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.security.MessageDigest;

@SpringBootApplication
@MapperScan("mevmax.mapper")
public class MevmaxApplication {

	public static void main(String[] args) {
//		MessageDigest KECCAK = MessageDigest.getInstance("KECCAK256");
		SpringApplication.run(MevmaxApplication.class, args);
	}

}
