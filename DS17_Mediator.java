//Mediator 
abstract class Mediator {

    public abstract void notice(String content);
}

//ConcreteMediator
class ConcreteMediator extends Mediator {

    private ColleagueA ca;
    
    private ColleagueB cb;
    
    public ConcreteMediator() {
        ca = new ColleagueA();
        cb = new ColleagueB();
    }
    
    public void notice(String content) {
        if (content.equals("boss")) {
            //�ϰ�����, ֪ͨԱ��A
            ca.action();
        }
        if (content.equals("client")) {
            //�ͻ�����,֪ͨǰ̨B
            cb.action();
        }
    }
}

abstract class Colleague{ 
	public abstract void action();
} 

//Colleagueclass 
class ColleagueA extends Colleague {

    
    public void action(){
        System.out.println("��ͨԱ��Ŭ������");
    }
}

class ColleagueB extends Colleague {

    public void action() {
        System.out.println("ǰ̨ע����!");
    }
}

public class DS17_Mediator {

    public static void main(String[] args) {
        Mediator med = new ConcreteMediator();
        //�ϰ�����
        med.notice("boss");
        
        //�ͻ�����
        med.notice("client");
    }
}



