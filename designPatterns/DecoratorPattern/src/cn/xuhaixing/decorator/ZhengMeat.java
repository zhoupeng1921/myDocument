package cn.xuhaixing.decorator;

/**
 * 装饰者2
 * @author xuhaixing
 *
 */
public class ZhengMeat extends DecMeat {

	private Meat meat;
	public ZhengMeat(Meat meat) {
		this.meat = meat;
	}

	@Override
	public void makeMeat() {
		System.out.println("蒸");
		meat.makeMeat();
	}

}
