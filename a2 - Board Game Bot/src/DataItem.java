public class DataItem {

    private Key theKey;
    private String content;
    
    public DataItem(Key k, String data) {
        this.theKey = k;
        this.content = data;
    }
    public Key getKey() {
        return theKey;
    }
    public String getContent(){
        return content;
    }
    

}