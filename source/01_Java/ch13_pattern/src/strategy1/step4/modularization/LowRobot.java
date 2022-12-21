package strategy1.step4.modularization;

import strategy1.step4.interfaces.FlyImpl;
import strategy1.step4.interfaces.FlyNo;
import strategy1.step4.interfaces.KnifeImpl;
import strategy1.step4.interfaces.KnifeNo;
import strategy1.step4.interfaces.MissileImpl;
import strategy1.step4.interfaces.MissileNo;

public class LowRobot extends Robot {
	
	private FlyImpl fly;
	private MissileImpl missile;
	private KnifeImpl knife;
	public LowRobot() {
		setFly(new FlyNo());
		setMissile(new MissileNo());
		setKnife(new KnifeNo());
//		fly = new FlyNo();
//		missile = new MissileYes();
//		knife = new KnifeWood();
	}
	
	@Override
	public void actionFly() {
		fly.fly();
	}

	@Override
	public void actionMissile() {
		missile.Missile();
	}

	@Override
	public void actionKnife() {
		knife.Knife();
	}

	public void setFly(FlyImpl fly) {
		this.fly = fly;
	}

	public void setMissile(MissileImpl missile) {
		this.missile = missile;
	}

	public void setKnife(KnifeImpl knife) {
		this.knife = knife;
	}

}
