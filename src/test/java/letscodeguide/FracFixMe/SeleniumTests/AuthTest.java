package letscodeguide.FracFixMe.SeleniumTests;


import lombok.Setter;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

/*TODO:
Сделать реализацию автотеста с помощью селениума
 */
public class AuthTest extends AbstractTest {

    @Setter
    private String TestObject;

    WebDriver webDriver;

    public AuthTest(WebDriver webDriver, String pathtodriver) {
        super(webDriver, pathtodriver);
    }


    @Override public void fillForm() {}
    public void fillForm(String username, String password) {

    }
    @Override
    public String outputTextXPath(String xpath) {
        return null;
    }
}
