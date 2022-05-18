package oit.dataloader;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class DataLoader {
    /*
    set the file path for the .properties file you want to read data from
    Example of reading data from resources folder in the main directory from Dashboard.properties file
    filepath = "\\resources\\Dashboard.properties"
    */
    public static String filepath;

    public static String getData(String dataKey) {
        // find the file path
        String propertyFilePath = System.getProperty("user.dir") + filepath;
        // Declare a properties object
        Properties prop = new Properties();
        // Read configuration.properties file
        try {
            //load data file
            prop.load(new FileInputStream(propertyFilePath));
        } catch (IOException e) {
            System.out.println("Configuration properties file cannot be found");
        }
        return prop.getProperty(dataKey);
    }
}

