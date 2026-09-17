class Solution {
    public boolean isPalindrome(String s) {
        //make stringbuider
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            char cc = Character.toLowerCase(s.charAt(i));
            if((cc >= 'a' && cc <= 'z')){
                sb.append(cc);
            } else if((cc >= '0' && cc <= '9')){
                sb.append(cc);
            }
        }

        int j = sb.length() - 1;
        int i = 0;
        while(i < j){
            if(sb.charAt(i++) != sb.charAt(j--)){
                return false;
            }
        }
        return true;
    }
}