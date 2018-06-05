package cn.xuhaixing.decorator;

/**
 * 被装饰者
 * @author xuhaixing
 *
 */
public class PigMeat extends Meat {

	@Override
	public void makeMeat() {
		System.out.println("纯猪肉");
	}

}
