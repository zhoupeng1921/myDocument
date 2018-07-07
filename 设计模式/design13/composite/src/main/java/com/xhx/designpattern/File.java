package com.xhx.designpattern;

import java.util.List;

/**
 * xuhaixing
 * 2018/7/6 8:44
 **/
public class File extends IFile {

    public File(String name){
        super(name);
    }

    public void display() {
        System.out.println(name);
    }

    public boolean add(IFile iFile) {
        return false;
    }

    public boolean remove(IFile iFile) {
        return false;
    }

    public List<IFile> getChild() {
        return null;
    }
}
