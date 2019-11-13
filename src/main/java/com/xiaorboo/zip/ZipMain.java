package com.xiaorboo.zip;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 *
 * @Author: fgd
 * @Date: 2019-11-13
 */
public class ZipMain {

    public static void main(String[] args) throws Exception{
        //需要打包的文件
        FileInputStream fileInputStream = new FileInputStream("/Users/fgd/Desktop/2.pdf");
        //压缩后的文件流
        FileOutputStream fileOutputStream = new FileOutputStream("/Users/fgd/Desktop/2.zip");
        ZipOutputStream zipOutputStream = new ZipOutputStream(fileOutputStream);
        //压缩文件内的每一个文件以及名字
        zipOutputStream.putNextEntry(new ZipEntry("2.pdf"));
        int len;
        byte[] buf = new byte[1024];
        while ((len = fileInputStream.read(buf)) != -1){
            zipOutputStream.write(buf,0,len);
        }
        //关闭各种流
        zipOutputStream.closeEntry();
        zipOutputStream.close();
        fileOutputStream.close();
        fileInputStream.close();
    }
}
