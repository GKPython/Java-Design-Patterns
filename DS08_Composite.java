//Component
import java.util.*;

abstract class Employer {

    private String name;
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return this.name;
    }
    
    public abstract void add(Employer employer);
    
    public abstract void delete(Employer employer);
    
    public List employers;
    
    public void printInfo() {
        System.out.println(name);
    }
    
    public List getEmployers() {
        return this.employers;
    }
}


//Leaf
class Programmer extends Employer {

    public Programmer(String name) {
        setName(name);
        employers = null;//����Ա, ��ʾû��������
    }

    public void add(Employer employer) {
        
    }

    public void delete(Employer employer) {
        
    }
}

class ProcectAssistant extends Employer {

    public ProcectAssistant(String name) {
        setName(name);
        employers = null;//��Ŀ����, ��ʾû��������
    }

    public void add(Employer employer) {
        
    }

    public void delete(Employer employer) {
        
    }
}


//Composite
class ProjectManager extends Employer {
    
    public ProjectManager(String name) {
        setName(name);
        employers = new ArrayList();
    }
    
    public void add(Employer employer) {
        employers.add(employer);
    }

    public void delete(Employer employer) {
        employers.remove(employer);
    }
}


//Client
public class DS08_Composite {

    public static void main(String[] args) {
        Employer pm = new ProjectManager("��Ŀ����");
        Employer pa = new ProcectAssistant("��Ŀ����");
        Employer programmer1 = new Programmer("����Աһ");
        Employer programmer2 = new Programmer("����Ա��");
        
        pm.add(pa);//Ϊ��Ŀ���������Ŀ����
        pm.add(programmer2);//Ϊ��Ŀ������ӳ���Ա
        
		//ע�⣬�����������<>����Ķ�������Ȼ���ܱ���ͨ�����������Ϊ���ͱ��
        List<Employer> ems = pm.getEmployers();
		int emsCount = ems.size();
		for(int i = 0; i <emsCount;++i)
		{
			Employer em = ems.get(i);
			System.out.println(em.getName());
		}
		/*
        for (Employer em : ems) {
            System.out.println(em.getName());
        }
		*/
    }
}



