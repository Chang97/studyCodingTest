import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] result = new int[id_list.length];
        Set<Integer>[] reports = new LinkedHashSet[id_list.length];
        Map<String, Integer> userIdx = new HashMap<>();
        Map<String, Integer> reportCount = new HashMap<>();

        // 초기화
        for (int i = 0; i < id_list.length; i++) {
            reportCount.put(id_list[i], 0);
            userIdx.put(id_list[i], i);
            reports[i] = new LinkedHashSet<>();
        }

        // 신고 처리
        for (String rep : report) {
            String[] tmp = rep.split(" ");
            String from = tmp[0];
            String to = tmp[1];
            reports[userIdx.get(from)].add(userIdx.get(to));
        }

        // 신고 횟수 집계
        for (Set<Integer> reportSet : reports) {
            for (int idx : reportSet) {
                String reportedUser = id_list[idx];
                reportCount.put(reportedUser, reportCount.get(reportedUser) + 1);
            }
        }

        // 신고 결과 반영
        for (int i = 0; i < id_list.length; i++) {
            for (int reportedIdx : reports[i]) {
                if (reportCount.get(id_list[reportedIdx]) >= k) {
                    result[i]++;
                }
            }
        }

        return result;
    }
}
