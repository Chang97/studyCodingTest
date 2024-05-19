class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] position = new int[2];
        
        for (int i = 0; i < park.length; i++) {
            int idx = park[i].indexOf("S");
            if (idx != -1) {
                position[0] = i;
                position[1] = idx;
                break;
            }
        }
        
        for (String route : routes) {
            String[] parts = route.split(" ");
            String direction = parts[0];
            int steps = Integer.parseInt(parts[1]);
            int newRow = position[0];
            int newCol = position[1];

            switch (direction) {
                case "E":
                    newCol += steps;
                    break;
                case "W":
                    newCol -= steps;
                    break;
                case "N":
                    newRow -= steps;
                    break;
                case "S":
                    newRow += steps;
                    break;
            }

            // 유효성 검사를 하고, 유효하면 위치를 업데이트합니다.
            if (isValidMove(position[0], position[1], newRow, newCol, park)) {
                position[0] = newRow;
                position[1] = newCol;
            }
        }

        return position;
    }

    private boolean isValidMove(int startRow, int startCol, int endRow, int endCol, String[] park) {
        if (endRow < 0 || endRow >= park.length || endCol < 0 || endCol >= park[0].length()) {
            return false;
        }

        if (startRow == endRow) {
            int colStart = Math.min(startCol, endCol);
            int colEnd = Math.max(startCol, endCol);
            for (int i = colStart; i <= colEnd; i++) {
                if (park[startRow].charAt(i) == 'X') {
                    return false;
                }
            }
        } else if (startCol == endCol) {
            int rowStart = Math.min(startRow, endRow);
            int rowEnd = Math.max(startRow, endRow);
            for (int i = rowStart; i <= rowEnd; i++) {
                if (park[i].charAt(startCol) == 'X') {
                    return false;
                }
            }
        }

        return true;
    }
}
