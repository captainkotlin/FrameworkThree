package toolsqa.books;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import toolsqa.books.page.BookstorePage;
import utils.AbstractUiTest;
import utils.UiTestWatcher;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(UiTestWatcher.class)
public class BookstoreTest extends AbstractUiTest<BookstorePage>
{
    @Test
    public void test1()
    {
        page = open("https://demoqa.com/books", BookstorePage.class);
        var divs = page.getTableRowDivs();
        assertEquals(divs.size(), 10);
    }
}