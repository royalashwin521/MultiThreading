package com.MultithreadingRecursiveFileDirectorySystem;

import com.FileStream.InputOutputStream;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

public class MultithreadingFileCopying extends Thread {

    private String initialPath ;
    private static String finalPath; //check static
//    static Stack<File> workList = new Stack<>();   // problem with stack is that if a dir is created at destination folder but the destination path is not changed
    static LinkedList<File> workList = new LinkedList<>();

    public MultithreadingFileCopying(String initialPath, String finalPath) {
        this.initialPath = initialPath;
        MultithreadingFileCopying.finalPath = finalPath;
    }

    public MultithreadingFileCopying() {

    }

    public void multithreading(LinkedList workList) throws IOException {
        MultithreadingFileCopying multithreadingFileCopying = new MultithreadingFileCopying();
        String sourcePath;
        synchronized (this) {
//            myWorkPath = String.valueOf(workList.pop());
            sourcePath = String.valueOf(workList.getFirst());
            workList.removeFirst();
        }
//        System.out.println("My workPath is : "+sourcePath);
        File fileIn = new File(sourcePath);

        //generating the destination path
        System.out.println("this is my source path:"+fileIn.getPath());
        int index = fileIn.getName().length();
        System.out.println("what is the index value of pathname: "+index);
        String destination = finalPath.concat(sourcePath.substring(initialPath.length(),sourcePath.length()-index));
//        String destination = finalPath.concat("/"+fileIn.getName());
        System.out.println("Lets see my destibation--->: "+destination);

        File fileOut = new File(destination);
        try {
            multithreadingFileCopying.dirchecking(fileIn, fileOut);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
//        System.out.println("Who am i: "+currentThread().getId()+" "+currentThread().getName());
        try {
            if(workList.isEmpty()){
               //go to main and check if all work completed by threads
                System.out.println("My list got empty and name is "+currentThread().getName());
            }
            else{
                multithreading(workList);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    synchronized public void directoryListing(String Path){

        File fileIn = new File(Path);
        File[] list = fileIn.listFiles();
        for (File temp: list) {
            workList.addLast(temp);
        }
        System.out.println("My worklist: "+workList);
    }

    public void dirchecking(File fileIn, File fileOut) throws IOException, InterruptedException {
        System.out.println("i got : "+fileIn.getName());
        if(fileIn.isDirectory()) {
            System.out.println("what is my destination path for dir: "+fileOut.getPath());
            if (!fileOut.exists()) {
                fileOut.mkdir();
                System.out.println("what path is given to listing: "+fileIn.getPath());
                directoryListing(fileIn.getPath());
                start();
            }else {
                System.out.println("did i created dir");
            }
        }
        else {
            System.out.println("what is my destination path for file: "+fileOut.getPath());
            if(!fileOut.exists()){
                InputOutputStream inputOutputStream = new InputOutputStream();
                inputOutputStream.readInputFile(fileIn.getPath(),fileOut.getPath());
                start();
            }
            else {
                System.out.println("did i created file");
            }
//            System.out.println("destination: "+fileOut.getPath());
        }
    }
}
