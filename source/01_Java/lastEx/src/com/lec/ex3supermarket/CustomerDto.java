package com.lec.ex3supermarket;

// �Է¿� : �� id, ��ȭ, �̸�, ���űݾ�, ������̸� 
// ��¿� : ���̵�, ��ȭ, �̸�, ����Ʈ, ���Ŵ���, ������̸�, �������� ���� �߰� ������ �ݾ�

public class CustomerDto {
	private int cid;
	private String ctel;
	private String cname;
	private int cpoint;
	private int cbuy;
	private String cgname;
	private int proc;
	private int grnd;
	
	public CustomerDto() {}
	// �Է¿� : �� id, ��ȭ, �̸�, ���űݾ�, ������̸� 
	public CustomerDto(int cid, String ctel, String cname, String cgname, int proc) {
		super();
		this.cid = cid;
		this.ctel = ctel;
		this.cname = cname;
		this.cgname = cgname;
		this.proc = proc;
	}
	// ��¿� : ���̵�, ��ȭ, �̸�, ����Ʈ, ���Ŵ���, ������̸�, �������� ���� �߰� ������ �ݾ�
	public CustomerDto(int cid, String ctel, String cname, int cpoint, int cbuy, String cgname, int grnd) {
		this.cid = cid;
		this.ctel = ctel;
		this.cname = cname;
		this.cpoint = cpoint;
		this.cbuy = cbuy;
		this.cgname = cgname;
		this.grnd = grnd;
	}


	@Override
	public String toString() {
		return cid + "\t" + ctel + "\t" + cname + "\t" + cpoint + "\t" + cbuy + "\t" + cgname + "\t" + grnd;
	}
	// getter & setter
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCtel() {
		return ctel;
	}
	public void setCtel(String ctel) {
		this.ctel = ctel;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public int getCpoint() {
		return cpoint;
	}
	public void setCpoint(int cpoint) {
		this.cpoint = cpoint;
	}
	public int getCbuy() {
		return cbuy;
	}
	public void setCbuy(int cbuy) {
		this.cbuy = cbuy;
	}
	public String getCgname() {
		return cgname;
	}
	public void setCgname(String cgname) {
		this.cgname = cgname;
	}
	public int getGrnd() {
		return grnd;
	}
	public void setGrnd(int grnd) {
		this.grnd = grnd;
	}
	public int getProc() {
		return proc;
	}
	public void setProc(int proc) {
		this.proc = proc;
	}
	
}
