package strategy1.step5.modularization.copy;

import strategy1.step4.interfaces.FlyNo;
import strategy1.step4.interfaces.KnifeWood;
import strategy1.step4.interfaces.MissileYes;

public class StandardRobot extends Robot {
	
	public StandardRobot() {
		setFly(new FlyNo());
		setMissile(new MissileYes());
		setKnife(new KnifeWood());
//		fly = new FlyNo();
//		missile = new MissileYes();
//		knife = new KnifeWood();
	}

}
