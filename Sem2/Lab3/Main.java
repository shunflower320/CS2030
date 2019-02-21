import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

class Main {
    public static void main(String[] args) {
        List<TextFormatter> formatters = new ArrayList<>();
        formatters.add(new Snake());
        formatters.add(new Kebab());
        formatters.add(new Pascal());
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {

        TextEditor editor = new TextEditor(formatters);
            String[] line = sc.nextLine().split(" ");
            for (String s: line) {
                editor.addString(s);
            }
            editor.printAll();
        }
    }
}
