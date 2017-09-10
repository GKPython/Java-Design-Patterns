//�����Ʒ
interface Car
{
	public void drive();
}

//�����Ʒ��
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

//�������ɫ
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
