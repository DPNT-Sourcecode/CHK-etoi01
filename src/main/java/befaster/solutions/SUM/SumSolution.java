package befaster.solutions.SUM;

import befaster.runner.SolutionNotImplementedException;

@SuppressWarnings("unused")
public class SumSolution {

    public int compute(int x, int y) {
        return x + y;
    }

    public static void main(String[] args) {
        SumSolution solution = new SumSolution();
        System.out.println(solution.compute(5, 4));
        System.out.println(solution.compute(4, -1));
    }

}

