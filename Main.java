package com;

import com.FileStream.InputOutputStream;
import com.MultithreadingRecursiveFileDirectorySystem.Multithreading;
import com.RecursiveFileSystem.RecursiveFileSystem;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {


    Long startTime = System.currentTimeMillis();
    Long beforeUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();

        System.out.println("Memory : "+beforeUsedMem);
//        String initialPath = "/home/ashwinroyal/Downloads/protobuf-all-3.19.4";
        String initialPath = "/home/ashwinroyal/IdeaProjects/Stream/FileSystem/src/com";
//    String finalPath = "/home/ashwinroyal/IdeaProjects/recursiveDirCreated";
    String finalPath = "/home/ashwinroyal/IdeaProjects/Stream/FileSystem/MultithreadingFolder";
    Main main = new Main();

//    main.oneFileCopying(initialPath,finalPath);
//    main.recursiveDirectoryFileCopying(initialPath,finalPath);
//    main.directoryFileCopyingThroughMultithreading(initialPath,finalPath,2);

        File fileIn = new File(initialPath);


        if(fileIn.isFile()){
            main.oneFileCopying(initialPath,finalPath);
        }else {
            Multithreading multithreadingFileCopying = new Multithreading(initialPath,finalPath);
            multithreadingFileCopying.directoryListing(initialPath);
//            multithreadingFileCopying.run();

            Multithreading multithreadingFileCopying_thread1 = new Multithreading(initialPath,finalPath);

            Thread t1 = new Thread(multithreadingFileCopying_thread1);
            Thread t2 = new Thread(multithreadingFileCopying_thread1);

            t1.start();
            t2.start();

            t1.join();
            t2.join();


        }
            System.out.println("check 1");
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

    public void  directoryFileCopyingThroughMultithreading(String initialPath,String finalPath, int numberOfThreads) throws IOException, InterruptedException {
        for(int i=0;i<numberOfThreads;i++){
            Multithreading multithreadingFileCopying_thread1 = new Multithreading(initialPath,finalPath);
        }
}
}


