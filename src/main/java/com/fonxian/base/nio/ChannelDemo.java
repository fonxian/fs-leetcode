package com.fonxian.base.nio;

import org.junit.Test;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author Michael Fang
 * @since 2020-02-11
 */
public class ChannelDemo {

    /**
     * 利用通道完成文件的复制（非直接缓冲区）
     */
    @Test
    public void test1() {

        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        FileChannel inputChannel = null;
        FileChannel outputChannel = null;
        try {
            fileInputStream = new FileInputStream("zuolan.jpg");
            fileOutputStream = new FileOutputStream("zuolan2.jpg");

            // 获取通道
            inputChannel = fileInputStream.getChannel();
            outputChannel = fileOutputStream.getChannel();

            // 获取缓冲区
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

            while (inputChannel.read(byteBuffer) != -1) {
                byteBuffer.flip();
                outputChannel.write(byteBuffer);
                byteBuffer.clear();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileOutputStream != null) {
                try {
                    outputChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (inputChannel != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputChannel != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test2() {
        try {
            FileChannel inChannel = FileChannel.open(Paths.get("zuolan.jpg"), StandardOpenOption.READ);
            FileChannel outChannel = FileChannel.open(Paths.get("zuolan4.jpg"), StandardOpenOption.WRITE, StandardOpenOption.READ, StandardOpenOption.CREATE);

            // 内存映射文件
            MappedByteBuffer inMappedBuffer = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
            MappedByteBuffer outMappedBuffer = outChannel.map(FileChannel.MapMode.READ_WRITE, 0, inChannel.size());

            // 直接对缓冲区进行数据的读写操作
            byte[] dst = new byte[inMappedBuffer.limit()];
            inMappedBuffer.get(dst);
            outMappedBuffer.put(dst);

            inChannel.close();
            outChannel.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 通道之间的数据传输
     */
    @Test
    public void test3() {
        try {
            FileChannel inChannel = FileChannel.open(Paths.get("zuolan.jpg"), StandardOpenOption.READ);
            FileChannel outChannel = FileChannel.open(Paths.get("zuolan5.jpg"), StandardOpenOption.WRITE, StandardOpenOption.READ, StandardOpenOption.CREATE);

            inChannel.transferTo(0, inChannel.size(), outChannel);
//            outChannel.transferFrom(inChannel, 0, inChannel.size());

            inChannel.close();
            outChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 分散读取 与 聚集写入
     */
    @Test
    public void test4() {

        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile("nio-data.txt", "rw");
            FileChannel fileChannel = randomAccessFile.getChannel();

            ByteBuffer dst1 = ByteBuffer.allocate(100);
            ByteBuffer dst2 = ByteBuffer.allocate(1024);

            ByteBuffer[] dst = {dst1, dst2};

            fileChannel.read(dst);

            for (ByteBuffer buffer : dst) {
                buffer.flip();
            }

            System.out.println(new String(dst[0].array(), 0, dst[0].limit()));
            System.out.println("-------------------");
            System.out.println(new String(dst[1].array(), 0, dst[1].limit()));

            System.out.println("------------聚集写入");
            RandomAccessFile raf2 = new RandomAccessFile("nio-data-1.txt", "rw");
            FileChannel fileChannel2 = raf2.getChannel();
            fileChannel2.write(dst);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
