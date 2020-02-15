package 面向的对象下;

public class Example12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student sid1 = new Student();
		Student sid2 = new Student();
		
		sid1.setter(12345);
		sid2.setter(12345);
		sid1.equals(sid2.sid);
		if(sid1 == sid2) {
			System.out.println("true");
		}
		else System.out.println("false");
	}
}


class Student{
	public int sid;
	Student(){}
	
	public void setter(int sid) {
		this.sid = sid;
	}
	
	public void equals(int sid) {
		if(this.sid == sid) {
			System.out.println("是同一个学生");
		}
		else System.out.println("不是同一个学生");
	}
}

