abstract class Person {

    private Clothing clothing;
    
    private String type;

    public Clothing getClothing() {
        return clothing;
    }

    public void setClothing() {
        //this.clothing = ClothingFactory.getClothing();
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    public String getType() {
        return this.type;
    }
    
    public abstract void dress();
}

class Man extends Person {
    
    public Man() {
        setType("男人");
    }
    
    public void dress() {
        Clothing clothing = getClothing();
        clothing.personDressCloth(this);
    }
}

class Lady extends Person {

    public Lady() {
        setType("女人");
    }
    
    public void dress() {
        Clothing clothing = getClothing();
        clothing.personDressCloth(this);
    }
}

abstract class Clothing {

    public abstract void personDressCloth(Person person);
}

class Jacket extends Clothing {

    public void personDressCloth(Person person) {
        System.out.println(person.getType() + "穿马甲");
    }
}

class Trouser extends Clothing {

    public void personDressCloth(Person person) {
        System.out.println(person.getType() + "穿裤子");
    }
}

public class DS07_Bright {

    public static void main(String[] args) {
        
        Person man = new Man();
        
        Person lady = new Lady();
        
        Clothing jacket = new Jacket();
        
        Clothing trouser = new Trouser();
        
        jacket.personDressCloth(man);
        trouser.personDressCloth(man);

        jacket.personDressCloth(lady);
        trouser.personDressCloth(lady);
    }
}
