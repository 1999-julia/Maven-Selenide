import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;

public class GoogleTest {

    @Test
    public void userCanSearch() throws InterruptedException {
        open("https://www.google.com");
        new GooglePage().searchFor("Евтеева Юлия");

        SearchResultsPage results = new SearchResultsPage();
        results.getResults().shouldHave(sizeGreaterThan(1));
        results.getResult(0).shouldHave(text("Евтеева Юлия"));
        wait(500);
    }
}
