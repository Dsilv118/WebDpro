package strategy1.step3;

public class SuperRobot extends Robot {
	@Override
	public void actionFly() {
		System.out.println("날 수 있습니다");
	}
	@Override
	public void actionMissile() {
		System.out.println("미사일을 쏠 수 있습니다");
	}
	@Override
	public void actionKnife() {
		System.out.println("레이저 검이 있습니다");
	}
}
