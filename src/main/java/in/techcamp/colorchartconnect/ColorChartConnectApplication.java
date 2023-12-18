package in.techcamp.colorchartconnect;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "in.techcamp.colorchartconnect.entity")
public class ColorChartConnectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ColorChartConnectApplication.class, args);
	}
}
