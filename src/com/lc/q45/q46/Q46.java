package com.lc.q45.q46;

import java.util.*;

public class Q46 {
}
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hashMap = new HashMap();
        for(int i = 0; i < strs.length; i++){
            char[] tmp = strs[i].toCharArray();
            int[] mark = new int[26];
            for(int j = 0; j < tmp.length; j++){
                mark[tmp[j] - 'a']++;
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (int m: mark
                 ) {
                stringBuilder.append((char) ('a' + m));
            }
            String s = stringBuilder.toString();
            if(hashMap.containsKey(s)){
                List<String> strings = hashMap.get(s);
                strings.add(strs[i]);
            }else{
                ArrayList<String> value = new ArrayList<>();
                value.add(strs[i]);
                hashMap.put(s, value);
            }
        }
        List<List<String>> res = new ArrayList();
        Set<Map.Entry<String, List<String>>> entries = hashMap.entrySet();
        Iterator<Map.Entry<String, List<String>>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, List<String>> next = iterator.next();
            res.add(next.getValue());
        }

        return res;
    }
}