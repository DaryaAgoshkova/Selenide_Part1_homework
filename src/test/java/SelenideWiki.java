import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideWiki {
    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://github.com";
        Configuration.browser = "chrome";
        //Configuration.holdBrowserOpen = true;
    }

    @Test
    void findJUnit5Test() {
       open("/selenide/selenide");
       $("#wiki-tab").click();
       $("#wiki-body").shouldHave(text("Soft assertions"));
       $("#wiki-body").find(byText("Soft assertions")).click();
       $(".markdown-body").shouldHave(text("Using JUnit5 extend test class:"));
    }
}
