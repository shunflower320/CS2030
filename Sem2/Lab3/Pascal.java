import java.lang.StringBuilder;

class Pascal implements TextFormatter {
    private String string = "";
    private String result = "";

    public Pascal(){}
    
    private Pascal(String s, String result) {
        this.string = s;
        this.result = result;
    }
    
    public TextFormatter clone(String s) {
        return new Pascal(s, this.result);
    }

    public String format() {
        char letter = this.string.charAt(0);
        StringBuilder sb = new StringBuilder(this.string);
        this.result += sb.deleteCharAt(0).insert(0, Character.toUpperCase(letter)).toString();
        return this.result;
    }

    public String formatLast() {
        return format();
    }

    public String toString() {
        return this.result;
    }

    public int compareTo(TextFormatter t2) {
        return toAscii().compareTo(t2.toAscii());
    }

    public Integer toAscii() {
        int total = 0;
        char[] letters = this.result.toCharArray();
        for (char ch: letters) {
            total += Character.hashCode(ch);
        }
        return total;
    }
}
