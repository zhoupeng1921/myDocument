package cn.xuhaixing.decorator;

public class MainTest {

	public static void main(String[] args) {
		//原生猪
		Meat pig = new PigMeat();
		pig.makeMeat();
		System.out.println("-----------------");
		
		//烤的猪肉
		Meat kaoPig = new KaoMeat(pig);
		kaoPig.makeMeat();
		System.out.println("------------------");
		
		//蒸的猪肉
		Meat zhengPig = new ZhengMeat(pig);
		zhengPig.makeMeat();
		System.out.println("------------------");
		
		//综合猪肉
		Meat kaozhengPig = new ZhengMeat(kaoPig);
		kaozhengPig.makeMeat();
	}

}
