package com.MultithreadingRecursiveFileDirectorySystem;

import com.RecursiveFileSystem.RecursiveFileSystem;

import java.io.File;
import java.io.IOException;

public class MultithreadingFileCopying extends Thread {

    private String initialPath ;
    private String finalPath;

    public MultithreadingFileCopying(String initialPath, String finalPath) {
        this.initialPath = initialPath;
        this.finalPath = finalPath;
    }

    @Override
    public void run() {
        System.out.println(currentThread().getId()+" "+currentThread().getName());
        RecursiveFileSystem recursiveFileSystem = new RecursiveFileSystem();
        try {
            recursiveFileSystem.recursiveDirectoryFileCreation(initialPath,finalPath);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    synchronized public String[] directoryListing(File fileIn){
        String[] list ;
        list = fileIn.list();
        return list;
    }
}
