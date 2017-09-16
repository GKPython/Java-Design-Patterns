//Iterator
interface Iterator {

    Object next();
    
    void first();
    
    void last();
    
    boolean hasNext();
}


//ConcreteIterator
class IteratorImpl implements Iterator {

    private List list;
    
    private int index;
    
    public IteratorImpl(List list) {
        index = 0;
        this.list = list;
    }
    
    public void first() {
        index = 0;
    }

    public void last() {
        index = list.getSize();
    }

    public Object next() {
        Object obj = list.get(index);
        index++;
        return obj;
    }

    public boolean hasNext() {
        return index < list.getSize();
    }
}

//list
interface List {

    Iterator iterator();
    
    Object get(int index);
    
    int getSize();
    
    void add(Object obj);
}


//ConcreteAggregate
class ListImpl implements List {

    private Object[] list;
    
    private int index;
    
    private int size;
    
    public ListImpl() {
        index = 0;
        size = 0;
        list = new Object[100];
    }
    
    public Iterator iterator() {
        return new IteratorImpl(this);
    }
    
    public Object get(int index) {
        return list[index];
    }
    
    public int getSize() {
        return this.size;
    }
    
    public void add(Object obj) {
        list[index++] = obj;
        size++;
    }
}

//
public class DS16_Iterator{

    public static void main(String[] args) {
        List list = new ListImpl();
        list.add("a");
        list.add("b");
        list.add("c");
        //第一种迭代方式
        Iterator it = list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        
        System.out.println("=====");
        //第二种迭代方式
        for (int i = 0; i < list.getSize(); i++) {
            System.out.println(list.get(i));
        }
    }
}


