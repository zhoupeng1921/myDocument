import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.util.Objects;

/**
 * 把class文件拷贝出去执行，
 * 否则loader1和loader2会走classpath,本地工程执行，每次都是app加载器
 *
 * java -cp 自己指定classpath路径  xxx
 */
public class TestApp01 {

    public static void main(String[] args) throws Exception{
        MyClassLoader loader1 = new MyClassLoader("loader1");
        loader1.setPath("/media/xuhaixing/");

        MyClassLoader loader2 = new MyClassLoader(loader1,"loader2");
        loader2.setPath("/media/xuhaixing/studyDocument");

        //无父加载器
        MyClassLoader loader3 = new MyClassLoader(null,"loader3");
        //test(loader1);
        test(loader2);
        test(loader3);



    }
    public static void test(ClassLoader loader) throws Exception{
        Class<?> clazz = loader.loadClass("Sample");
        Object object = clazz.newInstance();

        Constructor<?>[] constructors =
                clazz.getConstructors();
        Object o = constructors[0].newInstance();

//        若Sample和this不是由有关系的classLoader加载的，用Sample找不到类
        //Sample o1 = (Sample) o;
        //可以反射获取属性字段值等
    }
}

class MyClassLoader extends ClassLoader {

    //类加载器名称
    private String name;

    //加载类路径
    private String path = "/media/xuhaixing/studyDocument";

    //class文件扩展名
    private final String fileType = ".class";


    public MyClassLoader(){
        super();
    }
    public MyClassLoader(String name){
        //默认加载器为App加载器
        super();
        this.name = name;
    }
    public MyClassLoader(ClassLoader classLoader, String name){
        super(classLoader);
        this.name = name;
    }


    @Override
    public Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] data = loadClassData(name);

        return this.defineClass(name, data, 0, data.length);
    }

    private byte[] loadClassData(String name) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        FileInputStream fis = null;
        FileChannel channel = null;
        try {
            fis = new FileInputStream(Paths.get(this.path,name+this.fileType).toString());
            channel = fis.getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            while (channel.read(buffer) != -1) {
                buffer.flip();
                baos.write(buffer.array(), 0, buffer.limit());
                buffer.clear();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (Objects.nonNull(fis)) {
                    fis.close();
                }
                if (Objects.nonNull(channel)) {
                    channel.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return baos.toByteArray();
    }

    @Override
    public String toString() {
        System.out.println(this.name);
        return this.name;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}