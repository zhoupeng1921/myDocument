# 初识jvm

## 1. jvm概念

jvm是java virtual machine的简称，意为java虚拟机。虚拟机是指通过软件模拟具有完整硬件功能的、运行在一个完全隔离环境中的完整计算机系统。

vmware和visual box都是使用软件模拟物理cpu的指令集

jvm使用软件模拟java字节码的指令集

## 2. 概念

java语言定义了什么是java语言：

java语言规范：

​	语法、变量、类型、文法

词法结构

​	\u+4个16进制数字，表示UTF-16

​	行终结符

​	空白符

​	注释

​	标识符

​	关键字

​	Int Long Float Double 操作符

类型和变量

​	元类型 byte short int long float char

​	变量初识值

​	泛型

java内存模型

类加载过程

public static final abstract的定义

异常

数组的使用

....





jvm规范：

​	Class文件类型、运行时数据、栈帧、虚拟机的启动、虚拟机的指令集

jvm主要定义了二进制class文件和jvm指令集等

Class文件格式

数字内部表示和存储

returnAddress数据类型定义

​	指向操作码的指针，不对应java数据类型，不能在运行时修改

定义PC

堆

栈

方法区



## 3. 整数的表示  

​	-6

​	原码：第一位为符号位（0为正数，1为负数） 10000110

​	反码：符号位不动，原码取反 	11111001

​	负数补码：符号位不动，反码加1	11111010

​	正数补码：和原码相同



为什么要补码：

​	1. 计算0的表示：

​		0

​	正数：00000000

​	负数：10000000

​	补码：00000000

​	2. 参与运算，只需要计算两个补码的和，就可以得到正确结果，符号位也直接参与运算。

​	-6+5   11111010+00000101 = 11111111 = -1

​	-4+5   11111100+00000101 = 00000001 = 1

 

## 4. 浮点数表示

Float的表示与定义

​	支持IEEE754

​	s	 eeeeeeee 	mmmmmmmmmmmmmmmmmmmmmmm

​	符号位  指数：8			尾数：23

​	e全0，尾数附加位为0，否则尾数附加位为1（实际可以看成2 4位尾数）

​	s\*m\*2^(e-127)

​	-5        1  100000001 01000000000000000000000

​		-1\* 2<sup>(129-127)</sup>\*(2<sup>0</sup>+2<sup>-2</sup>)

## 5. vm指令集

类型转化 I2i

出栈入栈 aload astore

运算	iadd isub

流程控制 ifeq ifne

函数调用

​	invokevirtual invokeinterface invokespecial invokestatic

## 6. jvm需要对Java Library提供一下支持

反射	java.lang.reflect

ClassLoader

初始化class和interface

安全相关java.security

多线程

若引用

## 7. jvm编译

源码到jvm指令的对应格式

javap

jvm反汇编的格式



## 8. 作业

1. 有关补码，简要阐述补码的好处。并计算给出 -99, -105, 205 整数的补码
  答：简述补码的好处：
  在人们的计算概念中零是没有正负之分的，统一0的处理
  统一处理加减法，无需增加减法器操作
  正数二进制的补码等于它本身，负数的二进制补码等于取反+1
  -99：
  原码：11100011
  反码  ：10011100
  补码  ：10011101
  其它的我直接给出补码了：
  -105：10010111
  205：00000000 11001101

2. 有关浮点数，根据IEEE745，计算11000001000100000000000000000000的单精度浮点的值，并给出计算过程。
  1 符号位      10000010 值是3       00100000000000000000000  值是1.001 
  = -1 * (2^3)*(2^0 + 2^-3)
  = -8*(1+8/1)
  = -8 -1
  = -9

3.写一个Java程序，将100.2转成IEEE745 二进制表示 ，给出程序和结果。

结果：01000010110010000110011001100110
程序（ 偷懒了，嘿嘿）：
public static void main(String[] args) {
​		String value=convert(100.2f);
​		System.out.println(value);
​	}

```java
public static String convert(float num) {
	int intVal = Float.floatToIntBits(num);
	return intVal > 0 ? "0" + Integer.toBinaryString(intVal) : Integer
			.toBinaryString(intVal);
}
```
