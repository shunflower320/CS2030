import java.lang.StringBuilder;

class Snake implements TextFormatter {
    private String string = "";
    private String result = "";

    public Snake(){}
    
    private Snake(String s, String result) {
        this.string = s;
        this.result = result;
    }
    
    public TextFormatter clone(String s) {
        return new Snake(s, this.result);
    }

    public String format() {
        this.result += this.string + "_";
        return this.result;
    }
    
    public String formatLast() {
        this.result += this.string;
        return this.result;
    }
}
