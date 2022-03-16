package com;

import com.FileStream.InputOutputStream;
import com.MultithreadingRecursiveFileDirectorySystem.MultithreadingFileCopying;
import com.RecursiveFileSystem.RecursiveFileSystem;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

    Long startTime = System.currentTimeMillis();
    String initialPath = "/home/ashwinroyal/IdeaProjects/Stream/FileSystem/src";
    String finalPath = "/home/ashwinroyal/IdeaProjects/Stream/FileSystem/";
    Main main = new Main();

//    main.oneFileCopying(initialPath,finalPath);
//    main.recursiveDirectoryFileCopying(initialPath,finalPath);

        File fileIn = new File(initialPath);
        String[] worklist = fileIn.list();
        System.out.println(Arrays.toString(worklist));

//        main.directoryFileCopyingThroughMultithreading(initialPath,finalPath);

    System.out.println("Total time taken to copy: "+(System.currentTimeMillis()-startTime));

    }

    public void oneFileCopying(String initialPath,String finalPath) throws IOException {

        InputOutputStream inputStream =  new InputOutputStream();
        inputStream.readInputFile("/home/ashwinroyal/Downloads/index.jpg","/home/ashwinroyal/IdeaProjects/recursiveDirCreated/index" );
    }

    public void recursiveDirectoryFileCopying(String initialPath,String finalPath) throws IOException {

        RecursiveFileSystem recursiveFileSystem =  new RecursiveFileSystem(initialPath,finalPath);
        recursiveFileSystem.recursiveDirectoryFileCreation(initialPath,finalPath);
    }

    public void  directoryFileCopyingThroughMultithreading(String initialPath,String finalPath) throws IOException, InterruptedException {

//        MultithreadingFileCopying multithreadingFileCopying = new MultithreadingFileCopying(initialPath,finalPath);
//        multithreadingFileCopying.start();
//        System.out.println();

//        MultithreadingFileCopying multithreadingFileCopying1 = new MultithreadingFileCopying(initialPath,finalPath);
//        multithreadingFileCopying1.start();

//        multithreadingFileCopying.join();
//        multithreadingFileCopying1.join();
    }
}





















//        int totalNumberOfThreads = 1;
//        for(int i=0;i<totalNumberOfThreads;i++){
////            Multithreading Thread = new Multithreading();
////            Thread.start();
//            RecursiveDirectoryFileCreation recursiveDirectoryFileCreation
//                    = new RecursiveDirectoryFileCreation(initialPath,finalPath);
////            recursiveDirectoryFileCreation.start();
//       }

//        System.out.println("Total Time Taken------->"+(System.currentTimeMillis()-startTime));
//    }

