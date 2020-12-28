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
        //len表示当前要检查的字符串的长度
        for (int len = 0; len < n; len++) {
            //head表示当前字符串的起始位置
            for (int head = 0; head + len < n; head++) {
                //tail即为当前字符串的结束位置
                int tail = head + len;
                //len为0时，是单个字符，肯定是回文
                if (len == 0)
                    dp[head][tail] = true;
                //len为1时，是一个长度为2的字符串，需要判断前后两个字符是否相同
                else if (len == 1)
                    dp[head][tail] = s.charAt(head) == s.charAt(tail);
                //len大于1的情况，即字符串长度大于2，若有s[head]==s[tail] 且 s（head+1,tail-1）是回文字符串，则当前字符串是回文字符串
                //而s（head+1,tail-1）是否为回文字符串记录在dp[head + 1][tail - 1]中
                else
                    dp[head][tail] = (s.charAt(head) == s.charAt(tail)) && dp[head + 1][tail - 1];
                //如果当前字符串是回文字符串，且长度比已经记录的最长回文字符串还长，就更新数据
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
