package BOJ;
import java.util.*;

public class B1348{
    static int r, c; 
    static List<String> board = new ArrayList<>();
    static int[][] car_check = new int[50][50]; 
    static int[][] park_check = new int[50][50]; 
    static int[][] car_park = new int[251][251]; 
    static List<Pair<Integer, Integer>>[] adj = new List[251]; 
    static int car_cnt = 0; 
    static int park_cnt = 0; 
    static int[][] dxdy = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}}; 

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        r = scanner.nextInt();
        c = scanner.nextInt();
        scanner.nextLine(); 

        for (int i = 0; i < r; i++) {
            String input = scanner.nextLine();
            board.add(input);
        }

        for (int i = 1; i <= 250; i++) {
            adj[i] = new ArrayList<>();
            Arrays.fill(car_park[i], -1); 
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board.get(i).charAt(j) == 'C') {
                    car_cnt++;
                    car_check[i][j] = car_cnt;
                } else if (board.get(i).charAt(j) == 'P') {
                    park_cnt++;
                    park_check[i][j] = park_cnt;
                }
            }
        }

        if (car_cnt == 0) {
            System.out.println(0);
            return;
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (car_check[i][j] != 0) {
                    int car_number = car_check[i][j];
                    calculateDistances(car_number, new Pair<>(i, j));
                }
            }
        }

        makeGraph();

        int left = 0;
        int right = 2500;
        int result = -1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (check(mid)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(result);
    }

    static void makeGraph() {
        for (int i = 1; i <= car_cnt; i++) {
            for (int j = 1; j <= park_cnt; j++) {
                if (car_park[i][j] != -1) {
                    adj[i].add(new Pair<>(car_park[i][j], j));
                }
            }
        }
    }

    static boolean selectPark(int car, int dist, int[] thisSelectedCar, int[] parkedCar) {
        if (thisSelectedCar[car] == 1) return false;

        thisSelectedCar[car] = 1;

        for (Pair<Integer, Integer> pair : adj[car]) {
            int thisDist = pair.getKey();
            int thisPark = pair.getValue();

            if (thisDist <= dist) {
                if (parkedCar[thisPark] == 0) {
                    parkedCar[thisPark] = car; 
                    return true;
                } else {
                    if (selectPark(parkedCar[thisPark], dist, thisSelectedCar, parkedCar)) {
                        parkedCar[thisPark] = car; 
                        return true;
                    }
                }
            }
        }

        return false;
    }

    static boolean check(int dist) {
        int[] parkedCar = new int[251]; 

        for (int i = 1; i <= car_cnt; i++) {
            int[] thisSelectedCar = new int[251]; 
            if (!selectPark(i, dist, thisSelectedCar, parkedCar)) {
                return false; 
            }
        }

        return true;
    }

    static void calculateDistances(int car_number, Pair<Integer, Integer> car_start) {
        int[][] discovered = new int[50][50];
        int[][] depth = new int[50][50];
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        int find_park = 0;

        discovered[car_start.getKey()][car_start.getValue()] = 1;
        depth[car_start.getKey()][car_start.getValue()] = 0;
        queue.offer(car_start);

        while (!queue.isEmpty()) {
            Pair<Integer, Integer> here = queue.poll();

            if (park_check[here.getKey()][here.getValue()] != 0) {
                int park_number = park_check[here.getKey()][here.getValue()];
                car_park[car_number][park_number] = depth[here.getKey()][here.getValue()];

                find_park++;

                if (find_park == park_cnt) break;
            }

            for (int i = 0; i < 4; i++) {
                int newX = here.getKey() + dxdy[i][0];
                int newY = here.getValue() + dxdy[i][1];
                Pair<Integer, Integer> there = new Pair<>(newX, newY);

                if (newX >= 0 && newX < r && newY >= 0 && newY < c &&
                    board.get(newX).charAt(newY) != 'X' && discovered[newX][newY] == 0) {
                    discovered[newX][newY] = 1;
                    depth[newX][newY] = depth[here.getKey()][here.getValue()] + 1;
                    queue.offer(there);
                }
            }
        }
    }

    static class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}
