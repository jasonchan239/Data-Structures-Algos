public class Key {
    
//    private String type;
    private String name;
    private String kind;
    public Key(String word, String type) {
        word = word.toLowerCase();
        this.name = word;
        this.kind = type;
    }
    public String getName() {
        return this.name;
    }
    public String getKind() {
        return this.kind;
    }
    public int compareTo(Key k) {
        if (name.compareTo(k.name) == 0 && kind == k.kind) 
            return 0;
        else if(name.compareTo(k.name) < 0 || (name.compareTo(k.name)==0 && kind.compareTo(k.kind)<0))
            return -1;
        else return 1;
    }
}
