//Proxy 
class ProxyObject implements Object {

    Object obj;
    
    public ProxyObject() {
        System.out.println("这是代理类");
        obj = new ObjectImpl();
    }
    
    public void action() {
        System.out.println("代理开始");
        obj.action();
        System.out.println("代理结束");
    }
}

//Subject
interface Object {

    void action();
}

//RealSubject
class ObjectImpl implements Object {

    public void action() {
        System.out.println("========");
        System.out.println("========");
        System.out.println("这是被代理的类");
        System.out.println("========");
        System.out.println("========");
    }
}

public class DS12_Proxy{
    public static void main(String[] args){
    	Object obj = new ProxyObject();
        obj.action();
    }
}




