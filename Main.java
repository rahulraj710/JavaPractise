import java.util.List;
import java.util.Arrays;
public class Main
{
    public static void main(String[] args) {
      List<Integer> myList = Arrays.asList(2,6,2,1,9,9,8);
      // Sum of unique elements
      System.out.println(myList.stream().distinct().mapToInt(Integer::intValue).sum());

      // the first non-repeated character in a string
      String string = "aacddbee";
      char firstNonRepeatedChar = string.chars()                     
            .mapToObj(c -> (char) c)                                 
            .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting())) 
            .entrySet()                                                  
            .stream()                                                  
            .filter(entry -> entry.getValue() == 1)                    
            .map(Map.Entry::getKey)                                    
            .findFirst()                                               
            .orElse('\0');     
        System.out.println(firstNonRepeatedChar);
      
      // top k frequency words
      List<String> words = Arrays.asList("apple", "banana", "apple", "apple", "orange", "banana", "grape", "banana", "grape", "apple");
      int k = 2;
      words.stream()
           .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
           .entrySet().stream()
           .sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()))
           .limit(k)
           .map(Map.Entry::getKey)
           .forEach(System.out::println);
    }
    }
}
