package learning.algorithms;

import java.util.HashMap;
import java.util.Map;

public class FlattenMap {

    static HashMap<String, String> flattenDictionary(HashMap<String, Object> dict) {
        HashMap<String, String> resultMap = new HashMap<>();
        //checkAndFlatten(null, resultMap, dict);
        return resultMap;
      }

        static void checkAndFlatten(String parentKey, Map<String, String> resultMap, Map<String, Object> dict) {
    dict.entrySet().forEach(di -> {
        if (Map.class.isInstance(di.getValue())) {
          if (parentKey == null) {
            checkAndFlatten(di.getKey(), resultMap, (Map<String,Object>) di.getValue());
          } else {
            checkAndFlatten(parentKey + "." + di.getKey(), resultMap, (Map<String,Object>) di.getValue());            
          }
        } else if (String.class.isInstance(di.getValue())) {
          if (parentKey == null) {
            resultMap.put(di.getKey(), (String) di.getValue());  
          } else {
            resultMap.put(parentKey + "." + di.getKey(), (String) di.getValue()); 
          }
        }
    });        
  }

    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> map1 = new HashMap<>();
        Map<String, String> result = new HashMap<>();
        map1.put("key2", "Hello");
        map1.put("key3", new HashMap<>());
        map.put("key1", map1); 
        map.put("key4", "value");
        map.entrySet().forEach(i -> {
            if (Map.class.isInstance(i.getValue())) {
                System.out.println("Map found");
            } else if (String.class.isInstance(i.getValue())) {
                System.out.println("String found");
            }
            result.put(i.getKey(), i.getValue().toString());
        });       
        map.entrySet().stream().forEach(i -> {
            System.out.println(i.getKey());
        });
    }
}
