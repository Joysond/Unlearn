package hard;

public class MedianOfSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {8, 9};
        int[] nums2 = {2,4, 5};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i=0,j=0;
        for(;i<nums1.length || j<nums2.length;) {
            int median = (nums1.length + nums2.length)/2;
            boolean isOdd = median % 2 == 0;
            // If median is odd we have to look for only one value else 2 values and divide them by 2
            if(i<nums1.length && j < nums2.length) {
                if(nums1[i] < nums2[j]) {
                    System.out.println(nums1[i]);
                    if(i+j == median) {
                        if(isOdd) {
                            //return i < j ? nums1[i] : nums2[j];
                        }
                    }
                    i++;
                } else {
                    System.out.println(nums2[j]);
                    j++;
                    if(i+j == median) {
                        if(isOdd) {
                            //return i < j ? nums1[i] : nums2[j];
                        }
                    }
                }
            } else if(i < nums1.length) {
                System.out.println(nums1[i]);
                if(i+j == median) {
                    if(isOdd) {
                        //return nums1[i];
                    }
                }
                i++;
            } else {
                System.out.println(nums2[j]);
                if(i+j == median) {
                    if(isOdd) {
                        //return nums2[j];
                    }
                }
                j++;
            }
        }
        System.out.println("ï >> " + i + " j >> " + j);
        return 0;
    }
}
