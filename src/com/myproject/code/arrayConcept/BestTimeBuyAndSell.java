package com.myproject.code.arrayConcept;

public class BestTimeBuyAndSell {

    public static void main(String[] args) {
        int[] prices =new int[]{7,1,5,3,6,4};
        int maxProfit=0;
        int left=0;
        int right=1;
        while(right<prices.length){
            if(prices[left]<prices[right]) {
                maxProfit = Math.max(maxProfit, prices[right] - prices[left]);
            }else{
                left=right;
            }
          right++;
        }
        System.out.println("MaxProfit "+maxProfit);
    }
}
