//Component定义一个对象接口，可以给这些对象动态地添加职责。
interface Person {

    void eat();
}

//ConcreteComponent 定义一个对象，可以给这个对象添加一些职责。
class Man implements Person {

	public void eat() {
		System.out.println("男人在吃");
	}
}

//Decorator 维持一个执行Component对象的指针，并定义一个与Componect 接口一致的接口。
abstract class Decorator implements Person {

    protected Person person;
    
    public void setPerson(Person person) {
        this.person = person;
    }
    
    public void eat() {
        person.eat();
    }
}

//ConcreteDectrator 想组建添加职责
class ManDecoratorA extends Decorator {

    public void eat() {
        super.eat();
        reEat();
        System.out.println("ManDecoratorA类");
    }

    public void reEat() {
        System.out.println("再吃一顿饭");
    }
}

class ManDecoratorB extends Decorator {
    
    public void eat() {
        super.eat();
        System.out.println("===============");
        System.out.println("ManDecoratorB类");
    }
}

public class DS09_Decorator{

    public static void main(String[] args) {
        Man man = new Man();
        ManDecoratorA md1 = new ManDecoratorA();
        ManDecoratorB md2 = new ManDecoratorB();
        
        md1.setPerson(man);
		md1.eat();
        md2.setPerson(md1);
        md2.eat();
    }
}


