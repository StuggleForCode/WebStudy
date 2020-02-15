package 考试;

public class Singleton {
	private String name;
	private static Singleton man = new Singleton("ke la ke");
	private Singleton(String name)
	{
		this.name = name;
	}
	// 返回man的静态方法
	public static Singleton getInstance() {
		return man;
	}
}
