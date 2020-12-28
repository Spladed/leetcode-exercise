import java.util.LinkedList;
import java.util.Queue;

public class _3lengthOfLongestSubstring {

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0 || s == null)
            return 0;
        int max = -1;
        Queue<Character> queue = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (!queue.contains(c)) {
                queue.offer(c);
                if (queue.size() > max)
                    max = queue.size();
            } else {
                while (!queue.peek().equals(c))
                    queue.poll();
                queue.poll();
                queue.offer(c);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }

}
