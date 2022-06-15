class question2 {
    public static void main(String[] args) {
        int[] a = new int[]{22,-1,3,-4,55,1};
        System.out.println(getClosestToZero(a));
    }

    public static int getClosestToZero(int[] a) {
        int targetIndex = 0;
        int valueStore = Integer.MAX_VALUE;
        for (int i = 0; i < a.length; i++) {
            int value = Math.abs(a[i]);
            if (valueStore > value) {
                targetIndex = i;
                valueStore = value;
            }else if (value == valueStore && a[i] > 0 && a[targetIndex] < 0) {
                targetIndex = i;
            }
        }
        return a[targetIndex];
    }
}
