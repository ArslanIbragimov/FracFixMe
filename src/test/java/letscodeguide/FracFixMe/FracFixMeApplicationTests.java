package letscodeguide.FracFixMe;


import letscodeguide.FracFixMe.SeleniumTests.AuthTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;


@SpringBootTest
class FracFixMeApplicationTests {

	@Value("${server.address}")
	private String hostaddress;
	@Value("${server.port}")
	private String port;

	AuthTest authTest;


	@Test
	void contextLoads() {
		authTest.setTestObject(hostaddress+port);

	}

}
