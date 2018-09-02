/*
请实现一个算法，在不使用额外数据结构和储存空间的情况下，翻转一个给定的字符串(可以使用单个过程变量)。

给定一个string iniString，请返回一个string，为翻转后的字符串。保证字符串的长度小于等于5000。
 */
package CrackingTheInterview;

public class ReverseString {

    public String reverseString(String iniString) {
        StringBuffer sb = new StringBuffer(iniString);
        return sb.reverse().toString();
    }


}
