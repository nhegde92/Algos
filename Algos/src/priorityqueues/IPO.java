package priorityqueues;

import java.util.Arrays;
import java.util.PriorityQueue;

public class IPO {
    static public class Project {
        int capital;
        int profit;

        Project(int capital, int profit) {
            this.capital = capital;
            this.profit = profit;
        }
    }

    public static int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        if (k == 0)
            return 0;
        PriorityQueue<Project> heap = new PriorityQueue<>((a, b) -> b.profit - a.profit);
        Project[] projects = new Project[capital.length];
        for (int i = 0; i < capital.length; i++) {
            projects[i] = new Project(capital[i], profits[i]);
        }
        Arrays.sort(projects, (a, b) -> a.capital - b.capital);

        int i = 0;
        while (k > 0) {
            while (i < projects.length) {
                if (projects[i].capital > w)
                    break;

                heap.offer(projects[i]);
                i++;
            }

            if (heap.size() == 0)
                return w;
            k--;
            w = w + heap.poll().profit;
        }
        return w;
    }

    public static void main(String[] args) {
        int k = 3;
        int w = 0;
        int[] profits = new int[]{1,2,3};
        int[] capital = new int[]{0,1,2};
        System.out.println(findMaximizedCapital(k,w,profits,capital));
    }
}

/*Time complexity
O(NLogN)
Space O(n)

 */
