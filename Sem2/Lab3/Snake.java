import java.lang.StringBuilder;

class Snake implements TextFormatter {
    private String string = "";

    public Snake(){}
    
    private Snake(String s) {
        this.string = s;
    }
    
    public TextFormatter clone(String s) {
        return new Snake(s);
    }

    public String format() {
        return this.string + "_";
    }
}
