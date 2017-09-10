//������Ӳ�����Ҫ�ٺúÿ���

import java.util.*;
//�����ģ���������ɫ��ʹ��HashMap ���洢������Ӧ����ֵ
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

//������ʽ��ɫ��Ҳ�����ýӿ���ʵ��
abstract class Expression{
	public abstract int interpret(Context con);
}

//�ս�����ʽ��ɫ
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
	//this Ϊ����interpret ������Variable ����
		return con.LookupValue(this);
	}
}

//���ս�����ʽ��ɫ
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
			System.out.println("������Ϊ0��");
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
		//���ñ���������
		Variable a = new Variable();
		Variable b = new Variable();
		Constant c = new Constant(2);
		//Ϊ������ֵ
		con.addValue(a , 5);
		con.addValue(b , 3);
		//���㣬�Ծ��ӵĽṹ�������Լ�������������
		ex = new Division(new Multiply(a , b), new Add(new Subtract(a , b) , c));
		System.out.println("������Ϊ��"+ex.interpret(con));
	}
}