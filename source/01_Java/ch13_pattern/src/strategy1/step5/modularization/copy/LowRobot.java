package strategy1.step5.modularization.copy;

import strategy1.step4.interfaces.FlyNo;
import strategy1.step4.interfaces.KnifeNo;
import strategy1.step4.interfaces.MissileNo;

public class LowRobot extends Robot {
	
	public LowRobot() {
		setFly(new FlyNo());
		setMissile(new MissileNo());
		setKnife(new KnifeNo());
//		fly = new FlyNo();
//		missile = new MissileYes();
//		knife = new KnifeWood();
	}

}
