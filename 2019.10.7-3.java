1.给定一个单词，你需要判断单词的大写使用是否正确。

我们定义，在以下情况时，单词的大写用法是正确的：

全部字母都是大写，比如"USA"。
单词中所有字母都不是大写，比如"leetcode"。
如果单词不只含有一个字母，只有首字母大写， 比如 "Google"。
否则，我们定义这个单词没有正确使用大写字母。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/detect-capital
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public boolean detectCapitalUse(String word) {
        int count=0;
        for(int i=0;i<word.length();i++){
            char c=word.charAt(i);
            if(c>='A'&&c<='Z'){
                count++;
            }if(count==word.length()){
                return true;
            }
        }
        count=0;
          for(int i=0;i<word.length();i++){
            char c=word.charAt(i);
            if(c>='a'&&c<='z'){
                count++;
            }if(count==word.length()){
                return true;
            }
        }
        if(word.charAt(0)>='A'&&word.charAt(0)<='Z'){
             count=1;
            for(int i=1;i<word.length();i++){
            char c=word.charAt(i);
            if(c>='a'&&c<='z'){
                count++;
            }if(count==word.length()){
                return true;
            }
        }
          }
         return false;
    }
}

2.
给定一个偶数长度的数组，其中不同的数字代表着不同种类的糖果，每一个数字代表一个糖果。你需要把这些糖果平均分给一个弟弟和一个妹妹。返回妹妹可以获得的最大糖果的种类数。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/distribute-candies
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public int distributeCandies(int[] candies) {
        Arrays.sort(candies);
        int a=0;
        int b=0;
        int count=1;
        a=candies[0];
        for(int i=1;i<candies.length;i++){
            b=candies[i];
            if(a!=b){
                count++;
                a=b;
            }
        }
        if(count<candies.length/2){
            return count;
        }else{
            return candies.length/2;
        }
    }
}

3.
排排坐，分糖果。

我们买了一些糖果 candies，打算把它们分给排好队的 n = num_people 个小朋友。

给第一个小朋友 1 颗糖果，第二个小朋友 2 颗，依此类推，直到给最后一个小朋友 n 颗糖果。

然后，我们再回到队伍的起点，给第一个小朋友 n + 1 颗糖果，第二个小朋友 n + 2 颗，依此类推，直到给最后一个小朋友 2 * n 颗糖果。

重复上述过程（每次都比上一次多给出一颗糖果，当到达队伍终点后再次从队伍起点开始），直到我们分完所有的糖果。注意，就算我们手中的剩下糖果数不够（不比前一次发出的糖果多），这些糖果也会全部发给当前的小朋友。

返回一个长度为 num_people、元素之和为 candies 的数组，以表示糖果的最终分发情况（即 ans[i] 表示第 i 个小朋友分到的糖果数）。

 

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/distribute-candies-to-people
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public int[] distributeCandies(int candies, int num_people) {
       int[] arr=new int[num_people];
      int start=1;
        int count=0;
        int sum=0;
        while((sum=(start+start+num_people-1)*num_people>>1)<candies){
            candies=candies-sum;
            count++;
            start=start+num_people;
        }
       for(int i=1;i<=num_people;i++){
           arr[i-1]=(i+i+(count-1)*num_people)*(count)>>1;
       }
        for(int i=1;candies>0;i++){
            int c=i+(count)*num_people;
            if(candies>c){
               arr[i-1]+=c;
                candies-=c;
           }else{
                arr[i-1]+=candies;
                candies=0;
            }
            
        }
        return arr;
    }
}