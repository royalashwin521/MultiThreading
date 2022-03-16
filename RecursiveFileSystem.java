package com.RecursiveFileSystem;

import com.FileStream.InputOutputStream;
import java.io.File;
import java.io.IOException;


public class RecursiveFileSystem extends Thread{

        String startingPath;
        String endingPath;

        public RecursiveFileSystem(String initialPath , String finalPath) throws IOException {
            this.startingPath = initialPath;
            this.endingPath = finalPath;
        }

    public RecursiveFileSystem() {
    }

    public void recursiveDirectoryFileCreation(String startingPath, String endingPath) throws IOException {
            File fileIn = new File(startingPath);
            String[] list;

//      Scanning the path for list of files and folders
            list = directoryListing(fileIn);

//        Retreiving elements from list for checking file|Directory and working accordingly
            for (String temp: list) {
                String if_FilePath = startingPath.concat("/"+temp);
                String destinationFilePath = endingPath.concat("/"+temp);

                if (new File(if_FilePath).isFile()) {
                    InputOutputStream inputStream = new InputOutputStream();
                    inputStream.readInputFile(if_FilePath, destinationFilePath);
                } else {
                    File fileOut = new File(destinationFilePath);
                    fileOut.mkdir();
                    recursiveDirectoryFileCreation(if_FilePath, destinationFilePath);
                }
            }
        }

        public String[] directoryListing(File fileIn){
            return fileIn.list();
        }

}
