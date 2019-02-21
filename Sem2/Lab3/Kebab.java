import java.lang.StringBuilder;

class Kebab implements TextFormatter {
    private String string = "";
    private String result = "";

    public Kebab(){}
    
    private Kebab(String s, String result) {
        this.string = s;
        this.result = result;
    }
    
    public TextFormatter clone(String s) {
        return new Kebab(s, this.result);
    }

    public String format() {
        this. result += this.string + "-";
        return this.result;
    }

    public String formatLast() {
        this.result += this.string;
        return this.result;
    }
}
