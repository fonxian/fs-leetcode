package com.fonxian.acmbook1.slidingwindow;

/**
 * @author Michael Fang
 * @since 2019-08-25
 */
public class SlidingWindow {

    public static int maxnum(int[] array,int k){
        if(array.length<k){//如果k比数组长度还大，返回-1
            return -1;
        }
        int left=0;
        int sum=0;
        for(int i=0;i<k;i++){
            sum+=array[i];
        }
        int tempsum=sum;//tempsum记录每个窗口的总和
        while (left+k<array.length){
            tempsum=tempsum-array[left]+array[left+k];
            left++;
            sum=Math.max(sum,tempsum);//sum取原sum和tempsum的较大值
        }
        return sum;
    }
    public static void main(String[] args) {
        int[] arr={1, 4, 2, 10, 2, 3, 1, 0, 20};
        int k=3;
        System.out.println(maxnum(arr,k));
    }

}
