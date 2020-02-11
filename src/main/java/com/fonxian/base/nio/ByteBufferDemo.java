package com.fonxian.base.nio;


import org.junit.Test;

import java.nio.ByteBuffer;

/**
 * 通过allocate分配数组大小
 * <p>
 * 缓冲区的4个特殊属性
 * 0 <= mark <= position <= limit <= capacity
 *
 * @author Michael Fang
 * @since 2020-02-11
 */
public class ByteBufferDemo {

    @Test
    public void test1() {
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        String str = "abcdeffffsss";
        System.out.println("-------init-------");
        print(byteBuffer);

        System.out.println("-------put-------");
        byteBuffer.put(str.getBytes());
        print(byteBuffer);

        // 切换到读取模式
        System.out.println("-------flip-------");
        byteBuffer.flip();
        print(byteBuffer);

        System.out.println("-------get-------");
        byte[] bytes = new byte[byteBuffer.limit()];
        byteBuffer.get(bytes);
        System.out.println(new String(bytes, 0, bytes.length));
        print(byteBuffer);

        // 重复读
        System.out.println("-------rewind-------");
        byteBuffer.rewind();
        print(byteBuffer);

        // mark标记
        System.out.println("-------mark before-------");
        byte[] bytes1 = new byte[2];
        byteBuffer.get(bytes1, 0, 2);
        System.out.println(new String(bytes1, 0, bytes1.length));
        print(byteBuffer);
        byteBuffer.mark();

        System.out.println("-------mark after-------");
        byte[] bytes2 = new byte[2];
        byteBuffer.get(bytes2, 0, 2);
        System.out.println(new String(bytes2, 0, 2));
        print(byteBuffer);
        System.out.println("-------reset-------");
        byteBuffer.reset();
        print(byteBuffer);
    }

    @Test
    public void testDirectBuffer() {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024);
        System.out.println(byteBuffer.isDirect());
    }

    void print(ByteBuffer byteBuffer) {
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());
    }

}
