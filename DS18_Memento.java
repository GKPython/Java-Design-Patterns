//Memento
class Memento {

    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}


//Or*ginator 
class Originator {

    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    
    public Memento createMemento() {
        return new Memento(state);
    }
    
    public void setMemento(Memento memento) {
        state = memento.getState();
    }
    
    public void showState(){
        System.out.println(state);
    }
}

//Caretaker
class Caretaker {
    
    private Memento memento;
    
    public Memento getMemento(){
        return this.memento;
    }
    
    public void setMemento(Memento memento){
        this.memento = memento;
    }
}

//
public class DS18_Memento{

    public static void main(String[] args) {
        Originator org = new Originator();
        org.setState("������");
        
        Caretaker ctk = new Caretaker ();
        ctk.setMemento(org.createMemento());//�����ݷ�װ��Caretaker
        
        org.setState("˯����");
        org.showState();//��ʾ
        
        org.setMemento(ctk.getMemento());//���������µ���
        org.showState();
    }
}
