package lcof;

/**
 * <p>
 * Description：剑指 Offer II 001. 整数除法
 * 给定两个整数 a 和 b ，求它们的除法的商 a/b ，要求不得使用乘号 '*'、除号 '/' 以及求余符号 '%' 。
 * <p>
 *
 * @author 余新洁
 * @since 2021/6/2
 */
public class Offer001 {
    /**
     * 简单来说分两步：
     * （1）处理边界值，也需要将两个数转为负数计算
     * （2）记录结果符号位，然后用减法代替除法
     */
    public int divide(int a, int b){
        if (a == 0){
            return 0;
        }
        // max = 2^32-1,   min = -2^32
        if (a == Integer.MIN_VALUE && b == -1){
            return Integer.MAX_VALUE;
        }

        // 记录正负号
        boolean flag = (a > 0 && b > 0 ) || (a < 0 && b < 0);

        // 转为负数计算，否则Math.abs（a）可能无法转（当a为最大值）
        if (a > 0){
            a = -a;
        }
        if (b > 0){
            b = -b;
        }

        int c = 0;
        while (a <= b){
            a = a - b;
            c ++;
        }

        return flag ? c : -c;
    }

    public static void main(String[] args) {
        System.out.println(new Offer001().divide(16, 4));
    }

}
