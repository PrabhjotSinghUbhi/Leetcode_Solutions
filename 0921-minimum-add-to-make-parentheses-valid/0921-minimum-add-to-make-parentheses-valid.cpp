class Solution {
public:
    int minAddToMakeValid(string s) {
        int balance = 0;
        int added = 0;

        for (auto& ch : s) {

            if (ch == '(') {
                balance++;
            }

            else {
                balance--;
            }

            if(balance == -1) {
                added++;
                balance = 0;
            }

        }

        if(balance != 0) {
            added = added + balance;
        }
        
        return added;
    }
};