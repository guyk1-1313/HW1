public class Assignment01Q05 {

    public static int findShortestPath(int[][] m, int i, int j) {
        if (i == j) {
            return 0;
        }

        int n = m.length;
        
        int[] queue = new int[n];
        int head = 0;
        int tail = 0;
        
        int[] distances = new int[n];
        for (int k = 0; k < n; k++) {
            distances[k] = -1;
        }

        queue[tail] = i;
        tail++;
        distances[i] = 0;

        while (head < tail) {
            int curr = queue[head];
            head++;

            if (curr == j) {
                return distances[curr];
            }

            for (int neighbor = 0; neighbor < n; neighbor++) {
                if (m[curr][neighbor] != 0 && distances[neighbor] == -1) {
                    distances[neighbor] = distances[curr] + 1;
                    queue[tail] = neighbor;
                    tail++;
                }
            }
        }

        return -1;
    }




    public static void main(String[] args) {
        System.out.println(
            findShortestPath(new int[][]{{0,0,0}, {0,0,0}, {0,0,0}}, 0, 1)); // -1
        System.out.println(
            findShortestPath(new int[][]{{0,0,0}, {0,0,0}, {0,0,0}}, 1, 1)); // 0
        System.out.println(
            findShortestPath(new int[][]{{0,1,0,0}, {0,0,1,0}, {0,0,0,1}, {1,0,0,0}}, 0, 2)); // 2
        System.out.println(
            findShortestPath(new int[][]{{0,1,0,1}, {0,0,0,1}, {0,0,0,0}, {0,0,1,0}}, 0, 2)); // 2

    }
}