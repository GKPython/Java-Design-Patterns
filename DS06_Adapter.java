interface Target {

    void adapteeMethod();
    
    void adapterMethod();
}

class Adaptee {
    public void adapteeMethod() {
        System.out.println("Adaptee method!");
    }
}

class Adapter implements Target {

    private Adaptee adaptee;
    
    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

	public void adapteeMethod() {
		adaptee.adapteeMethod();
	}

	public void adapterMethod() {
		System.out.println("Adapter method!");
    }
}

public class DS06_Adapter{

    public static void main(String[] args) {
        Target target = new Adapter(new Adaptee());
        target.adapteeMethod();
        
        target.adapterMethod();
    }
}
