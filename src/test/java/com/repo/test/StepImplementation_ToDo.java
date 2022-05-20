package com.repo.test;


import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.repo.test.DriverFactory;


/**
 * Test to get the count of repo.
 * @author neethu.mohan
 *
 */
public class StepImplementation_ToDo {

    private final WebDriver driver;
    private static final String URL = "https://github.com/orgs/google/repositories";
    private UtilClass util;
    private RepoPage repo;
    
    public StepImplementation_ToDo() {
        this.driver = DriverFactory.getDriver();
        this.util = new UtilClass();
        this.repo = new RepoPage();
    }

    /**
     * Test to get the count of repo.
     * @throws InterruptedException
     */
    @Test
    public void getRepoCount() throws InterruptedException {
        driver.get(URL);
        util.waitForPageToLoad();
        repo.getTagsCount();
        repo.clickOnLastLink();
        int repoperpage = repo.getRepoPerPage();
        int repoCount = repoperpage * (Integer.parseInt(repo.getLastLinkPageNumber()) - 1);
        repo.clickOnLastLink();
        int lastRepoCount =  repo.getRepoPerPage();
        int totalRepoLinks = repoCount + lastRepoCount;
        assertEquals(2258, totalRepoLinks);
    }
}
