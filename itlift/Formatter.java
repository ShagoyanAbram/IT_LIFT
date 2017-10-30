package com.company.itlift;

public class Formatter {
    public static String[] splitStr (String splitString, int stringIndex) {
        char[] firstStr = new char[stringIndex];
        char[] secondStr = new char[splitString.length() - stringIndex];
        String[] result = new String[2];

        char[] charArr = splitString.toCharArray();

        for( int i = 0; i < stringIndex ; i++){
            firstStr[i] = charArr[i];
        }
        int k = 0;
        for( int i = stringIndex; i<splitString.length (); i++){
            secondStr[k] = charArr[i];
            k++;
        }
        result[0] = new String(firstStr);
        result[1] = new String(secondStr);
        return result;

    }

    public static void main(String[] args) {
        String inputString = " for (int i = 0: i < inputChertString.length(): i++){" +
                "index++;if (inputChertString.charAt(i) == '['){" +
                "countOpen++;for (int k = 0: k < countOpen: k++){space = space + ; }";
        int countOpen = 0;
        int index = 0;
        String space = "";
        String enter = "\n";
        for (int i = 0; i < inputString.length(); i++) {
            index++;
            if (inputString.charAt(i) == '{') {
                countOpen++;
                for (int k = 0; k < countOpen; k++) {
                    space = space + "    ";
                }
                String[] strings = splitStr(inputString, index);
                inputString = strings[0] + enter + space + strings[1];
            }
            if (inputString.charAt(i) == ';') {
                String[] strings = splitStr(inputString, index);
                inputString = strings[0] + enter + space + strings[1];
            }
            if (inputString.charAt(i) == '}') {
                String[] spaces = splitStr(space, countOpen * 4);
                space = spaces[0];
                countOpen--;
            }
        }
        System.out.println(inputString);
    }
}


