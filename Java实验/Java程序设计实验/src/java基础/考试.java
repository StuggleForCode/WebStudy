package java基础;

import java.util.Random;

public class 考试 {
	public class Person {
		String name = “小芳”;

		public Person(String name) {
			name = “小兰”;
		}

		public void show() {
		this.name = “小翠”;
		}

		public static void main(String[] args) {
		Person p = new Person(“小凤”);
		System.out.print(p.name);
		p.show();
		System.out.print(p.name);
		}
		}
}
