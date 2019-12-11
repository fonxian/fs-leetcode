package com.fonxian.base.io;

import java.io.*;

/**
 * @author Michael Fang
 * @since 2019-10-22
 */
@SuppressWarnings("all")
public class FileCopyDemo {

    public static void main(String[] args) {

        InputStream fileInputStream = null;
        OutputStream outputStream = null;
        byte[] flush = new byte[8];
        try {
            File file = new File("./1.txt");
            File file1 = new File(file.getParent() + "/" + file.getName() + "_copy.txt");
            fileInputStream = new FileInputStream(file);
            outputStream = new FileOutputStream(file1);
            int len = -1;
            while ((len = fileInputStream.read(flush)) != -1) {
                outputStream.write(flush, 0, len);
                outputStream.flush();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


}
