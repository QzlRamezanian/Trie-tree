public class Trie{
    public static int AlphabetSize = 26;

    private class Node{
        private char value;
        private Node[] children = new Node[AlphabetSize];
        private boolean isEndOfWord;
        private int childCount;

        //constructor
        public Node(char value){
            this.value = value;
            this.childCount = 0;

        }

        //hasChild methode
        public boolean hasChild(char ch){
            for(int i = 0; i < childCount; i++){
                if (children[i].value == ch) {
                    return true;
                }
            }
            return false;
        }

        //addChild methode
        public void addChild(char ch){
            if(!hasChild(ch)){
                if(childCount < children.length){
                    children[childCount++] = new Node(ch);
                }else{
                    System.out.println("can't add more children. Array is full");
                }
            }
        }

        //getChild methode
        public Node getChild(char ch){
            for(int i = 0 ; i < childCount; i++){
                if(children[i].value == ch){
                    return children[i];
                }
            }
            return null;
        }

        public Node[] getChildren(){
            Node[] validchildren = new Node[childCount];
            int index = 0;
            for(Node child : children){
                if(child != null){
                    validchildren[index++] = child;
                }
            }
            return validchildren;
        }
        public boolean hasChildren(){
            return !children.isEmpty();
        }
        @Override
        public String toString(){
            return "value" + value;
        }

    }

    private Node root = new Node(' ');
    public void insert(String word){
        Node current = root;
        for(char ch : word.toCharArray()){
           if(!current.hasChild(ch)){
            current.addChild(ch);
           }
           current = current.getChild(ch);
        }
        current.isEndOfWord = true;
    }

    public boolean search(String word){
        if(word == null){
            return false;
        }
        Node current = root ;
        for(char ch :word.toCharArray()){
            if(!current.hasChild(ch)){
                return false;
            }
            current = current.getChild(ch);
        }
        return current.isEndOfWord;
    }

    //preorder
    public void preorder(){
        preorder(root);
    }
    private void preorder(Node node){
        System.out.println(node.value);

        for(Node child : node.getChildren()){
            preorder(child);
        }

    }

    public void postorder(){
        postorder(root);
    }
    private void postorder(Node node){

        for(Node child : node.getChildren()){
            postorder(child);
        }
        System.out.println(node.value);
    }

    //remove
    public void remove(String word){
        remove(root, word, 0);
    }
    private void remove(Node node, String word,int index){
        if(index == word.length()){
            node.isEndOfWord = false;
            return;
        }
        char ch = word.charAt(index); 
        Node child = node.getChild(ch);
        if(child == null){
            return;
        }
        remove(child,word, index+1);
        if(child)

    }
}