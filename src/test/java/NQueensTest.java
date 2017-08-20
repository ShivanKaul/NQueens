import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * For the purposes of testing, I will only be checking if the number of solutions generated are correct for an 'n'
 */
public class NQueensTest {

    private static final Map<Integer, Integer> ANSWERS = new HashMap<>();
    private static Map<Integer, Integer> placed;

    @BeforeAll
    public static void runOnce() {
        ANSWERS.put(2, 0);
        ANSWERS.put(3, 0);
        ANSWERS.put(4, 2);
        ANSWERS.put(8, 92);
        placed = new HashMap<>();
        NQueens.setPrint(false);
    }

    @BeforeEach
    public void runBeforeEachTest() {
        placed = new HashMap<>();
        NQueens.reset();
    }

    /**
     * n = 2
     */
    @Test
    public void testSolveNQueens_2() {
        tester(2);
    }
    /**
     * n = 3
     */
    @Test
    public void testSolveNQueens_3() {
        tester(3);
    }
    /**
     * n = 4
     */
    @Test
    public void testSolveNQueens_4() {
        tester(4);
    }
    /**
     * n = 8
     */
    @Test
    public void testSolveNQueens_8() {
        tester(8);
    }

    private void tester(int n) {
        assertEquals(0, NQueens.getN());
        NQueens.setN(n);
        NQueens.solveNQueens(placed, 0);
        assertEquals((int)ANSWERS.get(n), NQueens.getNum_solutions());
    }
}
