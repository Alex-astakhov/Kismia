package core;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.ScreenshotException;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.awt.*;
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




    public void takeActualScreenshot(Set<By> ignoredElements){
        Robot bot = null;
        try {
            bot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        bot.mouseMove(0, 0);

        Screenshot screenshot = new AShot().ignoredElements(ignoredElements).shootingStrategy(ShootingStrategies.viewportPasting(100)).takeScreenshot(driver);

        File actualFile = new File(actualDir+"kismia"+".png");
        try {
            ImageIO.write(screenshot.getImage(), "png", actualFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void takeExpectedScreenshot(Set<By> ignoredElements){
        Robot bot = null;
        try {
            bot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        bot.mouseMove(0, 0);

        Screenshot screenshot = new AShot().ignoredElements(ignoredElements).shootingStrategy(ShootingStrategies.viewportPasting(100)).takeScreenshot(driver);

        File actualFile = new File(expectedDir+"kismia"+".png");
        try {
            ImageIO.write(screenshot.getImage(), "png", actualFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Screenshot getExpectedScreenshot(){

        try {
            return new Screenshot(ImageIO.read(new File(expectedDir+"kismia"+".png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Screenshot getActualScreenshot(){

        try {
            return new Screenshot(ImageIO.read(new File(actualDir+"kismia"+".png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ImageDiff findImageDifference(){
        Screenshot actual = getActualScreenshot();
        Screenshot expected = getExpectedScreenshot();
        ImageDiff diff = new ImageDiffer().makeDiff(expected, actual);
        if (diff.getDiffSize() > 0){
            File diffFile = new File(markedImages+"kismia"+".png");
            try {
                ImageIO.write(diff.getMarkedImage(), "png", diffFile);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return diff;
    }


    private String getScreenshotName(){
        return "screen_" + driver.getCurrentUrl().substring(18).replace("/", "_") + driver.manage().window().getSize();
    }



}
