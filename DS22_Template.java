abstract class Template {

    public abstract void print();
    
    public void update() {
        System.out.println("开始打印");
        for (int i = 0; i < 10; i++) {
            print();
        }
    }
}
//ConcreteClass 

class TemplateConcrete extends Template {

    //@*verride
    public void print() {
        System.out.println("这是子类的实现");
    }
}
//Test 

public class DS22_Template {

    public static void main(String[] args) {
        Template temp = new TemplateConcrete();
        temp.update();
    }
}
