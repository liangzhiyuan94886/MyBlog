package com.blog.liang.notes.controller;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class UploadFileConfig {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.print("输入从第几集开始：");
        int start = input.nextInt();
        System.out.print("输入下载至第几集：");
        int end = input.nextInt();
        System.out.print("注意：地址只要保留到/video即可，如原地址/GQ/video333.ts保留成/GQ/video"+"\n"+"输入下载地址");
        String address = input.next();
        System.out.print("输入保存路径，默认当前路径输入1：");
        String path = input.next();
        if ("1".equals(path)) {
            path = System.getProperty("user.dir");
        }
        System.out.println("下载中...请稍等");
        for (int i = start; i<=end; i++ ) {
            String http = "";
            if (i < 10) {
                http = address+"00"+i+".ts";
            }else if (i >= 10 && i < 100) {
                http = address+"0"+i+".ts";
            }else {
                http = address+i+".ts";
            }
            URL url = new URL(http);
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5 * 1000);
            InputStream inStream = conn.getInputStream();
            byte[] data = readInputStream(inStream);
            //修改指定保存地址，我这里是/home/liangliang/Downloads/mv
            File imageFile = new File(path+"/"+i+".mp4");
            FileOutputStream outStream = new FileOutputStream(imageFile);
            outStream.write(data);
            int s = end - i;
            System.out.println("第"+i+"个已完成，剩余"+s+"个");
            outStream.close();
        }
        System.out.println("下载完成查看："+path);
    }
    public static byte[] readInputStream(InputStream inStream) throws Exception{
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while( (len=inStream.read(buffer)) != -1 ){
            outStream.write(buffer, 0, len);
        }
        inStream.close();
        return outStream.toByteArray();
    }
}
