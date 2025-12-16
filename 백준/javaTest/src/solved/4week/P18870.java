import java.io.*;
import java.util.*;

public class P18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        Set<Integer> set = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            set.add(arr[i]);
        }

        List<Integer> list = new ArrayList<>();
        for (int num : set) list.add(num);

        Collections.sort(list);

        Map<Integer, Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < list.size(); i++) {
            map.put(list.get(i), i);
        }

        for (int i = 0; i < N; i++) {
            sb.append(map.get(arr[i])).append(" ");
        }

        System.out.println(sb.toString());


    }
}
