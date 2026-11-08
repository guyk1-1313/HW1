public class Assignment01Q05 {
    public static int findShortestPath(int[][] m, int i, int j) {
        int[] memo = new int[m.length];
        return findShortestPath_rec(m , i , j , memo, 0);
        }

    
public static int findShortestPath_rec(int[][] m, int i, int j,int[] memo, int counter) {
            int curr_min = -1;
            if (i==j) {return counter + 0;} // we reached the goal
            if (memo[i]==1) {return -1;} // we have been here, lets not walk in a circle
             memo[i] = 1; // mark this node as visited
            for (int a = 0 ; a < m.length ; a++) { // this loop finds the next route (if exists)
                if(m[i][a]==0) {continue;}
                else {
                    curr_min = findShortestPath_rec(m , a , j , memo , counter + 1);
                    break;
                }
            }
            
            for (int x = 0 ; x < m.length ; x++) { //now we find the minimal route
                if(m[i][x]==0) {continue;}
                else {
                    if (curr_min == -1) {curr_min = findShortestPath_rec(m , x , j , memo , counter + 1);}
                    else if (findShortestPath_rec(m , x , j , memo , counter + 1) == -1) {continue;}
                    else curr_min = Math.min(curr_min, findShortestPath_rec(m , x , j , memo , counter + 1));
                }
            }
            memo[i]= 0; //erese the marks as we fold the recurtion so future paths wont be misslead
            return curr_min;
        
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