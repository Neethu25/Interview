package com.repo.test;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This class contains webelements and reusable methods of repo page.
 * @author neethu.mohan
 *
 */
public class RepoPage {
    
   private WebDriver driver;
    
    @FindBy(xpath = "//span[contains(@class,'previous_page disabled')]/../a[@aria-label]")
    private List<WebElement> tags;
    
    @FindBy(xpath = "//div[@id='org-repositories']/div/div/div/ul/li")
    private  List<WebElement> countOfRepPerPage;
    
    public RepoPage() {
        this.driver = DriverFactory.getDriver();
        PageFactory.initElements(driver, this);
    }
    
    /**
     * To get last page size.
     * @return size
     */
    public int getTagsCount() {
        List<WebElement> list = new ArrayList<WebElement>();
        for (WebElement ele : tags) {
            list.add(ele);
        }
        
       return list.size()- 1;
    }
    
    /**
     * To get last link page number.
     * @return lastLinkText.
     */
    public String getLastLinkPageNumber() {
    String lastLinkText= tags.get(getTagsCount()).getText();
    return lastLinkText;
    }
    
    /**
     * click on last link.
     */
    public void clickOnLastLink() {
      tags.get(getTagsCount()).click();
        }
    
    /**
     * Method to get the count of repo per page.
     * @return returns count of repo links in first page.
     */
    public int getRepoPerPage() {
        int countOfLinksInFirstPage = countOfRepPerPage.size();
        return countOfLinksInFirstPage;
    }

}
