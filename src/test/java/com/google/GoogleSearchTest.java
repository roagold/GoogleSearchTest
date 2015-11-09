package com.google;

import com.codeborne.selenide.Condition;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertEquals;

/**
 * Created by oryabinskiy on 11/9/2015.
 */

/*
Automate:
1 visit http://google.com/ncr
2 search: “Selenium automates browsers”
3 check that 10 results are found
4 check the text “Selenium automates browsers” in 1st result
5 follow the link in 1st result
6 check that selenium official page is loaded
 */

public class GoogleSearchTest {
    @Test
    public void testGoogleSearch(){
    open("http://google.com/ncr");
        searchFor("Selenium automates browsers");
        assertSearchResultSize(10);
        assertFirstResult("Selenium automates browsers");
        clickOnFirstLink();
        assertTextOnPage("What is Selenium?");
            }

    public void searchFor(String text){
        $("#lst-ib").setValue(text).pressEnter();
    }

    public void assertSearchResultSize(int size){
        $$("#res .g").shouldHaveSize(size);
    }

    public void assertFirstResult(String text){
        $(".g:nth-child(1) .st").shouldHave(Condition.text(text));
    }

    public void clickOnFirstLink(){
        $(".g:nth-child(1) .r>a").click();
    }

    public void assertTextOnPage(String text){
        $(".homepage").shouldHave(Condition.text(text));
    }
}
