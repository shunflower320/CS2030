import java.util.ArrayList;
import java.lang.StringBuilder;
import java.util.List;
import java.util.Comparator;
import java.util.PriorityQueue;

class TextEditor {
    private List<TextFormatter> formatters;
    private List<String> strings = new ArrayList<>();
    private static PriorityQueue<TextFormatter> queue = new PriorityQueue<>();

    public TextEditor(List<TextFormatter> formatter) {
        this.formatters = formatter;
    }

    public void addString(String s) {
        this.strings.add(s);
    }

    public TextFormatter format(List<String> str, TextFormatter formatter) {
        for (String s: str) {
            if (s == str.get(str.size() - 1)) {
                s = s.toLowerCase();
                formatter = formatter.clone(s);
                formatter.formatLast();
            } else {
                s = s.toLowerCase();
                formatter = formatter.clone(s);
                formatter.format();
            }
        }
        return formatter;
    }


    public TextFormatter mixed(TextFormatter s) {
        List<String> lst = new ArrayList<>();
        lst.add("I");
        lst.add("Love");
        lst.add("CS2030");
        TextFormatter t = format(lst, new Snake());
        if (s.compareTo(t) == 1) {
            return s;
        } else {
            return t;
        }
    }

    public void addAll() {
        for (int i = 0; i < formatters.size(); i++) {
            TextFormatter formatter = this.formatters.get(i);
            formatter = format(this.strings, formatter);
            queue.add(formatter);
        }
        int r = strings.get(0).charAt(0) % 3;
        queue.add(mixed(format(this.strings, this.formatters.get(r))));
    }

    public static void printAll() {
        int size = queue.size();

        for (int j = 0; j < size; j++) {
            System.out.println(queue.poll().toString());
        }
    }

}

