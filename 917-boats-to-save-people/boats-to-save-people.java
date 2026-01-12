class Solution {


    public int numRescueBoats(int[] people, int limit) {
        int res = 0, n  = people.length, l = 0;

        int r = n - 1;

        Arrays.sort(people);

        while(l <= r) {
            if(people[l] + people[r] <= limit) {
                r--;
                l++;
            } else {
                r--;
            }
            res++;
        }
        return res;
    }
}