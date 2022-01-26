package numberrangesummarizer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public class NumberRangeSummarizerImpl implements NumberRangeSummarizer {

    @Override
    public Collection<Integer> collect(String input) {
        if (input.equals("")){
            throw new IllegalArgumentException("Input Empty.");
        }
        Collection<Integer> inputCollection= new ArrayList<Integer>();
        String[] strInputArray = input.split(",");
            //Remove duplicates
            for (String str : strInputArray) {
                if (!inputCollection.contains(Integer.parseInt(str))) {
                    inputCollection.add(Integer.parseInt(str));
                }
            }
        //returns a sorted collection
        return inputCollection.stream().sorted().collect(Collectors.toList());
    }

    @Override
    public String summarizeCollection(Collection<Integer> input) {
        if (input.size()==0){
            return "";
        }
        if (input.size()==1){
            return Integer.toString((Integer) input.toArray()[0]);
        }

        StringBuilder results = new StringBuilder();
        Object[] inputArray = input.toArray();
        int current,next, start = 0, end=0;
        boolean seq =false;
        int secondLast = (int)inputArray[inputArray.length-2];

        for (int i=0; i < inputArray.length-1;i++){
            current = (int) inputArray[i];
            next = (int) inputArray[i+1];
            if (next == current+1){
                if (!seq){
                    start = current;
                }
                end = next;
                seq = true;
            }
            else
            if (seq){
                results.append(Integer.toString(start)+"-"+Integer.toString(end)+", ");
                seq =false;;
            }
            else {
                results.append(Integer.toString(current)+", ");
            }

        }
        //checks for the last element
        if (secondLast+1 == (int)inputArray[inputArray.length-1]){
            end = (int)inputArray[inputArray.length-1];
            results.append(Integer.toString(start) + "-" + Integer.toString(end));
        }
        else{
            results.append(Integer.toString((int)inputArray[inputArray.length-1]));
        }

        return results.toString();
    }
}