class Solution {
    public int[] findNotBlocked(int[] speed) {
        List<Integer> result = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for (int i = speed.length - 1; i >= 0; i--) {
            if (speed[i] <= min) {
                result.add(i);
                min = speed[i];
            }
        }
        Collections.reverse(result);
        return result.stream().mapToInt(i -> i).toArray();
    }
}
