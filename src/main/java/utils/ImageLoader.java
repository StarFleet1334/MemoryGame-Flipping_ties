package utils;

import java.io.File;
import java.net.URL;

public class ImageLoader {
    public String[] getImagesFromResourceFolder(String path) {
        String folderName = path;
        // Get the URL of the resources folder
        URL resourceFolderURL = ImageLoader.class.getClassLoader().getResource(folderName);
        if (resourceFolderURL != null) {
            // Get the folder path
            String folderPath = resourceFolderURL.getPath();
            System.out.println(folderPath);
            // Create a File object for the folder
            File folder = new File(folderPath);
            if (folder.exists() && folder.isDirectory()) {
                // List all files in the folder
                File[] files = folder.listFiles();
                if (files != null && files.length > 0) {
                    // Count the number of images
                    int numberOfImages = files.length;
                    // Store image paths in a string array
                    String[] imagePaths = new String[numberOfImages];
                    for (int i = 0; i < numberOfImages; i++) {
                        imagePaths[i] = files[i].getPath();
                    }
                    System.out.println("Total number of images: " + numberOfImages);
                    return imagePaths;
                } else {
                    System.out.println("No images found in the folder.");
                }
            } else {
                System.out.println("Folder does not exist or is not a directory.");
            }
        } else {
            System.out.println("Resource folder not found.");
        }
        return null;
    }

}

