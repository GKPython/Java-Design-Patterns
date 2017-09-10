//Proxy 
class ProxyObject implements Object {

    Object obj;
    
    public ProxyObject() {
        System.out.println("���Ǵ�����");
        obj = new ObjectImpl();
    }
    
    public void action() {
        System.out.println("����ʼ");
        obj.action();
        System.out.println("�������");
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
        System.out.println("���Ǳ��������");
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




