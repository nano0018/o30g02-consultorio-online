package co.edu.uis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;


@SpringBootApplication
public class O30g02ConsultorioOnlineApplication{
	private static String test1 = System.getenv("SPRING_DATASOURCE_URL");
	private static String test2 = System.getenv("SPRING_DATASOURCE_USERNAME");
	private static String test3 = System.getenv("SPRING_DATASOURCE_PASSWORD");
	public static void main(String[] args) {
		System.out.println(test1);
		System.out.println(test2);
		System.out.println(test3);
		SpringApplication.run(O30g02ConsultorioOnlineApplication.class, args);

	}	

}
