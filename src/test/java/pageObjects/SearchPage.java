package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

    public SearchPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "orb-search-q")
    @CacheLookup
    WebElement txtSearch;

    @FindBy(id = "orb-search-button")
    @CacheLookup
    WebElement btnSearch;

    @FindBy(xpath = "//*[@id=\"main-content\"]/div[1]/div[3]/div/div/ul/li[1]/div/div/div[1]/div[1]/a/span/p/span")
    @CacheLookup
    WebElement titleFirstHeading;

    @FindBy(xpath = "//*[@id=\"main-content\"]/div[1]/div[3]/div/div/ul/li[10]/div/div/div[1]/div[1]/a/span/p/span")
    @CacheLookup
    WebElement titleLastHeading;

    public void search(String arg) {
        txtSearch.click();
        txtSearch.sendKeys(arg);
        btnSearch.click();
    }

    public void fn_return_headings() {
        String firstHeading, lastHeading;
        firstHeading = titleFirstHeading.getText();
        lastHeading = titleLastHeading.getText();
        System.out.println("The first heading is: " + firstHeading);
        System.out.println("The last heading is: " + lastHeading);

    }
}