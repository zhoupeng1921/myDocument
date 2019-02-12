package com.xhx.java;

import java.io.*;
import java.util.*;

public class MergeSort {
    private static final int SPLIT_SIZE=500000;

    private static final String SPLIT_DIR="E:\\merge";

    private static final  String PREFIX = "big_data_";

    private static final  String SUFFIX=".txt";

    private  String outFile = "E:\\result.txt";
    //分割了多少文件
    private int fileNum = 0;


    public static void main(String[] args) {
        MergeSort ms = new MergeSort();
        ms.splitFile("E:\\num.txt");

        ms.mergeFile();

    }

    private void mergeFile() {
        //获取目录下所有文件
        File[] files = new File(SPLIT_DIR).listFiles();

        List<FileInfo> fileList = new ArrayList<>();
        //初始化FileInfo的List
        try {
            for(File file:files){
                BufferedReader reader = new BufferedReader(new FileReader(file));
                FileInfo fileInfo = new FileInfo();
                fileInfo.setReader(reader);
                fileInfo.setFname(file.getName());
                fileInfo.setCurrentNum(Integer.valueOf(reader.readLine()));
            }

            //开始归并
            Collections.sort(fileList,(o1,o2)->o1.getCurrentNum()-o2.getCurrentNum());

            BufferedWriter bw = new BufferedWriter(new FileWriter(outFile));
            while(!fileList.isEmpty()){
                FileInfo fileInfo = fileList.get(0);
                System.out.println(fileInfo.getCurrentNum());
                bw.write(fileInfo.getCurrentNum()+"\r\n");

                fileInfo.readNext();
                //如果文件读取完毕，从队列中移除
                if(fileInfo.getCurrentNum()==-1){
                    fileList.remove(fileInfo);
                }
                Collections.sort(fileList,(o1,o2)->o1.getCurrentNum()-o2.getCurrentNum());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public  void splitFile(String fname){
        //每一行的数据
        String data;
        //存储读入了多少行(计数器)
        int count = 0;
        try(BufferedReader br = new BufferedReader(new FileReader(fname))) {
                        //暂时存储被分割的数据
            SortedSet<Integer> set = new TreeSet<>();
            do {
                data = br.readLine();
                if (data != null) {
                    set.add(Integer.valueOf(data));
                    count++;
                    if (count >= SPLIT_SIZE) {
                        System.out.println("文件分割=======");
                        writeFile(SPLIT_DIR, set);
                        count = 0;
                        set.clear();
                    }
                }
            } while (data != null);
            if (!set.isEmpty()) {
                writeFile(SPLIT_DIR, set);
                count = 0;
                set.clear();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void writeFile(String splitDir, SortedSet<Integer> set) {
        File dir = new File(splitDir);
        if(!dir.exists()){
            dir.mkdir();
        }
        fileNum++;
        String fName = SPLIT_DIR+System.getProperty("file.separator")+PREFIX+fileNum+ SUFFIX;

        Iterator<Integer> iter = set.iterator();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fName))){
            while (iter.hasNext()){
                bw.write(iter.next()+"\r\n");
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
