import java.lang.StringBuilder;

class Kebab implements TextFormatter {
    private String string = "";

    public Kebab(){}
    
    private Kebab(String s) {
        this.string = s;
    }
    
    public TextFormatter clone(String s) {
        return new Kebab(s);
    }

    public String format() {
        return this.string + "-";
    }
}
