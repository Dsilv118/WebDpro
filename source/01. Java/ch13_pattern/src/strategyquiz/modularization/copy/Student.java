package strategyquiz.modularization.copy;

import strategyquiz.interfaces.GetStudentPay;
import strategyquiz.interfaces.JobStudy;

public class Student extends Person {
	private String ban;

	public Student(String id, String name, String ban) {
		super(id, name);
		this.ban = ban;
		setJob(new JobStudy());
		setGet(new GetStudentPay());
	}
	public void print() {
		System.out.println("\t[¹Ý] : " + ban);
	}
}
