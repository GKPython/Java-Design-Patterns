//���󹤳�
interface Driver{
	public Car driverCar();
} 

//���幤����
class BenzDriver implements Driver{
	public Car driverCar(){
		return new Benz();
	}
} 

class BmwDriver implements Driver{
	public Car driverCar(){
		return new Bmw();
	}
} 

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

public class DS02_FactoryMethod 
{
	public static void main(String[] args) 
	{
		try{
			Driver driver = new BenzDriver();
			Car car = driver.driverCar();
			car.drive();
		     
		} 
		catch (Exception e){
			System.out.println(e.getMessage());
		} 
	}
}
