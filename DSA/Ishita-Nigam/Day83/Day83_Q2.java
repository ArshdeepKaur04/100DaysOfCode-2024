import java.util.Arrays;

class Day83_Q2 {

    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) {
            return 0;
        }
        
        int maxStop = -1;
        for (int[] route : routes) {
            for (int stop : route) {
                maxStop = Math.max(maxStop, stop);
            }
        }

        if (maxStop < target) {
            return -1;
        }

        int n = routes.length;
        int[] minBusesToReach = new int[maxStop + 1];
        Arrays.fill(minBusesToReach, n + 1);
        minBusesToReach[source] = 0;
        boolean flag = true;

        while (flag) {
            flag = false;
            for (int[] route : routes) {
                int min = n + 1;
                for (int stop : route) {
                    min = Math.min(min, minBusesToReach[stop]);
                }
                min++;
                for (int stop : route) {
                    if (minBusesToReach[stop] > min) {
                        minBusesToReach[stop] = min;
                        flag = true;
                    }
                }
            }
        }

        return (minBusesToReach[target] < n + 1 ? minBusesToReach[target] : -1);
    }

    public static void main(String[] args) {
        Day83_Q2 solution = new Day83_Q2();
        int[][] routes = {
            {1, 2, 7},
            {3, 6, 7}
        };
        int source = 1;
        int target = 6;

        int result = solution.numBusesToDestination(routes, source, target);
        System.out.println("Minimum number of buses required: " + result);
    }
}
