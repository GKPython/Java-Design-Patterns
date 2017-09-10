//Subject 
import java.util.*;

abstract class Citizen {
    
    ArrayList pols;
    
    String help = "normal";
    
    public void setHelp(String help) {
        this.help = help;
    }
    
    public String getHelp() {
        return this.help;
    }
    
    abstract void sendMessage(String help);

    public void setPolicemen() {
        this.pols = new ArrayList();
    }
    
    public void register(Policeman pol) {
        this.pols.add(pol);
    }

    public void unRegister(Policeman pol) {
        this.pols.remove(pol);
    }
}

//Observer 
interface Policeman {

    void action(Citizen ci);
}

//ConcreteSubjec
class HuangPuCitizen extends Citizen {

    public HuangPuCitizen(Policeman pol) {
        setPolicemen();
        register(pol);
    }
    
    public void sendMessage(String help) {
        setHelp(help);
        for(int i = 0; i < pols.size(); i++) {
            Policeman pol = (Policeman)pols.get(i);
            //֪ͨ�����ж�
            pol.action(this);
        }
    }
}

class TianHeCitizen extends Citizen {

    public TianHeCitizen(Policeman pol) {
        setPolicemen();
        register(pol);
    }
    
    public void sendMessage(String help) {
        setHelp(help);
        for (int i = 0; i < pols.size(); i++) {
            Policeman pol = (Policeman)pols.get(i);
            //֪ͨ�����ж�
            pol.action(this);
        }
    }
}

//ConcreteObserver 
class HuangPuPoliceman implements Policeman {

    public void action(Citizen ci) {
       String help = ci.getHelp();
        if (help.equals("normal")) {
            System.out.println("һ������, ���ó���");
        }
        if (help.equals("unnormal")) {
            System.out.println("�з�����Ϊ, ���Ҿ������!");
        }
    }
}

class TianHePoliceman implements Policeman {

    public void action(Citizen ci) {
        String help = ci.getHelp();
        if (help.equals("normal")) {
            System.out.println("һ������, ���ó���");
        }
        if (help.equals("unnormal")) {
            System.out.println("�з�����Ϊ, ��Ӿ������!");
        }
    }
}

public class DS19_Observer{

    public static void main(String[] args) {
        Policeman thPol = new TianHePoliceman();
        Policeman hpPol = new HuangPuPoliceman();
        
        Citizen citizen = new HuangPuCitizen(hpPol);
		citizen.register(thPol);
        citizen.sendMessage("unnormal");
        citizen.sendMessage("normal");
        
        System.out.println("===========");
        
        citizen = new TianHeCitizen(thPol);
        citizen.sendMessage("normal");
        citizen.sendMessage("unnormal");
    }
}
