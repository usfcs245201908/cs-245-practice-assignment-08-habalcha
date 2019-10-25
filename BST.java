public class BST<T extends Comparable<T>>{
    Node root;

    class Node {
        Comparable data;
        Node left;
        Node right;

        public Node(Comparable item){
            data = item;
            left = null;
            right = null;
//            instance = 1;
        }

        public Comparable getData() {
            return data;
        }

        }

    public Node getRootNode() {
        return root;
    }

    public boolean find(Comparable item) {
        return find(item, root); // funciton loading
    }

    public boolean find(Comparable item, Node node) {
        //Base case
        if(node == null){
            return false;
        }
        // if the node is the item we are looking for
        if (item == node.getData()){
            return true;
        }
        // if our item's value is less than the value of our node value
        if (item.compareTo(node.getData()) < 0){
            return find(item, node.left);
        } else {
            // if our items's value is greater than the value of our node value
            return find(item, node.right);
        }
    }

    public void insert(Comparable item){
        root = insert(item, root);
    }

    public Node insert(Comparable item, Node node){
        if (node == null){
            return new Node(item);
        }

        if (item == node.getData()){
            return node;
        }

        if(item.compareTo(node.data) < 0){
            node.left = insert(item, node.left);

        }else{
            node.right = insert(item, node.right);
        }
        return node;
    }

    public void delete(Comparable item) {
        root = delete(root, item);
    }

    public Node delete(Node node, Comparable item){

        if (node == null){
            return null;
        }

        if (node.data == item){
            if(node.left == null){
                return node.right;
            }

            if (node.right == null){
                return node.left;
            }

            if(node.right.left == null){
                node.data = node.right.data;
                node.right = node.right.right;
                return node;
            }

            else{
                node.data = removeSmallest(node.right);
                return node;
            }
        }

        if(item.compareTo(node.data) < 0){
            node.right = delete (node.right, item);
            return node;

        } else{
            node.left = delete(node.left, item);
            return node;
        }
    }

    public void print(){
        print(root);
    }

    public void print(Node node){
        if (node == null){
            return;
        }

        print(node.left);
        System.out.println(node.data);
        print(node.right);
    }

    public Comparable removeSmallest(Node node){
        if (node.left.left == null){
            Comparable smallest = node.left.data;
            node.left = node.left.right;
            return smallest;
        }
        else {
            return removeSmallest(node.left);
        }
    }
}

//add an instance counter to take care of duplicates
