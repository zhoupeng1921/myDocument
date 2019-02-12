package com.xhx.java;

import java.io.BufferedReader;
import java.io.IOException;

public class FileInfo {
    //小文件的文件名
    private String fname;

    //当前指向文件里的值
    private int currentNum;

    //类似文件指针的作用
    private BufferedReader reader;

    public void readNext(){
        try {
            String data = reader.readLine();
            if(data !=null){
                this.currentNum = Integer.valueOf(data);
            }else {
                this.currentNum = -1;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public int getCurrentNum() {
        return currentNum;
    }

    public void setCurrentNum(int currentNum) {
        this.currentNum = currentNum;
    }

    public BufferedReader getReader() {
        return reader;
    }

    public void setReader(BufferedReader reader) {
        this.reader = reader;
    }
}
