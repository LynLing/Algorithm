/*
给出字母列表{A, B, C}求出其所有的排列组合
{A,B,C,AB,AC,BC,ABC}
 */

package unsolvedProblemsDuringInterview;

import java.util.ArrayList;
import java.util.List;

public class Permutation {

    public List<String> helper(char[] array){
        List<String> str = new ArrayList<>();
        permutation(array, 0, str);

        return str;

    }
    public void permutation(char[] array, int start, List<String> res){

        if(start >= array.length){
            return;
        }

        List<String> str = new ArrayList<>();

        if(res.size() != 0){
            for(String c : res){
                String newString = c + array[start];
                str.add(newString);
            }
        }
        for(String c:str){
            res.add(c);
        }

        res.add("" + array[start]);
        start = start + 1;

        permutation(array, start, res);

    }

    public static void main(String[] args){
        char[] array = {'A', 'B', 'C', 'D', 'E'};
        Permutation permutation = new Permutation();
        List<String> res = permutation.helper(array);
        for(String c : res){
            System.out.println(c);
        }
    }
}
