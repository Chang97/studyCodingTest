class Solution {
    public int solution(int[][] sizes) {
        int[][] resize = new int[sizes.length][sizes[0].length];
        int wmax = Integer.MIN_VALUE;
        int hmax = Integer.MIN_VALUE;
        for (int i = 0; i < resize.length; i++) {
            if (sizes[i][0] > sizes[i][1]) {
                resize[i][0] = sizes[i][0];
                resize[i][1] = sizes[i][1];
            } else {
                resize[i][0] = sizes[i][1];
                resize[i][1] = sizes[i][0];
            }
            
            if (resize[i][0] > wmax) wmax = resize[i][0];
            if (resize[i][1] > hmax) hmax = resize[i][1];
        }

        return wmax * hmax;
    }
}