public class Sample {
    public Sample(){
        System.out.println("加载sample: "+this.getClass().getClassLoader().getName());
    }
}
