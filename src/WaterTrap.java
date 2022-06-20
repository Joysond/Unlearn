class WaterTrap {
    public  void optimal() {
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
    
    public void subOptimal() {
        nt[] array = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int[] leftMax = new int[array.length];
        int[] rightMax = new int[array.length];

        leftMax[0] = array[0];
        rightMax[array.length - 1] = array[array.length -1];

        for (int i=1; i<array.length;i++) {
            leftMax[i] = Math.max(leftMax[i-1], array[i]);
            rightMax[array.length - i - 1] = Math.max(rightMax[array.length - i], array[array.length - i - 1]);
        }

        Arrays.stream(leftMax).forEach(System.out::println);
        Arrays.stream(rightMax).forEach(System.out::println);

        int totalWaterStored = 0;
        for(int i=0;i<array.length;i++) {
            totalWaterStored += Math.min(leftMax[i], rightMax[i]) - array[i];
        }

        System.out.println("Total water stored is : " + totalWaterStored);
    }
}
