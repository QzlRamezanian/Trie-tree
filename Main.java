public class Main {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("car");
        trie.insert("care");
        //System.out.println(trie.search("catop")); //TRUE
        //trie.preorder();
        //trie.postorder();
        trie.remove("care");
    }

}

