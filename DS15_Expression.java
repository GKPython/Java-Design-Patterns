//这个例子不错，需要再好好看看

import java.util.*;
//上下文（环境）角色，使用HashMap 来存储变量对应的数值
class Context{
	private Map valueMap = new HashMap();
	public void addValue(Variable x , int y){
		Integer yi = new Integer(y);
		valueMap.put(x , yi);
	}

	public int LookupValue(Variable x){
		int i = ((Integer)valueMap.get(x)).intValue();
		return i ;
	}
}

//抽象表达式角色，也可以用接口来实现
abstract class Expression{
	public abstract int interpret(Context con);
}

//终结符表达式角色
class Constant extends Expression{
	private int i ;
	public Constant(int i){
		this.i = i;
	}
	public int interpret(Context con){
		return i ;
	}
}

class Variable extends Expression{
	public int interpret(Context con) {
	//this 为调用interpret 方法的Variable 对象
		return con.LookupValue(this);
	}
}

//非终结符表达式角色
class Add extends Expression{
	private Expression left ,right ;
	public Add(Expression left , Expression right) {
		this.left = left ;
		this.right= right ;
	}
	public int interpret(Context con){
		return left.interpret(con) + right.interpret(con);
	}
}

class Subtract extends Expression{
	private Expression left , right ;
	public Subtract(Expression left , Expression right) {
		this.left = left ;
		this.right= right ;
	}
	public int interpret(Context con){
		return left.interpret(con) - right.interpret(con);
	}
}

class Multiply extends Expression{
	private Expression left , right ;
	public Multiply(Expression left , Expression right){
		this.left = left ;
		this.right= right ;
	}
	public int interpret(Context con){
		return left.interpret(con) * right.interpret(con);
	}
}

class Division extends Expression{
	private Expression left , right ;
	public Division(Expression left , Expression right){
		this.left = left ;
		this.right= right ;
	}
	public int interpret(Context con){
		try{
			return left.interpret(con) / right.interpret(con);
		}catch(ArithmeticException ae) {
			System.out.println("被除数为0！");
			return -11111;
		}
	}
}

public class DS15_Expression
{
	private static Expression ex ;
	private static Context con ;
	public static void main(String[] args){
		con = new Context();
		//设置变量、常量
		Variable a = new Variable();
		Variable b = new Variable();
		Constant c = new Constant(2);
		//为变量赋值
		con.addValue(a , 5);
		con.addValue(b , 3);
		//运算，对句子的结构由我们自己来分析，构造
		ex = new Division(new Multiply(a , b), new Add(new Subtract(a , b) , c));
		System.out.println("运算结果为："+ex.interpret(con));
	}
}