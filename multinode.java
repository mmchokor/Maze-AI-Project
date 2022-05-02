import java.util.ArrayList;

public class multinode <T> {
    public T data;
    public int id=1;
    public multinode<T> parent=null;
    public ArrayList<multinode<T>> children;
    
    public multinode(T data,int id)
    {
        this.data = data;
        children = new ArrayList<multinode<T>>();
        parent=null;
        this.id=id;
    }
    public multinode(T data,multinode<T> p,int id)
    {
        this.data = data;
        children = new ArrayList<multinode<T>>();
        parent=p;
        this.id=id;
    }
    public void setData(T data)
    {
        this.data = data;
    }
    public T getData()
    {
        return data;
    }
    public multinode<T> getNode(int x)
    {
        if (x >= 0 && x < children.size()) {
            return children.get(x);

        } else {
            return null;

        }
    }
    public multinode<T> getParent()
    {
        return parent;
    }
    public void insertchildren(T data,int id)
    {
        multinode<T> n=new multinode<>(data,this,id);
        children.add(n);
    }
    boolean isEmpty()
    {
        return data==null;
    }
}

