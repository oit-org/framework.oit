package oit.utilities;

import java.io.File;


public class DynamicImagePath {

    public static String finalPath;

    public static String generateImagePath(String image) {

        String systemPath = System.getProperty("user.dir");
        finalPath = systemPath + File.separator + "Images" + File.separator + image;
        return finalPath;

    }
}
