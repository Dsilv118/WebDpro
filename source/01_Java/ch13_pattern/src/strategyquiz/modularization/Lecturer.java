package strategyquiz.modularization;

import strategyquiz.interfaces.GetSalary;
import strategyquiz.interfaces.JobLec;

public class Lecturer extends Person {
	private String subject;

	public Lecturer(String id, String name, String subject) {
		super(id, name);
		this.subject = subject;
		setJob(new JobLec());
		setGet(new GetSalary());
	}
	public String print() {
		return super.print() + "\t[°ú¸ñ] : " + subject;
	}
	
}
