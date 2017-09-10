//Component����һ������ӿڣ����Ը���Щ����̬�����ְ��
interface Person {

    void eat();
}

//ConcreteComponent ����һ�����󣬿��Ը�����������һЩְ��
class Man implements Person {

	public void eat() {
		System.out.println("�����ڳ�");
	}
}

//Decorator ά��һ��ִ��Component�����ָ�룬������һ����Componect �ӿ�һ�µĽӿڡ�
abstract class Decorator implements Person {

    protected Person person;
    
    public void setPerson(Person person) {
        this.person = person;
    }
    
    public void eat() {
        person.eat();
    }
}

//ConcreteDectrator ���齨���ְ��
class ManDecoratorA extends Decorator {

    public void eat() {
        super.eat();
        reEat();
        System.out.println("ManDecoratorA��");
    }

    public void reEat() {
        System.out.println("�ٳ�һ�ٷ�");
    }
}

class ManDecoratorB extends Decorator {
    
    public void eat() {
        super.eat();
        System.out.println("===============");
        System.out.println("ManDecoratorB��");
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


