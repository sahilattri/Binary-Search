public class AllocateBooks {
    public int books(ArrayList<Integer> A, int B) {
        if (B > A.size()) return -1;
        int l = A.get(0);
        int h = A.get(0);
        
        for (int i = 1 ; i < A.size() ; i ++) {
            l = Math.max(A.get(i), l);
            h += A.get(i);
        }

        int ans = -1;
        while (l <= h) {
            int mid = (l + h) / 2;
            if(isPossible(A, mid, B)) {
                ans = mid;
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }
    
    boolean isPossible(ArrayList<Integer> A, int x, int B) {
        int n = 0;
        int sum = 0;
        int i = 0;
        while(i < A.size()) {
            if (A.get(i) > x) return false;
            if (sum + A.get(i) > x) {
                n ++;
                sum = 0;
                continue;
            } else {
                sum += A.get(i);
                i ++;
            }
        }
        if (sum != 0) {
            n ++;
        }
        return n <= B;
    }
}
