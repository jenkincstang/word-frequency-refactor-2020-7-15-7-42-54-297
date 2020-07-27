import java.util.*;
import java.io.CharArrayWriter;

import java.time.LocalDateTime;

public class WordFrequencyGame {
    public String getResult(String inputStr) {
        {

            try {

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
}
