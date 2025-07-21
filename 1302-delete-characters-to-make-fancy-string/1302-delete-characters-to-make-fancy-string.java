// class Solution {
//     public String makeFancyString(String s) {
//         StringBuilder answer = new StringBuilder();
//         for(int i=0; i<s.length(); i++){
//             char currChar = s.charAt(i);
//             int len = answer.length();

//             if(len>=2&&s.charAt(i-1)==currChar&&s.charAt(i-2)==currChar){
//                 continue;
//             }
//             answer.append(currChar);
//         }

//         return answer.toString();
//     }
// }

class Solution {
  public String makeFancyString(String s) {
    StringBuilder sb = new StringBuilder();
    for (char c : s.toCharArray())
      if (sb.length() < 2 || //
          sb.charAt(sb.length() - 1) != c || sb.charAt(sb.length() - 2) != c)
        sb.append(c);
    return sb.toString();
  }
}