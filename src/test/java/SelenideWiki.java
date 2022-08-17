import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SelenideWiki {
    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://github.com";
        Configuration.browser = "chrome";
    }

    @Test
    void findJUnit5Test() {
        open("/selenide/selenide");
        $$("ul li").findBy(text("Wiki")).click();
        $("#wiki-pages-box button").click();
        $("#wiki-pages-box").shouldHave(text("SoftAssertions"));
        $(byText("SoftAssertions")).click();
        $(".markdown-body").shouldHave(text("Using JUnit5 extend test class"));
    }
}
