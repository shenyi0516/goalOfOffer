package code;

/**
 * @author Shen Yi
 * @version 1.0
 * @date 2020/4/8 0:54
 */

/**
 * 假设把某股票的价格按照时间先后顺序存储在数组中，
 * 请问买卖该股票一次可能获得的最大利润是多少？
 * 解题思路：
 * 遍历数组的时候保存当前最小价格和最大利润。
 */
public class Q63 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length<2)
            return 0;
        int min = prices[0];
        int max = 0;
        for (int price:prices){
            min = Math.min(min,price);
            max = Math.max(price-min,max);
        }
        return max;
    }
}
