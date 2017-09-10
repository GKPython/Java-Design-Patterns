//Command����ִ�в����Ľӿ�
abstract class Command {
    
    protected Receiver receiver;
    
    public Command(Receiver receiver) {
        this.receiver = receiver;
    }
    
    public abstract void execute();
}

//creteCommand��һ�������߶������һ�����������ý�������Ӧ�Ĳ�������ʵ��Execute��
class CommandImpl extends Command {

    public CommandImpl(Receiver receiver) {
        super(receiver);
    }
    
    public void execute() {
        receiver. receive ();
    }
}

//InvokerҪ�������ִ���������

class Invoker {

    private Command command;
    
    public void setCommand(Command command) {
        this.command = command;
    }
    
    public void execute() {
        command.execute();
    }
}

//Receiver֪�����ʵ����ִ��һ��������صĲ������κ��඼������Ϊһ�������ߡ�
class Receiver {

    public void receive() {
        System.out.println("This is Receive class!");
    }
}

public class DS14_Command{

    public static void main(String[] args) {
        Receiver rec = new Receiver();
        Command cmd = new CommandImpl(rec);
        Invoker i = new Invoker();
        i.setCommand(cmd);
        i.execute();
    }
}



