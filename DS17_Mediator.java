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
            //老板来了, 通知员工A
            ca.action();
        }
        if (content.equals("client")) {
            //客户来了,通知前台B
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
        System.out.println("普通员工努力工作");
    }
}

class ColleagueB extends Colleague {

    public void action() {
        System.out.println("前台注意了!");
    }
}

public class DS17_Mediator {

    public static void main(String[] args) {
        Mediator med = new ConcreteMediator();
        //老板来了
        med.notice("boss");
        
        //客户来了
        med.notice("client");
    }
}



