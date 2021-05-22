package com.fh;

import java.util.Stack;

public class Bracket {

    boolean isValid(String s){
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i <s.length() ; i++) {
            char c = s.charAt(i);
            if(c == '(' || c == '[' || c == '{'){
                stack.push(c);
            }else{
                if(!stack.isEmpty() && leftOf(c) == stack.peek()){
                    stack.pop();
                }else {
                    return false;
                }
            }
        }
        return false;
    }

    private char leftOf(char c) {
        if(c == ')'){
            return '(';
        }
        if(c == ']'){
            return '[';
        }
        return '{';
    }


}
