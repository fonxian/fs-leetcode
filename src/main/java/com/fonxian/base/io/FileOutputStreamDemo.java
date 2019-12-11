package com.fonxian.base.io;

import java.io.*;

/**
 * 创建IO的流程
 * 选择源，选择流、进行操作（读取、写入）、关闭资源
 * @author Michael Fang
 * @since 2019-10-21
 */
@SuppressWarnings("all")
public class FileOutputStreamDemo {

    public static void main(String[] args) {

        OutputStream outputStream = null;
        try {
            File file = new File("./1.txt");
            //第二个参数是是否追加 false 否，true 是
            outputStream = new FileOutputStream(file,true);
            String msg = "I love sz";
            byte[] flush = msg.getBytes();
            outputStream.write(flush, 0, flush.length);
            outputStream.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
