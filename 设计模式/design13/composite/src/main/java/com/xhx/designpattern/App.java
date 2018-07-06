package com.xhx.designpattern;

import java.util.List;
import java.util.Objects;
import java.util.Observer;

/**
 * xuhaixing
 * 2018/7/6 8:50
 **/
public class App {
    public static void main(String[] args) {
        Folder root = new Folder("c:");
        Folder rootFolder = new Folder("program files");
        File cmdFile = new File("cmd.exe");

        root.add(rootFolder);
        rootFolder.add(cmdFile);

        displayTree(root);
    }

    public static void displayTree(IFile root){
        if(Objects.isNull(root)){
            return;
        }
        root.display();
        List<IFile> child = root.getChild();
        if(Objects.isNull(child)||child.size()<=0){
            return;
        }
        child.stream().forEach(iFile->displayTree(iFile ));
    }
}
