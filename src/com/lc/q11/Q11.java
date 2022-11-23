package com.lc.q11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q11 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.letterCombinations("23"));
    }
}

class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return null;
        if (digits.length() != 1) {
            String tmp = digits.substring(0, 1);
            if (tmp.equals("2")) {
                String work = null;
                List preResult =
                        letterCombinations(digits.substring(1, digits.length()));
                int num = preResult.size();
                for (int i = 0; i < num; i++) {
                    work = (String) preResult.get(0);
                    preResult.remove(0);
                    preResult.add("a" + work);
                    preResult.add("b" + work);
                    preResult.add("c" + work);
                }
                return preResult;
            }
            if (tmp.equals("3")) {
                String work = null;
                List preResult =
                        letterCombinations(digits.substring(1, digits.length()));
                int num = preResult.size();
                for (int i = 0; i < num; i++) {
                    work = (String) preResult.get(0);
                    preResult.remove(0);
                    preResult.add("d" + work);
                    preResult.add("e" + work);
                    preResult.add("f" + work);
                }
                return preResult;
            }
            if (tmp.equals("4")) {
                String work = null;
                List preResult =
                        letterCombinations(digits.substring(1, digits.length()));
                int num = preResult.size();
                for (int i = 0; i < num; i++) {
                    work = (String) preResult.get(0);
                    preResult.remove(0);
                    preResult.add("g" + work);
                    preResult.add("h" + work);
                    preResult.add("i" + work);
                }
                return preResult;
            }
            if (tmp.equals("5")) {
                String work = null;
                List preResult =
                        letterCombinations(digits.substring(1, digits.length()));
                int num = preResult.size();
                for (int i = 0; i < num; i++) {
                    work = (String) preResult.get(0);
                    preResult.remove(0);
                    preResult.add("j" + work);
                    preResult.add("k" + work);
                    preResult.add("l" + work);
                }
                return preResult;
            }
            if (tmp.equals("6")) {
                String work = null;
                List preResult =
                        letterCombinations(digits.substring(1, digits.length()));
                int num = preResult.size();
                for (int i = 0; i < num; i++) {
                    work = (String) preResult.get(0);
                    preResult.remove(0);
                    preResult.add("m" + work);
                    preResult.add("n" + work);
                    preResult.add("o" + work);
                }
                return preResult;
            }
            if (tmp.equals("7")) {
                String work = null;
                List preResult =
                        letterCombinations(digits.substring(1, digits.length()));
                int num = preResult.size();
                for (int i = 0; i < num; i++) {
                    work = (String) preResult.get(0);
                    preResult.remove(0);
                    preResult.add("p" + work);
                    preResult.add("q" + work);
                    preResult.add("r" + work);
                    preResult.add("s" + work);
                }
                return preResult;
            }
            if (tmp.equals("8")) {
                String work = null;
                List preResult =
                        letterCombinations(digits.substring(1, digits.length()));
                int num = preResult.size();
                for (int i = 0; i < num; i++) {
                    work = (String) preResult.get(0);
                    preResult.remove(0);
                    preResult.add("t" + work);
                    preResult.add("u" + work);
                    preResult.add("v" + work);
                }
                return preResult;
            }
            if (tmp.equals("9")) {
                String work = null;
                List preResult =
                        letterCombinations(digits.substring(1, digits.length()));
                int num = preResult.size();
                for (int i = 0; i < num; i++) {
                    work = (String) preResult.get(0);
                    preResult.remove(0);
                    preResult.add("w" + work);
                    preResult.add("x" + work);
                    preResult.add("y" + work);
                    preResult.add("z" + work);
                }
                return preResult;
            }
        } else {
            ArrayList<String> preResult = new ArrayList<String>();
            if (digits.equals("2")) {
                preResult.add("a");
                preResult.add("b");
                preResult.add("c");
            }
            if (digits.equals("3")) {
                preResult.add("d");
                preResult.add("e");
                preResult.add("f");
            }
            if (digits.equals("4")) {
                preResult.add("g");
                preResult.add("h");
                preResult.add("i");
            }
            if (digits.equals("5")) {
                preResult.add("j");
                preResult.add("k");
                preResult.add("l");
            }
            if (digits.equals("6")) {
                preResult.add("m");
                preResult.add("n");
                preResult.add("o");
            }
            if (digits.equals("7")) {
                preResult.add("p");
                preResult.add("q");
                preResult.add("r");
                preResult.add("s");
            }
            if (digits.equals("8")) {
                preResult.add("t");
                preResult.add("u");
                preResult.add("v");
            }
            if (digits.equals("9")) {
                preResult.add("w");
                preResult.add("x");
                preResult.add("y");
                preResult.add("z");
            }
            return preResult;
        }
        return null;
    }
}
