import com.xhx.dell.Dell;

module java.dell.computer {
    requires java.computer;
//    引用其它模块的服务接口,在本模块实现
    provides com.xhx.computer.IComputer with Dell;
}