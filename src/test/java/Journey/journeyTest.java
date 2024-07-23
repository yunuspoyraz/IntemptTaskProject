package Journey;

import com.microsoft.playwright.*;

import java.awt.*;
import java.lang.annotation.ElementType;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;
import java.util.logging.SimpleFormatter;

public class journeyTest {

    public static void main(String[] args) throws InterruptedException {
        Playwright playwright = Playwright.create();
        BrowserType chromium = playwright.chromium();
        Browser browser = chromium.launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page loginPage = browser.newPage();
        loginPage.navigate("https://app.intempt.com");
        System.out.println(loginPage.title());

        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = (int) dimension.getWidth();
        int screenHeight = (int) dimension.getHeight();
        loginPage.setViewportSize(screenWidth,screenHeight);

        Locator loginEmail = loginPage.locator("#email1");
        loginEmail.click();
        loginEmail.fill("bolam74153@apn7.com");

        Locator loginPassword = loginPage.getByPlaceholder("*******");
        loginPassword.click();
        loginPassword.fill("IntemptRocks$1");

        Locator loginButton = loginPage.locator("#login");
        loginButton.click();
        //assert ekle

        Locator journeyMenuButton = loginPage.locator("[href='/journeys']");
        journeyMenuButton.click();

        //assert ekle
        Locator createJourneyButton = loginPage.locator("//*[text()=' Create journey ']").first();
        createJourneyButton.click();

        // sayfayı assert etsin
        Locator createAJourneyButton = loginPage.locator("//*[text()=' Create a journey ']").last();
        createAJourneyButton.click();
        Locator journeynNameInput = loginPage.getByPlaceholder("Enter journey name here");

        String date = new SimpleDateFormat("_hh_mm_ss_ddMMyyy").format(new Date());

        journeynNameInput.fill("YUPO"+date);
        Locator createJourneyButton2 = loginPage.locator("//*[text()=' Create journey ']").last();
        createJourneyButton2.click();


        Locator blockOnCondition = loginPage.locator("//*[text()=' On condition ']/..");
        Locator board = loginPage.locator(".journeyConstructor");

        Thread.sleep(5000);


        //loginPage.locator("//p[text()=' On condition ']/ancestor::div[1]").dragTo(loginPage.locator("//div[contains(@class,'window-item--active')]"));

        loginPage.locator("//*[text()=' On condition ']/..").hover();
        loginPage.mouse().down();
        loginPage.locator("(//div[contains(@class,'align-stretch')])[1]").hover();
        loginPage.mouse().up();
        Thread.sleep(5000);

        //Assert ekle

        loginPage.close();
        browser.close();
        playwright.close();

    }
}
