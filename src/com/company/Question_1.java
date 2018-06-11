package com.company;


public class Question_1 {

    /**
     *  sortByStrings(s,t): Sort the letters in the string s by the order they occur in the string t.
     *  You can assume t will not have repetitive characters.
     *  For s = "weather" and t = "therapyw", the output should be sortByString(s, t) = "theeraw".
     *  For s = "good" and t = "odg", the output should be sortByString(s, t) = "oodg".
     */

    public static void main(String[] args){
        System.out.println(sortByStrings("good", "odg"));
    }

    public static String sortByStrings(String s, String t){
        char [] sortedCharArray = new char[s.length()];
        int indexCounter = 0;
        StringBuilder builder = new StringBuilder();

        for(int i = 0; i < t.length(); i++){
            for (int j = 0; j < s.length(); j++){
                if(t.charAt(i) == s.charAt(j)){
                    if(sortedCharArray[indexCounter] == t.charAt(i) || !(sortedCharArray[indexCounter] == 0)){
                        sortedCharArray[indexCounter + 1] = t.charAt(i);
                        indexCounter++;
                    } else {
                        sortedCharArray[indexCounter] = t.charAt(i);
                        indexCounter++;
                    }
                }
            }
        }
            for(int k = 0; k < sortedCharArray.length; k++){
                    builder.append(sortedCharArray[k]);
            }
            return builder.toString();
    }

}
