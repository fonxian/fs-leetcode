package com.fonxian.base.nio;

import org.junit.Test;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

/**
 * @author Michael Fang
 * @since 2020-02-11
 */
public class CharsetDemo {

    @Test
    public void test1() {
        Charset cs1 = Charset.forName("GBK");

        // 通过字符集获取编码器
        CharsetEncoder encode1 = cs1.newEncoder();

        //获取解码器
        CharsetDecoder decode1 = cs1.newDecoder();

        // 进行编码,将字符串转换为字节数组
        CharBuffer charBuffer = CharBuffer.allocate(100);
        charBuffer.put("洛奇，铁拳为争霸");
        charBuffer.flip();

        try {
            ByteBuffer byteBuffer = encode1.encode(charBuffer);
            for (int i = 0; i < 16; i++) {
                System.out.println(byteBuffer.get());
            }

            // 进行解码，将字节数组转换为字符串
            byteBuffer.flip();
            CharBuffer charBuffer1 = decode1.decode(byteBuffer);
            System.out.println(charBuffer1.toString());

            byteBuffer.flip();
            Charset cs2 = Charset.forName("UTF-8");
            CharBuffer charBuffer2 = cs2.decode(byteBuffer);
            System.out.println(charBuffer2.toString());

        } catch (CharacterCodingException e) {
            e.printStackTrace();
        }
    }


}
