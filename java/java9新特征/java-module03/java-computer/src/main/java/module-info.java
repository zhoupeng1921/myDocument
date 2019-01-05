
module java.computer {
    exports com.xhx.computer;
    uses com.xhx.computer.IComputer;
    provides com.xhx.computer.IComputer with com.xhx.computer.impl.Dell;
}