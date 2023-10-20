import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class CUTest {

    private CU cu;

    @BeforeEach
    public void setUp() {
        cu = new CU("Math", 3);
    }

    @ParameterizedTest
    @CsvSource({ "1, 8.0", "2, 10.0", "3, 9.0" })
    public void testInsertMarkCU(double numStudent, double mark) {
        cu.insertMarkCU((int) numStudent, mark);
        double studentMark = cu.searchStudent((int) numStudent);
        assertEquals(mark, studentMark, 0.01);
    }

    @ParameterizedTest
    @CsvSource({ "8.0, 10.0, 9.0", "7.5, 9.5, 8.5", "6.0, 6.5, 7.0" })
    public void testAverageCU(double mark1, double mark2, double mark3) {
        cu.insertMarkCU(1, mark1);
        cu.insertMarkCU(2, mark2);
        cu.insertMarkCU(3, mark3);
        double average = cu.averageCU();
        double expectedAverage = (mark1 + mark2 + mark3) / 3;
        assertEquals(expectedAverage, average, 0.01);
    }

    @ParameterizedTest
    @CsvSource({ "1, 13.0, true", "2, 10.0, true", "3, 9.5, true", "4, 7.0, false" })
    public void testIsApproved(int numStudent, double mark, boolean expected) {
        cu.insertMarkCU(numStudent, mark);
        boolean approved = cu.isApproved(numStudent);
        assertEquals(expected, approved);
    }
}