class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for (int i = 0; i < n; i++) {
            String binaryStr1 = Integer.toBinaryString(arr1[i]);
            String binaryStr2 = Integer.toBinaryString(arr2[i]);

            binaryStr1 = String.format("%" + n + "s", binaryStr1).replace(" ", "0");
            binaryStr2 = String.format("%" + n + "s", binaryStr2).replace(" ", "0");

            StringBuilder mapBuilder = new StringBuilder();

            for (int j = 0; j < n; j++) {
                if (binaryStr1.charAt(j) == '0' && binaryStr2.charAt(j) == '0') {
                    mapBuilder.append(" ");
                } else {
                    mapBuilder.append("#");
                }
            }
            answer[i] = mapBuilder.toString();
        }

        return answer;
    }
}
