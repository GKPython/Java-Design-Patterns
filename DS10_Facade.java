
interface ServiceA{ 
	public void methodA();
} 

interface ServiceB{ 
	public void methodB();
} 

interface ServiceC{ 
	public void methodC();
} 

//Subsystemclasse*
class ServiceAImpl implements ServiceA {

    public void methodA() {
        System.out.println("这是服务A");
    }
}

class ServiceBImpl implements ServiceB {

    public void methodB() {
        System.out.println("这是服务B");
    }
}

class ServiceCImpl implements ServiceC {

    public void methodC() {
        System.out.println("这是服务C");
    }
}

//Facade 
class Facade {

    ServiceA sa;
    
    ServiceB sb;
    
    ServiceC sc;
    
    public Facade() {
        sa = new ServiceAImpl();
        sb = new ServiceBImpl();
        sc = new ServiceCImpl(); 
    }
    
    public void methodA() {
        sa.methodA();
        //sb.methodB();
    }
    
    public void methodB() {
        sb.methodB();
        //sc.methodC();
    }
    
    public void methodC() {
        sc.methodC();
        //sa.methodA();
    }
}


public class DF10_Facade {
    
    public static void main(String[] args) {
    	ServiceA sa = new ServiceAImpl();
    	ServiceB sb = new ServiceBImpl();
        
        sa.methodA();
        sb.methodB();
        
        System.out.println("========");
        //facade
        Facade facade = new Facade();
        facade.methodA();
        facade.methodB();
    }
}


