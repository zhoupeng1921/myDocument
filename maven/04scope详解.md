# scope详解

## 1. compile

默认，表示被依赖的项目要参与到当前项目的编译、测试、运行、打包中。

## 2. test

依赖项目仅参与相关的测试工作：测试代码的编译、运行

## 3. runtime

被依赖的项目无需参与项目的编译，参与后期的测试、运行，比compile少了一个编译

## 4. provided

打包时不会打进去（有可能外部容器提供）

## 5. system

也provided相同，不过被依赖项不会从maven仓库抓，而是从本地文件系统拿，一定需要配合systemPath属性使用。

## 6. scope依赖传递

A->B->C  A依赖B，B依赖C：

当C是test或者provided时，A不依赖C，否则A依赖C，C的scope继承于B的scope