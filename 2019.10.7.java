1.
给定一个正整数 N，找到并返回 N 的二进制表示中两个连续的 1 之间的最长距离。 

如果没有两个连续的 1，返回 0 。
示例 1：

输入：22
输出：2
解释：
22 的二进制是 0b10110 。
在 22 的二进制表示中，有三个 1，组成两对连续的 1 。
第一对连续的 1 中，两个 1 之间的距离为 2 。
第二对连续的 1 中，两个 1 之间的距离为 1 。
答案取两个距离之中最大的，也就是 2 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/binary-gap
class Solution {
    public int binaryGap(int N) {
        int len=0;
        int maxlen=0;
         int flag=0;
        while(N!=0){
            int a=N%2;
            if(a==1){
                flag++;
            }if(flag==1&&a==0){
                len++;
            }if(flag==2){
                len++;
            }if(len>maxlen){
                maxlen=len;
            }if(flag==2){
                len=0;
                flag=1;
            }
            N/=2;
        }
        return maxlen;
    }
}

2.给定一个整数，编写一个算法将这个数转换为十六进制数。对于负整数，我们通常使用 补码运算 方法。

注意:

十六进制中所有字母(a-f)都必须是小写。
十六进制字符串中不能包含多余的前导零。如果要转化的数为0，那么以单个字符'0'来表示；对于其他情况，十六进制字符串中的第一个字符将不会是0字符。 
给定的数确保在32位有符号整数范围内。
不能使用任何由库提供的将数字直接转换或格式化为十六进制的方法。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/convert-a-number-to-hexadecimal
class Solution {
    public String toHex(int num) {
        if(num==0){
            return "0";
        }
       char[] arr={'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'} ;
        StringBuffer sb=new StringBuffer();
        while(num!=0){
            sb.append(arr[num&15]);
            num>>>=4;
        }
        return sb.reverse().toString();
    }
}

3.假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。对每个孩子 i ，都有一个胃口值 gi ，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j ，都有一个尺寸 sj 。如果 sj >= gi ，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。

注意：

你可以假设胃口值为正。
一个小朋友最多只能拥有一块饼干。

示例 1:

输入: [1,2,3], [1,1]

输出: 1

解释: 
你有三个孩子和两块小饼干，3个孩子的胃口值分别是：1,2,3。
虽然你有两块小饼干，由于他们的尺寸都是1，你只能让胃口值是1的孩子满足。
所以你应该输出1。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/assign-cookies
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int count=0;
        Arrays.sort(g);
        Arrays.sort(s);
        for(int i=s.length-1;i>=0;i--){
            for(int j=g.length-1;j>=0;j--){
                if((s[i]-g[j]>=0)&&(g[j]!=0)){
                    count++;
                    g[j]=0;
                    break;
                }
            }
        }
        if(count>g.length){
            return g.length;
        }else{
            return count;
        }
    }
}