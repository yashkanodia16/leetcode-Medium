// Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

// A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.



 

// Example 1:

// Input: digits = "23"
// Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
// Example 2:

// Input: digits = ""
// Output: []
// Example 3:

// Input: digits = "2"
// Output: ["a","b","c"]
 

// Constraints:

// 0 <= digits.length <= 4
// digits[i] is a digit in the range ['2', '9'].

class Solution {
    public List<String> letterCombinations(String digits) {
        Map<Character, String> map = new HashMap<>(){{
           put('2', "abc"); put('3', "def"); put('4', "ghi"); put('5', "jkl");
           put('6', "mno"); put('7', "pqrs"); put('8', "tuv"); put('9', "wxyz");
        }};
        List<String> res = new ArrayList<>();
        if(digits.equals(""))
            return res;
        dfs(digits,0,"",map,res);
        return res;
    }
    public void dfs(String digits, int index, String path, Map<Character, String> map, List<String> res){
        if(digits.length() == path.length())
        {
            res.add(path);
            return;
        }
        for(int i=index;i<digits.length();i++){
            for(char c: map.get(digits.charAt(i)).toCharArray()){
                dfs(digits, i+1, path+c, map, res);
            }
        }
    }
}

