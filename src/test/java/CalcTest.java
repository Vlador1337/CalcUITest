import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$x;

public class CalcTest {
    @BeforeEach
    public void openCalc(){
        Selenide.open("https://www.google.com/");
    }

    private void assertAnswer(String value){
        $x("//input[@name='q']").sendKeys(value + "=" + Keys.ENTER);
        String answer = $x("//span[@id='cwos']").getText();
        Assertions.assertEquals("10",answer,"Ошибка, ответ - " + answer);
    }

    @Test
    public void calcSumTest(){
        assertAnswer("5+5");
    }

     @Test
    public void calcSubTest(){
        assertAnswer("15-5");
    }

     @Test
    public void calMultTest(){
        assertAnswer("2*5");
    }

     @Test
    public void calcDivTest(){
        assertAnswer("20/2");
    }


}
