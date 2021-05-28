package lc;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @Author: 余新洁
 * @Date: 2021/5/28
 * @Description: 两数之和
 */
public class T1 {
    /**
     * go
     * 两层循环暴力破解
     *
     * think
     * 补数法：用一个hashmap来记录 <补数，所需补数的index>
     * 然后for循环遍历先去map中查看本数是否存在，不存咋就加入map，否则就输出
     *
     */
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        int len = nums.length;
        for (int i = 0; i <= len - 2; i ++){
            for (int j = i + 1; j <= len - 1; j ++){
                int leftNum = target - nums[i];
                if (nums[j] == leftNum){
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        T1 t1 = new T1();
        int[] nums = {2, 7, 11, 15};
        int[] result = t1.twoSum2(nums, 22);
        for (int item : result){
            System.out.println(item);
        }
    }

    public int[] twoSum2(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> needMap = new HashMap<>();
        for (int i = 0; i < nums.length; i ++){
            int value = nums[i];
            Integer start = needMap.get(value);
            if (start != null){
                result[0] = start;
                result[1] = i;
                break;
            }else {
                needMap.put(target - value, i);
            }
        }
        return result;
    }
}
