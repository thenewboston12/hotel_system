package nu.swe.hotel_chain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

//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

@SpringBootApplication
public class HotelChainApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelChainApplication.class, args);
	}


}
