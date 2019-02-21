import java.util.ArrayList;
import java.lang.StringBuilder;
import java.util.List;

class TextEditor {
    private StringBuilder newString = new StringBuilder();
    private List<TextFormatter> formatters;
    private List<String> strings = new ArrayList<>();

    public TextEditor(List<TextFormatter> formatter) {
        this.formatters = formatter;
    }

    public void addString(String s) {
        this.strings.add(s);
    }

    public void printAll() {
        for (int i = 0; i < formatters.size(); i++) {
            TextFormatter formatter = formatters.get(i);
            for (String s: strings) {
                if (s == strings.get(strings.size() - 1)) {
                    s = s.toLowerCase();
                    System.out.println(s);
                } else {
                    s = s.toLowerCase();
                    formatter = formatter.clone(s);
                    System.out.print(formatter.format());
                }
            }
        }
    }
}

