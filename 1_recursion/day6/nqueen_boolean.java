public class nqueen_boolean {
    static boolean[] rows, cols, diags, adiags;

    public static int nqueen_01(int n, int tnq, int bno, String psf) {
        if (tnq == 0) {
            System.out.println(psf);
            return 1;
        }
        int count = 0;
        for (int bidx = bno; bidx < n * n; bidx++) {
            int r = bidx / n, c = bidx % n;
            if (!rows[r] && !cols[c] && !diags[r - c + n - 1] && !adiags[r + c]) {
                rows[r] = cols[c] = diags[r - c + n - 1] = adiags[r + c] = true;
                count += nqueen_01(n, tnq - 1, bidx + 1, psf + "(" + r + "," + c + ") ");
                rows[r] = cols[c] = diags[r - c + n - 1] = adiags[r + c] = false;
            }
        }
        return count;
    }

    // r-c+n-1 ==> diagonal
    // r+c==> antidiagonal



    // we can use the bit wise logic here also using the mapping that we compare with boolean




    
}
