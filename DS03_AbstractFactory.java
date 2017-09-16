
//抽象产品
interface ICat {

    void eat();
}

interface IDog {

    void eat();
}

//具体产品
class BlackCat implements ICat {

    public void eat() {
        System.out.println("The black cat is eating!");
    }
}

class WhiteCat implements ICat {

    public void eat() {
        System.out.println("The white cat is eating! ");
    }
}

class BlackDog implements IDog {

    public void eat() {
        System.out.println("The black dog is eating");
    }
}

class WhiteDog implements IDog {

    public void eat() {
        System.out.println("The white dog is eating!");
    }
}


// 抽象工厂
interface IAnimalFactory{

    ICat createCat();
	
    IDog createDog();
}

//具体工厂
class BlackAnimalFactory implements IAnimalFactory {

    public ICat createCat() {
        return new BlackCat();
    }

    public IDog createDog() {
        return new BlackDog();
    }
}


class WhiteAnimalFactory implements IAnimalFactory {

    public ICat createCat() {
        return new WhiteCat();
    }

    public IDog createDog() {
        return new WhiteDog();
    }
}

public class DS03_AbstractFactory{ 
	public static void main(String[] args) {
		IAnimalFactory blackAnimalFactory = new BlackAnimalFactory();
		ICat blackCat = blackAnimalFactory.createCat();
		blackCat.eat();
		IDog blackDog = blackAnimalFactory.createDog();
		blackDog.eat();
    
		IAnimalFactory whiteAnimalFactory = new WhiteAnimalFactory();
		ICat whiteCat = whiteAnimalFactory.createCat();
		whiteCat.eat();
		IDog whiteDog = whiteAnimalFactory.createDog();
		whiteDog.eat();
	}
} 




