package com;

import com.FileStream.InputOutputStream;
import com.MultithreadingRecursiveFileDirectorySystem.MultithreadingFileCopying;
import com.RecursiveFileSystem.RecursiveFileSystem;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

    Long startTime = System.currentTimeMillis();
    String initialPath = "/home/ashwinroyal/IdeaProjects/Stream/FileSystem/src/com";
    String finalPath = "/home/ashwinroyal/IdeaProjects/Stream/FileSystem/MultithreadingFolder";
    Main main = new Main();

//    main.oneFileCopying(initialPath,finalPath);
//    main.recursiveDirectoryFileCopying(initialPath,finalPath);
//    main.directoryFileCopyingThroughMultithreading(initialPath,finalPath);

        File fileIn = new File(initialPath);
        int numberOfthread = 2;

        if(fileIn.isFile()){
            main.oneFileCopying(initialPath,finalPath);
        }else {
            MultithreadingFileCopying multithreadingFileCopying = new MultithreadingFileCopying(initialPath,finalPath);
            multithreadingFileCopying.directoryListing(initialPath);
//            multithreadingFileCopying.run();

            MultithreadingFileCopying multithreadingFileCopying_thread1 = new MultithreadingFileCopying(initialPath,finalPath);
//            MultithreadingFileCopying multithreadingFileCopying_thread2 = new MultithreadingFileCopying(initialPath,finalPath);

            multithreadingFileCopying_thread1.start();
//            multithreadingFileCopying_thread2.start();

            multithreadingFileCopying_thread1.join();
//            multithreadingFileCopying_thread2.join();

        }
            System.out.println("check 1");
        System.out.println("Total time taken to copy: "+(System.currentTimeMillis()-startTime));
        //Create thread accordingly to work on the list
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

