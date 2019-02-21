interface TextFormatter extends Comparable<TextFormatter> {

    TextFormatter clone(String s);

    String format();

    String formatLast();
    
    String toString();

    Integer toAscii();    
}
