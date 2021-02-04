package toolsqa.books.page;

import com.codeborne.selenide.ElementsCollection;
import utils.AbstractPage;

import static com.codeborne.selenide.Selenide.$$;

public class BookstorePage extends AbstractPage<BookstorePage>
{
    public ElementsCollection getTableRowDivs()
    {
        return $$("#app > div > div > div.row > div.col-12.mt-4.col-md-6 > div.books-wrapper > div.ReactTable.-striped.-highlight > div.rt-table > div.rt-tbody > div");
    }
}
