package cn.itcast.comparedemo;

public class Person implements Comparable{		// crl + 1  添加未实现方法
	private String name;
	private int age;
	
	public Person() {								// Alt + shift + s
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 建立了Person对象判断是否相同的依据， 只要是同姓名就是同一个人。
	 */
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		
		if (this == obj)
			return true;
		if (!(obj instanceof Person)) {
			throw new ClassCastException("类型错误");
		}
		
		Person p = (Person)obj;
		
		return this.name.equals(p.name) && this.age == p.age;
		
		
	}

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	/**
	 * 比较年龄大小的方法。
	 */
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		if (!(o instanceof Person)) {
			throw new ClassCastException("类型错误");
		}
		Person p = (Person)o;
//		if (this.age > p.age) {
//			return 1;
//		}
//		if (this.age < p.age)
//			return -1;
//		return 0;
		return this.age - p.age;
		
	}
	
	
}
