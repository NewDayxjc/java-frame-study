package com.java8.filestream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileStreamTest {

    public static void main(String[] args) {
        byte[] bytes = "abcdefghij".getBytes();
        try {
            //覆盖写
//            FileOutputStream fileOutputStream = new FileOutputStream("fos.txt");
            //追加写
            FileOutputStream fileOutputStream = new FileOutputStream("fos.txt",true);

            //全部写入
//            fileOutputStream.write(bytes);
            //换行写入，每行写入多少
            fileOutputStream.write(bytes,2,2);
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            System.out.println("执行结束");
        }

//        if(bytes.length!=-1){
//            int length = bytes.length;
//            for (int i = 0; i < length; i++) {
//                System.out.println(bytes[i]);
//
//            }
//        }
    }

    public void fileStream(){

    }
}
