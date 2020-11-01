package Lab_4;

public class BinarySortingTree<T extends Comparable<T>>{
    class Node{
        T el;
        Node rightChild;
        Node leftChild;
        Node(T element){
            el = element;
            rightChild = null;
            leftChild = null;
        }
    }
    private Node root;
    public BinarySortingTree(){
        root = null;
    }
    public void add(T element){
        Node node = new Node(element);
        if(root==null){
            root = node;
        } else{
            Node current = root;
            boolean isAdded = false;
            while(!isAdded){
                if(current.el.compareTo(element)>0){
                    if((current.leftChild)==null){
                        current.leftChild = node;
                        isAdded=true;
                    }
                    current = current.leftChild;
                }else if(current.el.compareTo(element)<0){
                    if((current.rightChild)==null){
                        current.rightChild = node;
                        isAdded=true;
                    }
                    current = current.rightChild;
                }else{
                    //current.el.compareTo(element)==0
                    // элемент уже добавлен
                    isAdded=true;
                }
            }
        }
        return;
    }
    public boolean find(T element){
        if(root==null){
            return false;
        }else{
            Node current = root;
            while(true) {
                if(current.el.compareTo(element)>0){
                    current = current.leftChild;
                    if(current == null){
                        return false;
                    }
                }else if(current.el.compareTo(element)<0){
                    current = current.rightChild;
                    if(current==null){
                        return false;
                    }
                } else {
                    return true;
                }
            }
        }
    }
    public void RootLeftRight(){
        System.out.println("Go Root-Left-Right:");
        callRoLR(root);
    }
    private void callRoLR(Node node){
        if(node!=null){
        System.out.println(node.el + " ");
        callRoLR(node.leftChild);
        callRoLR(node.rightChild);
        }
    }
    public void LeftRightRoot(){
        System.out.println("Go Left-Right-Root:");
        callLRRo(root);
    }
    private void callLRRo(Node node){
        if(node!=null){
            callLRRo(node.leftChild);
            callLRRo(node.rightChild);
            System.out.println(node.el + " ");
        }
    }
    public void LeftRootRight(){
        System.out.println("Go Left-Root-Right:");
        callLRoR(root);
    }
    private void callLRoR(Node node) {
        if (node != null) {
            callLRoR(node.leftChild);
            System.out.print(node.el + " ");
            callLRoR(node.rightChild);
        }
    }
    public void delete(T element){
        if(root==null){
            System.out.println("Your tree is empty!");
            return;
        }
        if(element ==root.el){
            if(root.rightChild==null){
                root = root.leftChild;
                return;
            } else {
                Node current = root.rightChild;
                if(current.leftChild==null){
                    current.leftChild = root.leftChild;
                    root = current;
                    return;
                } else {
                    Node preCurrent = root;
                    while (current.leftChild!=null){
                        preCurrent = current;
                        current = current.leftChild;
                    }
                    current.leftChild = root.leftChild;
                    preCurrent.leftChild = current.rightChild;
                    current.rightChild = root.rightChild;
                    root = current;
                    return;
                }
            }
        }
        if (find(element)){
            Node current = root;
            Node parent = null;
            boolean isFound = false;
            boolean isToTheRightSight = true;
            while(!isFound) {
                if(current.el.compareTo(element)>0){
                    parent = current;
                    isToTheRightSight = false;
                    current = current.leftChild;
                }else if(current.el.compareTo(element)<0){
                    parent = current;
                    isToTheRightSight = true;
                    current = current.rightChild;
                } else {
                    isFound = true;
                }
            }
            if((current.rightChild!=null)&&(current.leftChild!=null)){
                Node preCurrent = parent;
                Node tmpl = current.leftChild;
                Node tmpr = current.rightChild;
                current = current.rightChild;
                if(current.leftChild==null){
                    if(isToTheRightSight){
                        parent.rightChild = current;
                    } else{
                        parent.leftChild = current;
                    }
                    current.leftChild = tmpl;
                    return;
                }
                while(current.leftChild!=null){
                    preCurrent = current;
                    current = current.leftChild;
                }
                if (current.rightChild!=null){
                    preCurrent.leftChild = current.rightChild;
                } else {
                    preCurrent.leftChild = null;
                }
                if(isToTheRightSight){
                    parent.rightChild = current;
                } else{
                    parent.leftChild = current;
                }
                current.rightChild = tmpr;
                current.leftChild = tmpl;
            }else{
                if((current.rightChild==null)&&(current.leftChild!=null)){
                    if(current==root){
                        root = current.leftChild;
                        return;
                    }
                    if(isToTheRightSight){
                        parent.rightChild = current.leftChild;
                    }else{
                        parent.leftChild = current.leftChild;
                    }
                } else if((current.rightChild!=null)&&(current.leftChild==null)){
                    if(current==root){
                        root = current.rightChild;
                        return;
                    }
                    if(isToTheRightSight){
                        parent.rightChild = current.rightChild;
                    }else{
                        parent.leftChild = current.rightChild;
                    }
                }else{
                    if(current==root){
                        root = null;
                        return;
                    }
                    if(isToTheRightSight){
                        parent.rightChild = null;
                    }else{
                        parent.leftChild = null;
                    }
                }
            }
        } else {
            //System.out.println("There is no " + element + " is your tree!");
            System.out.println("There is no such element is your tree!");
        }
    }
}
