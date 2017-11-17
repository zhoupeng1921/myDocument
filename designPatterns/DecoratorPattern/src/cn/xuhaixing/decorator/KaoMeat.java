package cn.xuhaixing.decorator;

/**
 * 装饰者1
 * @author xuhaixing
 *
 */
public class KaoMeat extends DecMeat {

	private Meat meat;
	public KaoMeat(Meat meat) {
		this.meat = meat;
	}

	@Override
	public void makeMeat() {
		System.out.println("烤");
		meat.makeMeat();
	}

}
