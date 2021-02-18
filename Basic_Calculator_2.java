// Given a string s which represents an expression, evaluate this expression and return its value. 

// The integer division should truncate toward zero.

 

// Example 1:

// Input: s = "3+2*2"
// Output: 7
// Example 2:

// Input: s = " 3/2 "
// Output: 1
// Example 3:

// Input: s = " 3+5 / 2 "
// Output: 5

class Solution {
    public int calculate(String s) {
        if(s == null)
            return 0;
        int len = s.length();
        Stack<Integer> stack = new Stack<>();
        int currNumber = 0;
        char operation = '+';
        for(int i=0;i<s.length();i++){
            char currChar = s.charAt(i);
            if(Character.isDigit(currChar))
                currNumber = (currNumber * 10) + (currChar - '0');
            if(!Character.isDigit(currChar) && !Character.isWhitespace(currChar) || i==len-1){
                if(operation == '-')
                    stack.push(-currNumber);
                else if(operation == '+')
                    stack.push(currNumber);
                else if(operation == '*')
                    stack.push(currNumber * stack.pop());
                else if(operation == '/')
                    stack.push(stack.pop() / currNumber);
                operation = currChar;
                currNumber = 0;
            }
        }
        int result = 0;
        while(!stack.isEmpty()){
            result += stack.pop();
        }
        return result;
    }
}
