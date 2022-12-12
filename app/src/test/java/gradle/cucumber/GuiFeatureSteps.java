package gradle.cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.Before;
import io.cucumber.java.After;

import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;

import org.assertj.swing.core.*;
import org.assertj.swing.fixture.*;
import org.assertj.swing.finder.*;
import org.assertj.swing.image.ScreenshotTaker;
import static org.assertj.swing.launcher.ApplicationLauncher.*;


import java.io.*;
import javax.swing.*;


public class GuiFeatureSteps {
    
    private FrameFixture window;
    private Robot robot;

    @When("the program is run as a GUI in {string}")
    public void theProgramIsRunAsAGuiIn(String phase) {

        //application(pipboss.App.class).withArgs(phase).start();
        
        (new Thread(new Runnable() {
            public void run() {
                try {
                    pipboss.App.main(phase);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        })).start();
        
        robot = BasicRobot.robotWithCurrentAwtHierarchy();
        System.out.println(robot);
        window = WindowFinder.findFrame("PipBoss").using(robot).show();
        window.robot().waitForIdle();
        System.out.println(window);
                
        //window.robot().settings().delayBetweenEvents(10);
        //window.robot().settings().eventPostingDelay(20);
        
    }
    
    @Then("the GUI should play correctly")
    public void theGuiShouldPlayCorrectly() {
        System.out.println(window.label("Round").text());
        while (!window.label("Round").text().equals("Game Over")) {
            String[] choices = window.comboBox("Choices").contents();
            System.out.println(java.util.Arrays.asList(choices));
            window.comboBox("Choices").selectItem(choices.length - 1);
            JFrame f = (JFrame)window.target();
            System.out.println(f.getLocation() + "   " + f.getSize());
            window.button("Submit").focus().click();
            //break;
        }
        /*
        ScreenshotTaker screenshotTaker = new ScreenshotTaker();
        java.awt.image.BufferedImage screenshot = screenshotTaker.takeDesktopScreenshot();//Of(window.target());
        File directory = new File("build" + File.separator + 
                                  "reports" + File.separator + 
                                  "cucumber" + File.separator + 
                                  "screenshots" );
        if (!directory.exists()){
            directory.mkdirs();
        }
        screenshotTaker.saveImage(screenshot, directory.getPath() + File.separator + "test.png");
        assertThat(5, is(5));
        */

    }
  
}  