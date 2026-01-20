class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        // 상우하좌 1칸, 2칸
        int[] dy1 = { -1, 0, 1, 0 };
        int[] dx1 = { 0, 1, 0, -1 };
        int[] dy2 = { -2, 0, 2, 0 };
        int[] dx2 = { 0, 2, 0, -2 };
        // 대각선 좌상우상우하좌하
        int[] dy3 = { -1, -1, 1, 1 };
        int[] dx3 = { -1, 1, 1, -1 };
        for (int t = 0; t < places.length; t++) {
            boolean check = false;
            char[][] arr = new char[5][5];

            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    arr[i][j] = places[t][i].charAt(j);
                }
            }
            
            // 상하좌우
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (arr[i][j] != 'P') continue;
                    for (int dir = 0; dir < 4; dir++) {
                        int x1 = dx1[dir] + j;
                        int y1 = dy1[dir] + i;
                        if (x1 < 0 || x1 >= 5 || y1 < 0 || y1 >= 5) continue;
                        if (arr[y1][x1] != 'P') continue;
                        check = true;
                        break;
                    }
                    if (check) break;
                    
                    for (int dir = 0; dir < 4; dir++) {
                        int x2 = dx2[dir] + j;
                        int y2 = dy2[dir] + i;
                        if (x2 < 0 || x2 >= 5 || y2 < 0 || y2 >= 5) continue;
                        if (arr[y2][x2] != 'P') continue;
                        int x1 = dx1[dir] + j;
                        int y1 = dy1[dir] + i;
                        if (arr[y1][x1] != 'X') {
                            check = true;
                            break;
                        }
                    }
                }
                if (check) break;
            }
            if (check) {
                answer[t] = 0;
                continue;
            }
            
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (arr[i][j] != 'P') continue;
                    for (int dir = 0; dir < 4; dir++) {
                        int x = dx3[dir] + j;
                        int y = dy3[dir] + i;
                        if (x < 0 || x >= 5 || y < 0 || y >= 5) continue;
                        if (arr[y][x] != 'P') continue;
                        int dy = 0;
                        int dx = 0;
                        if (dir == 0) {
                            dy = y + 1;
                            dx = x + 1;
                        } else if (dir == 1) {
                            dy = y + 1;
                            dx = x - 1;
                        } else if (dir == 2) {
                            dy = y - 1;
                            dx = x - 1;
                        } else {
                            dy = y - 1;
                            dx = x + 1;
                        }
                        if (dx < 0 || dx >= 5 || dy < 0 || dy >= 5) {
                            check = true;
                            break;
                        }
                        if (arr[dy][x] == 'X' && arr[y][dx] == 'X') continue;
                        check = true;
                        break;
                    }
                }
                if (check) break;
            }
            
            if (check) {
                answer[t] = 0;
                continue;
            } else {
                answer[t] = 1;
            }
        }
        return answer;
    }
}