package hard;

public class RobberSimple {
    public static void main(String[] args) {
        int[] array = {1,2,3};
        System.out.println(rob(array));
    }

    public static int rob(int[] nums) {
        int sum = 0, lastAddedIndex=0;
        for(int i=0;i<nums.length-1;i++) {
            if(nums[i]>nums[lastAddedIndex]) {
                sum-=nums[lastAddedIndex];
                sum+=nums[i];
                lastAddedIndex = i;
                //System.out.println("lastAddedIndex = " + lastAddedIndex + " index = " + i);
                continue;
            }
            if(i==lastAddedIndex+1)
                continue;
            if(i==lastAddedIndex-1) {
                sum-=nums[lastAddedIndex-1];
                continue;
            }
            if(nums[i] > nums[i+1]) {
                sum+=nums[i];
                lastAddedIndex = i;
                //System.out.println("lastAddedIndex = " + lastAddedIndex + " index = " + i);
            } else {
                sum+=nums[i+1];
                lastAddedIndex = i+1;
                //i = i+1;
                //System.out.println("lastAddedIndex = " + lastAddedIndex + " index = " + i);
            }

        }
        return sum;
    }
}
