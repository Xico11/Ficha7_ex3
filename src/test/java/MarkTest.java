import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class MarkTest {

    private Mark mark;

    @BeforeEach
    public void setUp() {
        mark = new Mark(1, 8.0);
    }

    @ParameterizedTest
    @CsvSource({ "1, 8.0", "2, 10.0", "3, 9.0" })
    public void testGetNumStudentAndMark(int numStudent, double studentMark) {
        mark = new Mark(numStudent, studentMark);
        assertEquals(numStudent, mark.getNumStudent(), "Teste de getNumStudent()");
        assertEquals(studentMark, mark.getMark(), 0.01, "Teste de getMark()");
    }
}