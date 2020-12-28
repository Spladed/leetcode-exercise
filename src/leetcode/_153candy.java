/**
 * 从左向右遍历一遍，如果有右边的比左边的大，则在左边的基础上加一，否则置为1
 * 再从右向左遍历一遍，如果有左边的比右边的大，则在右边的基础上加一，否则置为1
 * 取两次结果的最大值，累加
 */
public class _153candy {

    public static int candy(int[] ratings) {
        int n = ratings.length;
        int[] left = new int[n];
        for (int i = 0; i < n; i++) {
            if (i > 0 && ratings[i] > ratings[i - 1])
                left[i] = left[i - 1] + 1;
            else
                left[i] = 1;
        }

        int[] right = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            if (i < n - 1 && ratings[i] > ratings[i + 1])
                right[i] = right[i + 1] + 1;
            else
                right[i] = 1;
        }

        int result = 0;
        for (int i = 0; i < n; i++)
            result += Math.max(left[i], right[i]);
        return result;
    }

    public static void main(String[] args) {
        int[] ratings = {1, 0, 2};
        System.out.println(candy(ratings));
    }

}
