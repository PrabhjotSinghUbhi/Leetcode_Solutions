class Solution {
public:
    int minInsertions(string s) {
        int open = 0, insertion = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s[i] == '(') {
                open++;
            }

            else {

                if(open <= 0) {
                    open++;
                    insertion++;
                    i--;
                }

                else if (i + 1 < s.length() && s[i + 1] == ')') {
                    open--;
                    i = i + 1;
                } else {
                    insertion++;
                    open--;
                }

            }
        }

        return open * 2 + insertion;
    }
};