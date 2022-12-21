package strategyquiz.modularization;

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
	public String print() {
		return super.print() + "\t[¹Ý] : " + ban;
	}
}
