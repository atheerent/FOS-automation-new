package stepsDefinitions.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Properties;
import java.util.stream.*;

import static java.util.stream.Collectors.toList;

//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.ie.InternetExplorerDriver;
//import org.openqa.selenium.support.ui.WebDriverWait;

public class PropertyDriver {
    public static String getPropertyConfig(String key) throws IOException {
        String filePath = "./src/test/java/resources/configuration/config.properties";
        String value = null;
        Properties property = new Properties();
        FileInputStream inputStream = new FileInputStream(filePath);
        property.load(inputStream);
        String value_config = property.getProperty(key);
        String value_maven = System.getProperty(key);

        if (value_maven != null) {
            value = value_maven;
        } else {
            value = value_config;
        }
        System.out.print("BROWSER NAME *******  " + value);
        return value;

    }

    public static String getPropertyData(String key, String pageName) throws IOException {
        String filePath = "";
        String value = null;
        List<Path> walk = Files.walk(Paths.get("./src/test/java/resources/locators/")).collect(Collectors.toList());
        for (Path p : walk) {
            String pathName = p.toString();
            if (pathName.contains(pageName + ".properties")) {
                filePath = pathName;
                break;
            }
        }

        Properties property = new Properties();
        FileInputStream inputStream = new FileInputStream(filePath);
        property.load(inputStream);
        value = property.getProperty(key);
        return value;


    }

}
