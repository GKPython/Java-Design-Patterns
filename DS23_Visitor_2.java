//Visitor
//不是很理解这个有问题
import java.util.*;

interface Visitor {

    public void visitString(StringElement stringE);
    
    public void visitFloat(FloatElement floatE);
    
    public void visitCollection(Collection collection); 
}

//ConcreteVisitor 
class ConcreteVisitor implements Visitor {

    public void visitCollection(Collection collection) {
        // TODO Auto-generated method stub
        Iterator iterator = (Iterator)collection.iterator();
        while (iterator.hasNext()) {
            Object o = iterator.next();
            if (o instanceof Visitable) {
                ((Visitable)o).accept(this);
            }
        }
    }

    public void visitFloat(FloatElement floatE) {
        System.out.println(floatE.getFe());
    }

    public void visitString(StringElement stringE) {
        System.out.println(stringE.getSe());
    }
}

//Element
interface Visitable {

    public void accept(Visitor visitor);
}


//ConcreteElement
class FloatElement implements Visitable {

    private Float fe;
    
    public FloatElement(Float fe) {
        this.fe = fe;
    }
    
    public Float getFe() {
        return this.fe;
    }
    
    public void accept(Visitor visitor) {
        visitor.visitFloat(this);
    }
}

class StringElement implements Visitable {

    private String se;
    
    public StringElement(String se) {
        this.se = se;
    }
    
    public String getSe() {
        return this.se;
    }
    
    public void accept(Visitor visitor) {
        visitor.visitString(this);
    }
}

public class DS23_Visitor{

    public static void main(String[] args) {
        Visitor visitor = new ConcreteVisitor();
        StringElement se = new StringElement("abc");
        se.accept(visitor);
        
        FloatElement fe = new FloatElement(new Float(1.5));
        fe.accept(visitor);
        System.out.println("===========");
        List result = new ArrayList();
        result.add(new StringElement("abc"));
        result.add(new StringElement("abc"));
        result.add(new StringElement("abc"));
        //result.add(new FloatElement(new Float(1.5)));
       // result.add(new FloatElement(new Float(1.5)));
        //result.add(new FloatElement(new Float(1.5)));
        visitor.visitCollection(result);
    }
}

