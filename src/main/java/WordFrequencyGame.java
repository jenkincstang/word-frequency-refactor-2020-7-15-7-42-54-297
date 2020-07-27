import java.util.*;
import java.io.CharArrayWriter;

import java.time.LocalDateTime;

public class WordFrequencyGame {
    public String getResult(String inputStr) {


        {

            try {

                //split the input string with 1 to n pieces of spaces
                String[] words = inputStr.split("\\s+");

                Map<String,Integer> wordMap = new HashMap<>();
                for(String word:words){
                    if(wordMap.containsKey(word)){
                        wordMap.put(word,wordMap.get(word)+1);
                    }else {
                        wordMap.put(word,1);
                    }
                }

                List<Map.Entry<String, Integer>> wordList = new ArrayList<Map.Entry<String, Integer>>(wordMap.entrySet());
                wordList.sort(new Comparator<Map.Entry<String, Integer>>() {
                    @Override
                    public int compare(Map.Entry<String, Integer> preEntry, Map.Entry<String, Integer> laterEntry) {
                        return laterEntry.getValue().compareTo(preEntry.getValue());
                    }
                });



                StringJoiner joiner = new StringJoiner("\n");
                for (Map.Entry<String, Integer> entry : wordList) {
                    String s = entry.getKey() + " " +entry.getValue();
                    joiner.add(s);
                }
                return joiner.toString();
            } catch (Exception e) {
                return "Calculate Error";
            }
        }
    }

    private Map<String, List<Input>> getListMap(List<Input> inputList) {
        Map<String, List<Input>> map = new HashMap<>();
        for (Input input : inputList){
//       map.computeIfAbsent(input.getValue(), k -> new ArrayList<>()).add(input);
            if (!map.containsKey(input.getValue())) {
                ArrayList arr = new ArrayList<>();
                arr.add(input);
                map.put(input.getValue(), arr);
            }
            else {
                map.get(input.getValue()).add(input);
            }
        }
        return map;
    }
}
