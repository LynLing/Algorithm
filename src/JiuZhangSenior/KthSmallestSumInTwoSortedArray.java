package JiuZhangSenior;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestSumInTwoSortedArray {
    class Pair {
        int x, y, val;
        public Pair(int x, int y, int val){
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }

    class PairComparator implements Comparator<Pair> {
        public int compare(Pair a, Pair b){
            return a.val - b.val;
        }
    }
    public int kthSmallestSum(int[] A, int[] B, int k) {
        // write your code here
        int[] dx = new int[]{0, 1};
        int[] dy = new int[]{1, 0};
        boolean[][] hash = new boolean[A.length][B.length];
        PriorityQueue<Pair> minHeap = new PriorityQueue<Pair>(k, new PairComparator());
        minHeap.add(new Pair(0, 0, A[0]+B[0]));

        for(int i = 0; i < k - 1; i++){
            Pair cur = minHeap.poll();
            for(int j = 0; j < 2; j++){
                int next_x = cur.x + dx[j];
                int next_y = cur.y + dy[j];
                Pair next_Pair = new Pair(next_x, next_y, 0);
                if(next_x < A.length && next_y < B.length && !hash[next_x][next_y]) {
                    hash[next_x][next_y] = true;
                    next_Pair.val = A[next_x] + B[next_y];
                    minHeap.add(next_Pair);
                }
            }
        }

        return minHeap.peek().val;

    }
}
