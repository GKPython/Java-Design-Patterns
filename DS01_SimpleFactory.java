//抽象产品
interface Car
{
	public void drive();
}

//具体产品类
class Benz implements Car{
	public void drive() {
		System.out.println("Driving Benz ");
	}
}

class Bmw implements Car{
	public void drive() {
		System.out.println("Driving Bmw ");
	}
}

//工厂类角色
class Driver{ 
	public static Car driverCar(String s)throws Exception {
		if(s.equalsIgnoreCase("Benz"))
			return  new Benz();
		else  if(s.equalsIgnoreCase("Bmw"))
			return new Bmw();
		else throw new Exception();
		}

} 

public class DS01_SimpleFactory{ 
	public static void main(String[] args) 
	{
		try{
			Car car = Driver.driverCar("Benz");
			car.drive();		     
		} 
		catch (Exception e){ 
		} 
	}
}   
