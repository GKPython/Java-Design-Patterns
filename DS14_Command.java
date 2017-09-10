//Command声明执行操作的接口
abstract class Command {
    
    protected Receiver receiver;
    
    public Command(Receiver receiver) {
        this.receiver = receiver;
    }
    
    public abstract void execute();
}

//creteCommand将一个接收者对象绑定于一个动作。调用接收者相应的操作，以实现Execute。
class CommandImpl extends Command {

    public CommandImpl(Receiver receiver) {
        super(receiver);
    }
    
    public void execute() {
        receiver. receive ();
    }
}

//Invoker要求该命令执行这个请求。

class Invoker {

    private Command command;
    
    public void setCommand(Command command) {
        this.command = command;
    }
    
    public void execute() {
        command.execute();
    }
}

//Receiver知道如何实现与执行一个请求相关的操作。任何类都可能作为一个接收者。
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



