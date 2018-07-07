package com.xhx.designpattern;

import java.util.List;

/**
 * xuhaixing
 * 2018/7/6 8:42
 *
 * 文件节点抽象（是文件和目录的父类）
 **/
public abstract class IFile {
    protected String name;
    public IFile(String name){
        this.name=name;
    }

    //显示文件或者文件夹的名称
    public abstract  void display();

    //添加
    public abstract  boolean add(IFile iFile);

    //移除
    public abstract  boolean remove(IFile iFile);

    //获得子节点
    public abstract  List<IFile> getChild();
}
