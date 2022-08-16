import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideWiki {
    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://github.com";
        Configuration.browser = "chrome";
    }

    @Test
    void findJUnit5Test() {
       open("/selenide/selenide");
       $("#wiki-tab").click();
       $(".markdown-body").shouldHave(text("Soft assertions"));
       $(byLinkText("Soft assertions")).click();
       $(".markdown-body").shouldHave(text("Using JUnit5 extend"));
    }
}
