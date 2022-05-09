public class l7_nqueenpermutation {
    public static void main(String[] args) {
        
        boolean[][]  mat =new boolean[4][4];
      int val=  nqueen_01_Perm(mat,3,"");
     
      System.out.println(val);
     }
 
     public static int nqueen_01_Perm(boolean[][] boxes, int tnq, String psf) {
        if (tnq == 0) {
            System.out.println(psf);
            return 1;
        }
        int count = 0, n = boxes.length;
        for (int bidx = 0; bidx < n * n; bidx++) {
            int r = bidx / n, c = bidx % n;
            if (!boxes[r][c] && isSafeToPlaceQueen(boxes, r, c)) {
                boxes[r][c] = true;
                count += nqueen_01_Perm(boxes, tnq - 1, psf + "(" + r + "," + c + ") ");
                boxes[r][c] = false;
            }
        }
        return count;
    }
    public static boolean isSafeToPlaceQueen(boolean[][] boxes, int r, int c) {
        // int[][] dir = { { 0, -1 }, { -1, -1 }, { -1, 0 }, { -1, 1 } };
        int[][] dir = { { 0, -1 }, { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 } };
        int n = boxes.length;
        for (int d = 0; d < dir.length; d++) {
            for (int rad = 1; rad <= n; rad++) {
                int x = r + rad * dir[d][0];
                int y = c + rad * dir[d][1];

                if (x >= 0 && y >= 0 && x < n && y < n) {
                    if (boxes[x][y])
                        return false;
                } else
                    break;
            }
        }
        return true;
    }

    
}