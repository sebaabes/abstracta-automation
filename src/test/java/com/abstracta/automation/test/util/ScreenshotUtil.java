package com.abstracta.automation.test.util;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.abstracta.automation.test.AbstractaAutomationTestApplicationTests;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;

public class ScreenshotUtil {
    private static WebDriver driver;
    
    private static final Logger logger = LoggerFactory.getLogger(ScreenshotUtil.class);

    public ScreenshotUtil(WebDriver driver) {
        this.driver = driver;
    }
    
	public static void takeScreenshot(String fileName) {
        // Crear la carpeta para almacenar capturas si no existe
        String screenshotsDir = "src/test/resources/screenshots/";
        File dir = new File(screenshotsDir);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        // Generar la ruta completa para el archivo de captura
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date(0));
        String filePath = screenshotsDir + fileName + "_" + timeStamp + ".png";

        // Tomar la captura y guardarla en el archivo especificado
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
        File destFile = new File(filePath);

        try {
            FileUtils.copyFile(srcFile, destFile);
            logger.info("Screenshot saved in: " + filePath);
        } catch (IOException e) {
            logger.error("Error saving screenshot: " + e.getMessage());
        }
	}

}
