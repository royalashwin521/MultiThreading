package com.FileStream;
import java.io.*;

public class InputOutputStream {

    public void readInputFile(String filePath, String outfile) throws IOException {
        try {
            int readLength;
            byte[] dataBytes = new byte[6015000];
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(filePath));

            while (-1 != (readLength = bufferedInputStream.read(dataBytes,0,6000000))) {
                writeOutputFile(dataBytes, readLength, outfile);
            }
            bufferedInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeOutputFile(byte[] databytes , int Length, String outfile) throws FileNotFoundException {
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(outfile));
            bufferedOutputStream.write(databytes, 0, Length);
            bufferedOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
