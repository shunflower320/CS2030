import java.lang.StringBuilder;

class Pascal implements TextFormatter {
    private String string = "";

    public Pascal(){}
    
    private Pascal(String s) {
        this.string = s;
    }
    
    public TextFormatter clone(String s) {
        return new Pascal(s);
    }

    public String format() {
        char letter = this.string.charAt(0);
        StringBuilder sb = new StringBuilder(this.string);
        this.string = sb.deleteCharAt(0).insert(0, Character.toUpperCase(letter)).toString();
        return this.string;
    }
}
