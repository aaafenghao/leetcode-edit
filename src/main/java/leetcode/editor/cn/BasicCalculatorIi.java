//实现一个基本的计算器来计算一个简单的字符串表达式的值。 
//
// 字符串表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格 。 整数除法仅保留整数部分。 
//
// 示例 1: 
//
// 输入: "3+2*2"
//输出: 7
// 
//
// 示例 2: 
//
// 输入: " 3/2 "
//输出: 1 
//
// 示例 3: 
//
// 输入: " 3+5 / 2 "
//输出: 5
// 
//
// 说明： 
//
// 
// 你可以假设所给定的表达式都是有效的。 
// 请不要使用内置的库函数 eval。 
// 
// Related Topics 字符串

package leetcode.editor.cn;

import java.util.Stack;

public class BasicCalculatorIi {
    public static void main(String[] args) {
        Solution solution = new BasicCalculatorIi().new Solution();
        System.out.println(solution.calculate1("3+5 / 2"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int calculate1(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = s.length() - 1; i >= 0; i--) {
            stack.push(s.charAt(i));
        }
        return calcu(stack);
    }
    public int calculate(String s) {
        //String类型的正整形转换成int
//        int n = 0;
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//            n = 10 * n + (c - '0');
//        }

        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char sign = '+';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(isDigit(c)){
                num = num * 10 + (c - '0');
            }

            if(c == '('){
               num =  calculate(s.substring(i+1));
            }

            if(!isDigit(c) || i == s.length() - 1){
                int pre = 0;
                switch (sign){
                    case '+':
                        stack.push(num) ; break;
                    case '-':
                        stack.push(-num); break;
                    case '*':
                        pre = stack.pop();
                        stack.push(pre * num);
                        break;
                    case '/':
                        pre = stack.pop();
                        stack.push(pre/num);
                        break;
                }
                num = 0;
                sign = c;
            }
            if(c == ')'){
                break;
            }
        }
        int res = 0;
        while (!stack.isEmpty()){
            res += stack.pop();
        }
        return res;
    }

    private boolean isDigit(char c){
        if(c < '0' || c > '9'){
            return false;
        }
        return true;
    }

    public int calcu(Stack<Character> s){
        Stack<Integer>  stack = new Stack<>();
        int num = 0;
        char sign = '+';
        while (!s.isEmpty()){
            Character pop = s.pop();
            if(isDigit(pop)){
                num = num * 10 + (pop - '0');
            }
            if(pop == '('){
                num = calcu(s);
            }
            if((!isDigit(pop) && pop != ' ') || s.size() == 0 ){
                int pre = 0;
                switch (sign){
                    case '+':
                        stack.push(num);break;
                    case '-':
                        stack.push(-num);break;
                    case '*':
                         pre = stack.pop();
                        stack.push(pre * num);
                        break;
                    case '/':
                        pre = stack.pop();
                        stack.push(pre / num);
                        break;

                }
                num = 0;
                sign = pop;
            }
            if(pop == ')'){
                break;
            }
        }
        int res = 0;
        while (!stack.isEmpty()){
            res += stack.pop();
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}