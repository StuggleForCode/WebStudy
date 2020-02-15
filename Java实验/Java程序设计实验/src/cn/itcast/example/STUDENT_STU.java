package cn.itcast.example;

public class STUDENT_STU {
	int id;
	String name;
	double score;
	
	public STUDENT_STU(int id, String name, double score){
		this.id = id;
		this.name = name;
		this.score = score;
	}
	
	public void Evaluation() {
		if(score > 90) {
			System.out.println("三好学生");
		}
		else {
			System.out.println("普通学生");
		}
	}

}
