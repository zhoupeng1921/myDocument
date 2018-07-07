package com.xhx.designpattern;

import java.util.ArrayList;
import java.util.List;

/**
 * xuhaixing
 * 2018/7/6 8:46
 **/
public class Folder extends IFile {
    private List<IFile> children;

    public Folder(String name){
        super(name);
        children = new ArrayList<IFile>();
    }

    public void display() {
        System.out.println(name);
    }

    public boolean add(IFile iFile) {
        return children.add(iFile);
    }

    public boolean remove(IFile iFile) {
        return children.remove(iFile);
    }

    public List<IFile> getChild() {
        return children;
    }
}
