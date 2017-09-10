//������Ӳ��Ǻܺá�
//Hand*er 

interface RequestHandle {

    void handleRequest(Request request);
}


//ConcreteHandler
class HRRequestHandle implements RequestHandle {

    public void handleRequest(Request request) {
        if (request instanceof DimissionRequest) {
            System.out.println("Ҫ��ְ, ��������!");
        } 

        System.out.println("�������");
    }
}


class PMRequestHandle implements RequestHandle {

    RequestHandle rh;
    
    public PMRequestHandle(RequestHandle rh) {
        this.rh = rh;
    }
    
    public void handleRequest(Request request) {
        if (request instanceof AddMoneyRequest) {
            System.out.println("Ҫ��н, ��Ŀ��������!");
        } else {
            rh.handleRequest(request);
        }
    }
}

class TLRequestHandle implements RequestHandle {

    RequestHandle rh;
    
    public TLRequestHandle(RequestHandle rh) {
        this.rh = rh;
    }

    public void handleRequest(Request request) {
        if (request instanceof LeaveRequest) {
            System.out.println("Ҫ���, ��Ŀ�鳤����!");
        } else {
            rh.handleRequest(request);
        }
    }
}


public class DF13_CHAIN{    
    public static void main(String[] args) {
        RequestHandle hr =new HRRequestHandle();
        RequestHandle pm = new PMRequestHandle(hr);
        RequestHandle tl = new TLRequestHandle(pm);
        
        //team leader������ְ����
        Request request = new DimissionRequest();
        tl.handleRequest(request);
        
        System.out.println("===========");
        //team leader�����н����
        request = new AddMoneyRequest();
        tl.handleRequest(request);
        
        System.out.println("========");
        //��Ŀ���������ְ����
        request = new DimissionRequest();
        pm.handleRequest(request);
    }
}





