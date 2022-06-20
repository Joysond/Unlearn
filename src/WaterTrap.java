class WaterTrap {
    public static  void optimal() {
        int[] arr = { 0, 1, 0, 2, 1, 0, 1,
                      3, 2, 1, 2, 1 };
        int leftMax = 0, rightMax = 0;
        int high = arr.length - 1, low = 0;
        int waterTrapped = 0;

        while (low <= high) {
            if (arr[low] < arr[high]) {
                if(arr[low] > leftMax) {
                    leftMax = arr[low];
                } else {
                    waterTrapped += leftMax - arr[low];
                }
                low ++;
            } else {
                if(arr[high] > rightMax) {
                    rightMax = arr[high];
                } else {
                    waterTrapped += rightMax - arr[high];
                }
                high--;
            }
        }

        System.out.println("Total water trapped is : " + waterTrapped);
    }
}
