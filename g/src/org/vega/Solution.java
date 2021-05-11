package org.vega;

import java.io.*;

import static java.util.stream.Collectors.joining;


class Result {

    /*
     * Complete the 'breakPalindrome' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING palindromeStr as parameter.
     */

    public static String breakPalindrome(String palindromeStr) {
        // Write your code here

        int mid = palindromeStr.length() / 2;
        boolean found = false;
        char character = ' ';
        int i;
        for (i = mid - 1; i >= 0; i--) {
            character = palindromeStr.charAt(i);
            if (character!='a') {
                found = true;
                break;
            }
        }
        if (!found) {
            for (i = mid + 1; i < palindromeStr.length(); i++) {
                character = palindromeStr.charAt(i);
                if (character!='a') {
                    found = true;
                    break;
                }
            }
        }


        int init = (int) character;
        init -= 1;
        if (palindromeStr.length() >= 3) {
            palindromeStr = palindromeStr.substring(0, i) + (char) init + palindromeStr.substring(i + 1);
            return palindromeStr;
        }
        else{
            return "IMPOSSIBLE";
        }
    }
}


public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String palindromeStr = bufferedReader.readLine();

        String result = Result.breakPalindrome(palindromeStr);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
