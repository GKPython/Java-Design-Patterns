import java.util.HashMap;
class Singleton
{
	//用来存放对应关系
	private static HashMap sinRegistry = new HashMap();
	static private Singleton s = new Singleton();
	//受保护的构造函数
	protected Singleton()
	{}
	public static Singleton getInstance(String name)
	{
		if(name == null)
			name = "Singleton";
		if(sinRegistry.get(name)==null)
		{
			try{
				sinRegistry.put(name , Class.forName(name).newInstance());
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		return (Singleton)(sinRegistry.get(name));
	}

	public void test()
	{
		System.out.println("getclasssuccess!");
	}
}

class SingletonChild1 extends Singleton
{
	public SingletonChild1(){}
	static public SingletonChild1 getInstance()
	{
		return (SingletonChild1)Singleton.getInstance("SingletonChild1");
	}
	public void test()
	{
		System.out.println("getclasssuccess111!");
	}
}

class SingletonChild2 extends Singleton
{
	public SingletonChild1(){}
	static public SingletonChild1 getInstance()
	{
		return (SingletonChild1)Singleton.getInstance("SingletonChild2");
	}
	public void test()
	{
		System.out.println("getclasssuccess222!");
	}
}

public class DS04_Singleton{
	
} 