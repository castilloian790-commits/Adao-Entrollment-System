package tests;

import entities.Student;
import exceptions.DuplicateIdException;
import impl.StudentServiceImpl;
import services.IStudentService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StudentServiceTest {

    @Test
    public void testAddStudent_DuplicateId_ThrowsException() throws DuplicateIdException {
        // Arrange
        IStudentService service = new StudentServiceImpl();
        Student first = new Student("S001", "Alice", "IT");
        Student duplicate = new Student("S001", "Bob", "IT"); // Same ID, different person

        service.addStudent(first);

        // Act & Assert — adding the duplicate must throw
        assertThrows(DuplicateIdException.class, () -> {
            service.addStudent(duplicate);
        });

        // Verify the list wasn't mutated by the failed add
        assertEquals(1, service.getAllStudents().size(),
                "Roster should still have only the first student.");
    }
}