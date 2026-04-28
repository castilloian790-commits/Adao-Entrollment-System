package tests;

import entities.Section;
import entities.Student;
import exceptions.SectionFullException;
import impl.EnrollmentServiceImpl;
import services.IEnrollmentService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EnrollmentServiceTest {

    @Test
    public void testEnrollStudent_Success() throws SectionFullException {
        // Arrange
        Section section = new Section("BSIT-1A", 30);
        Student student = new Student("S001", "Alice", "IT");
        IEnrollmentService service = new EnrollmentServiceImpl();

        // Act
        service.enrollStudentInSection(student, section);

        // Assert
        assertEquals(1, section.getEnrolledStudents().size());
        assertTrue(section.getEnrolledStudents().contains(student));
    }

    @Test
    public void testEnrollStudent_SectionFull_ThrowsException() throws SectionFullException {
        // Arrange
        Section section = new Section("BSIT-1A", 2);
        Student s1 = new Student("S01", "Alice", "IT");
        Student s2 = new Student("S02", "Bob", "IT");
        Student s3 = new Student("S03", "Charlie", "IT");
        IEnrollmentService service = new EnrollmentServiceImpl();

        service.enrollStudentInSection(s1, section);
        service.enrollStudentInSection(s2, section);

        // Act & Assert — the third enrollment should throw
        assertThrows(SectionFullException.class, () -> {
            service.enrollStudentInSection(s3, section);
        });
        assertEquals(2, section.getEnrolledStudents().size(),
                "Section should still only have 2 students after the failed enrollment.");
    }
}