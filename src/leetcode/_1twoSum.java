import java.util.HashMap;
import java.util.Map;

/**
 * 将值存在哈希表中，有匹配的直接返回结果，没有的就添加进哈希表中
 */
public class _1twoSum {

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int left = target - nums[i];
            if (map.containsKey(left))
                return new int[]{i, map.get(left)};
            else
                map.put(nums[i], i);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] arr=new int[]{2,7,11,15};
        int target=9;
        int[] result=twoSum(arr,target);
        for(int i:result)
            System.out.print(i+" ");
    }

}
