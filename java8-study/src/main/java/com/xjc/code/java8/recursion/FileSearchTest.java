package com.xjc.code.java8.recursion;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class FileSearchTest {

    public static void main(String[] args) {

/*        File file = new File("D:\\develop\\work_document\\ERP系统\\");
        File[] files = file.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getName().endsWith(".docx");
            }
        });
        for (File file1 : files) {
            System.out.println("docx文件名是"+file1);
        }*/

//        File file = new File("D:\\develop\\work_document\\");
//
//        recursionFile(file);

        /**
         * 文件处理
         */
        fileOperate();



    }

    /**
     * 递归查找出所有 文件名后缀 .docx
     */
    public static void recursionFile(File file){
        File[] files = file.listFiles();
        for (File file1 : files) {
            if(file1.isDirectory()){
                recursionFile(file1);
            }
            if(file1.isFile() && file1.getName().endsWith(".docx")){
                System.out.println(file1);
            }
        }
    }

    /**
     * InputStream  OutPutStream
     */

    public static void fileOperate(){
        File file = new File("D:\\develop\\work_document\\ERP系统\\8-21ER需求.txt");

        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            FileInputStream fileInputStream1 = new FileInputStream("D:\\develop\\work_document\\ERP系统\\8-21ER需求.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
