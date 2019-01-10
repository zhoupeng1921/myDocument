package com.scan;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.*;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;

public class ClasspathPackageScanner {
    private Logger logger = LoggerFactory.getLogger(ClasspathPackageScanner.class);
    private String basePackage;
    private ClassLoader cl;

    /**
     * For test purpose.
     */
    public static void main(String[] args) throws Exception {
        ClasspathPackageScanner scan = new ClasspathPackageScanner("com.scan");
        List<String> lists = scan.getFullyQualifiedClassNameList();
    }

    /**
     * 初始化
     *
     * @param basePackage
     */
    public ClasspathPackageScanner(String basePackage) {
        this.basePackage = basePackage;
        this.cl = getClass().getClassLoader();
    }

    public ClasspathPackageScanner(String basePackage, ClassLoader cl) {
        this.basePackage = basePackage;
        this.cl = cl;
    }

    /**
     * 获取指定包下的所有字节码文件的全类名
     */
    public List<String> getFullyQualifiedClassNameList() throws IOException {
        logger.info("开始扫描包{}下的所有类", basePackage);
        return doScan(basePackage, new ArrayList<>());
    }

    /**
     * doScan函数
     *
     * @param basePackage
     * @param nameList
     * @return
     * @throws IOException
     */
    private List<String> doScan(String basePackage, List<String> nameList) throws IOException {
        String splashPath = StringUtil.dotToSplash(basePackage);
        URL url = cl.getResource(splashPath);
        String filePath = URLDecoder.decode(StringUtil.getRootPath(url), "UTF-8");
        Set<String> names;
        if (filePath.endsWith(".jar")) {
            logger.debug("{} 是一个JAR包", filePath);
            names = readFromJarFile(filePath, splashPath);
        } else {
            logger.debug("{} 是一个目录", filePath);
            names = readFromDirectory(filePath);
        }
        for (String name : names) {
            if (name.endsWith(".class")) {
                nameList.add(toFullyQualifiedName(name, basePackage));
            } else {
                doScan(basePackage + "." + name, nameList);
            }
        }
        if (logger.isDebugEnabled()) {
            for (String n : nameList) {
                logger.debug("找到{}", n);
            }
        }
        return nameList;
    }

    private String toFullyQualifiedName(String shortName, String basePackage) {
        StringBuilder sb = new StringBuilder(basePackage);
        sb.append('.');
        sb.append(StringUtil.trimExtension(shortName));
        //打印出结果
        System.out.println(sb.toString());
        return sb.toString();
    }

    private Set<String> readFromJarFile(String jarPath, String splashedPackageName) throws IOException {
        logger.debug("从JAR包中读取类: {}", jarPath);
        JarInputStream jarIn = new JarInputStream(new FileInputStream(jarPath));
        JarEntry entry = jarIn.getNextJarEntry();
        Set<String> nameList = new HashSet<>();
        while (null != entry) {
            String name = entry.getName();
            if (name.startsWith(splashedPackageName) && name.endsWith(".class")) {
                nameList.add(name);
            }
            entry = jarIn.getNextJarEntry();
        }
        return nameList;
    }

    private Set<String> readFromDirectory(String path) {
        File file = new File(path);
        String[] names = file.list();

        if (null == names) {
            return null;
        }

        return new HashSet<String>(Arrays.asList(names));
    }
}