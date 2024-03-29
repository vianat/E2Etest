package steps.web;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.ProgressBarPage;
import resources.base;

public class ProgressBarTest extends base {

    ProgressBarPage pbp = new ProgressBarPage(driver);

    @And("Click start button and wait {int} mseconds")
    public void clickStartButtonAndWaitSeconds(int time) throws InterruptedException {
        pbp.startandstopBtn.click();
       Thread.sleep(time);
    }

    @And("Click stop button")
    public void clickStopButton() {
        pbp.startandstopBtn.click();
    }

    @Then("Get progress percentage")
    public void getProgressPercentage() {
        System.out.println("****"+ pbp.progressmessage.getText());
    }
}