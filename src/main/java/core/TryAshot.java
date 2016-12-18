package core;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.ScreenshotException;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Set;


/**
 * Created by Alex Astakhov on 17.12.2016.
 */
public class TryAshot extends MethodsFactory {

    String absolutePath;
    String actualDir;
    String expectedDir;
    String markedImages;

    FileIO fileIO = new FileIO();

    public TryAshot(String absolutePath) {
        this.absolutePath = absolutePath;
        this.actualDir = absolutePath + "\\actual\\";
        this.expectedDir = absolutePath + "\\expected\\";
        this.markedImages = absolutePath + "\\markedImages\\";
        fileIO.createDirectory(absolutePath);
        fileIO.createDirectory(actualDir);
        fileIO.createDirectory(expectedDir);
        fileIO.createDirectory(markedImages);
    }



    public Screenshot getExpectedScreenshot(){

        try {
            return new Screenshot(ImageIO.read(new File(expectedDir+getScreenshotName()+".png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private boolean expectedIsPresent(){
        File file = new File(expectedDir+getScreenshotName()+".png");
        return file.exists();
    }

    public Screenshot getActualScreenshot(){

        try {
            return new Screenshot(ImageIO.read(new File(actualDir+getScreenshotName()+".png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Screenshot takeScreenshot(Set<By> setIgnoredElements){
        Robot bot = null;
        try {
            bot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        bot.mouseMove(0, 0);

        return new AShot().ignoredElements(setIgnoredElements).shootingStrategy(ShootingStrategies.viewportPasting(100)).takeScreenshot(driver);

    }


    public ImageDiff findImageDifference(Set<By> setIgnoredElements){


        File actualFile = new File( actualDir + getScreenshotName()+".png");
        File expectedFile = new File(expectedDir + getScreenshotName()+".png");
        Screenshot actual = takeScreenshot(setIgnoredElements);
        Screenshot expected = null;
        try {
            ImageIO.write(actual.getImage(), "png", actualFile);


        if (expectedIsPresent()) {
            expected = getExpectedScreenshot();
        }
        else {
            expected = takeScreenshot(setIgnoredElements);
            ImageIO.write(expected.getImage(), "png", expectedFile);

        }
        } catch (IOException e) {
            e.printStackTrace();
        }
        expected.setIgnoredAreas(actual.getIgnoredAreas());
        ImageDiff diff = new ImageDiffer().makeDiff(expected, actual);
        if (diff.getDiffSize() > 0){
            File diffFile = new File(markedImages+getScreenshotName()+".png");
            actualFile = new File( actualDir + getScreenshotName()+".png");
            try {
                ImageIO.write(diff.getMarkedImage(), "png", diffFile);

            } catch (IOException e) {
                e.printStackTrace();
            }

            pngAttachment(actualFile);


            pngAttachment(expectedFile);
            pngAttachment(diffFile);
        }
        return diff;
    }


    private String getScreenshotName(){
        Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
        String browserName = cap.getBrowserName().toLowerCase();
        return "screen_" + driver.getCurrentUrl().substring(18).replace("/", "_")
                + browserName + "_" + driver.manage().window().getSize();
    }

    @Attachment(value = "{0}", type = "image/png")
    public static byte[] pngAttachment(Screenshot screenshot, String name){
        try {
            File file = new File(name + ".png");
            ImageIO.write(screenshot.getImage(), "png", file);
            return Files.readAllBytes(Paths.get(file.getPath()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new byte[0];
    }

    @Attachment(value = "{0}", type = "image/png")
    public static byte[] pngAttachment(File file){
        try {

            return Files.readAllBytes(Paths.get(file.getPath()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new byte[0];
    }


}
