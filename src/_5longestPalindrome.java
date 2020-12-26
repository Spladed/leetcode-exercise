public class _5longestPalindrome {

    /**
     * 思路：对于s=ababd,若s是回文字符串，则必有s[0]=s[4] && s（1,3）是回文字符
     * 若s（1,3）（即bab）是回文字符串，则必有s[1]=s[3] && s(2,2)是回文字符串
     *
     * @param s 字符串
     * @return 最长回文子串
     */
    public static String longestPalindrome(String s) {
        int n = s.length();
        String ans = "";
        //dp[i][j]表示字符串从i到j的部分是否为回文字符串
        boolean[][] dp = new boolean[n][n];
        for (int len = 0; len < n; len++) {
            for (int head = 0; head + len < n; head++) {
                int tail = head + len;
                if (len == 0)
                    dp[head][tail] = true;
                else if (len == 1)
                    dp[head][tail] = s.charAt(head) == s.charAt(tail);
                else
                    dp[head][tail] = (s.charAt(head) == s.charAt(tail)) && dp[head + 1][tail - 1];
                if (dp[head][tail] && len + 1 > ans.length())
                    ans = s.substring(head, tail + 1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "ababd";
        System.out.println(longestPalindrome(s));
    }

}
