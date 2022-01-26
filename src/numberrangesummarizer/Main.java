package numberrangesummarizer;

public class Main {
    public static void main(String[] args) {
        // write your code here
        String input = "";
        NumberRangeSummarizerImpl obj = new NumberRangeSummarizerImpl();
        System.out.println(obj.summarizeCollection(obj.collect(input)));
    }
}
