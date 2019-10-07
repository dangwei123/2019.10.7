1.假设你有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花卉不能种植在相邻的地块上，它们会争夺水源，两者都会死去。

给定一个花坛（表示为一个数组包含0和1，其中0表示没种植花，1表示种植了花），和一个数 n 。能否在不打破种植规则的情况下种入 n 朵花？能则返回True，不能则返回False。

示例 1:

输入: flowerbed = [1,0,0,0,1], n = 1
输出: True

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/can-place-flowers
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
       int count=0;
        int flag=1;
        for(int i=0;i<flowerbed.length;i++){
            if(flowerbed[i]==0){
                flag++;
            }else{
                flag=0;
            }if(flag==3){
                count++;
                flag=1;
            }
        }if(flag==2){
            count++;
        }
        return count>=n;
    }
}

2.假设你正在爬楼梯。需要 n 阶你才能到达楼顶。

每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？

注意：给定 n 是一个正整数。

示例 1：

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/climbing-stairs
class Solution {
    public int climbStairs(int n) {
        int f1=1;
        int f2=2;
        int f3=0;
        if(n==1){
            return 1;
        }if(n==2){
            return 2;
        }else{
            for(int i=3;i<=n;i++){
                f3=f1+f2;
                f1=f2;
                f2=f3;
            }
            return f3;
        }
    }
}

3.给定一个整数数组，判断是否存在重复元素。

如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
class Solution {
    public boolean containsDuplicate(int[] nums) {
       Arrays.sort(nums);
        if(nums.length<2){
            return false;
        }
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==nums[i+1]){
                return true;
            }
        }
        return false;
    }
}

4.
给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大为 k。

示例 1:

输入: nums = [1,2,3,1], k = 3
输出: true

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/contains-duplicate-ii
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        for(int i=0;i<nums.length;i++){
            int a=i+k;
            if(a<nums.length){
                for(a=i+k;a>i;a--){
                if(nums[i]==nums[a]){
                    return true;
                }
             }
           }else{
                for(int j=i+1;j<nums.length;j++){
                    if(nums[i]==nums[j]){
                    return true;
                }
                }
            }
            
        }
       return false;
        }
    }

5.
有一个同学在学习分式。他需要将一个连分数化成最简分数，你能帮助他吗？



连分数是形如上图的分式。在本题中，所有系数都是大于等于0的整数。

 

输入的cont代表连分数的系数（cont[0]代表上图的a0，以此类推）。返回一个长度为2的数组[n, m]，使得连分数的值等于n / m，且n, m最大公约数为1。

 

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/deep-dark-fraction
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。示例 1：

输入：cont = [3, 2, 0, 2]
输出：[13, 4]
解释：原连分数等价于3 + (1 / (2 + (1 / (0 + 1 / 2))))。注意[26, 8], [-13, -4]都不是正确答案。

class Solution {
    public int[] fraction(int[] cont) {
        int[] arr={1,0};
        for(int i=cont.length-1;i>=0;i--){
            int tmp=arr[1];
            arr[1]=arr[0];
            arr[0]=cont[i]*arr[1]+tmp;
        }
        return arr;
    }
}