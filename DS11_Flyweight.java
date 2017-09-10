import java.util.*;

//这个例子不太好

//Flyweight 
interface Flyweight {

    void action(int arg);
}

//ConcreteFlyweight
class FlyweightImpl implements Flyweight {

    public void action(int arg) {
        // TODO Auto-generated method stub
        System.out.println("参数值:" + arg);
    }
}

//FlyweightFactory 
class FlyweightFactory {

    private static Map flyweights = new HashMap();
    
    public FlyweightFactory(String arg) {
        flyweights.put(arg, new FlyweightImpl());
    }
    
    public static Flyweight getFlyweight(String key) {
        if (flyweights.get(key) == null) {
            flyweights.put(key, new FlyweightImpl());
        }
        return (Flyweight)flyweights.get(key);
    }
    
    public static int getSize() {
        return flyweights.size();
    }
}


//Test
public class DS11_Flyweight{

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Flyweight fly1 = FlyweightFactory.getFlyweight("a");
        fly1.action(1);
        
        Flyweight fly2 = FlyweightFactory.getFlyweight("a");
        System.out.println(fly1 == fly2);
        
        Flyweight fly3 = FlyweightFactory.getFlyweight("b");
        fly3.action(2);
        
        Flyweight fly4 = FlyweightFactory.getFlyweight("c");
        fly4.action(3);
        
        Flyweight fly5 = FlyweightFactory.getFlyweight("d");
        fly4.action(4);
        
        System.out.println(FlyweightFactory.getSize());
    }
}

