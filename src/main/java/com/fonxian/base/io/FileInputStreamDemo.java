package com.fonxian.base.io;

import java.io.*;

/**
 * @author Michael Fang
 * @since 2019-10-21
 */
@SuppressWarnings("all")

public class FileInputStreamDemo {

    public static void main(String[] args) {

        InputStream fileInputStream = null;
        byte[] flush = new byte[8];
        try {
            File file = new File("./pom.xml");
            fileInputStream = new FileInputStream(file);
            int len = -1;
            while ((len = fileInputStream.read(flush)) != -1) {
                String str = new String(flush,0,len);
                System.out.print(str);
            }
            System.out.println();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fileInputStream != null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
