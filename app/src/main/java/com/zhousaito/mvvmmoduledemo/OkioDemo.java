package com.zhousaito.mvvmmoduledemo;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.charset.Charset;

import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.Sink;
import okio.Source;

/**
 * Email: zhousaito@163.com
 * Created by zhousaito 2019-07-25 09:06
 * Version: 1.0
 * Description:
 */
public class OkioDemo {
    public static void main(String[] args) {
//        readTest();
        writeTest();
    }

    private static void writeTest() {
        try {
            Sink sink = Okio.sink(new File("./1.txt"));
            BufferedSink buffer = Okio.buffer(sink);
            String aa = "aasffafdasfadsfasdfasdfasdfasd";
            String bb = "bbbbbbbbbbbbbbbbbbbbbbbb";
            String cc = "cccccccccccccccccccccccc";
            buffer.writeString(aa, Charset.forName("UTF-8"));
            buffer.writeString(bb, Charset.forName("UTF-8"));
            buffer.writeString(cc, Charset.forName("UTF-8"));
            buffer.close();
            sink.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void readTest() {
        try {
            Source source = Okio.source(new File("./gradlew.bat"));
            BufferedSource buffer = Okio.buffer(source);
            while (true) {
                String line = buffer.readUtf8Line();
                if (line == null) {
                    break;
                }
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
