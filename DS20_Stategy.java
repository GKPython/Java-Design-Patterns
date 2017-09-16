//Strategy
abstract class Strategy {

    public abstract void method();
}

//ConcreteStrategy
class strategyImplA extends Strategy {

    public void method() {
        System.out.println("这是第一个实现");
    }
}

class StrategyImplB extends Strategy {

    public void method() {
        System.out.println("这是第二个实现");
    }
}

class StrategyImplC extends Strategy {

    public void method() {
        System.out.println("这是第三个实现");
    }
}

//Context 
class Context {

    Strategy stra;
    
    public Context(Strategy stra) {
        this.stra = stra;
    }
    
    public void doMethod() {
        stra.method();
    }
}


public class DS20_Stategy {
    
    public static void main(String[] args) {
        Context ctx = new Context(new strategyImplA());
        ctx.doMethod();
        
        ctx = new Context(new StrategyImplB());
        ctx.doMethod();
        
        ctx = new Context(new StrategyImplC());
        ctx.doMethod();
    }
}
