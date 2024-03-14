package Controllers;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import static org.junit.Assert.*;

public class FileReaderControllerTest {

    private FileReaderController fileReaderController;
    private final String testFilePath = "testFile.csv";

    @Before
    public void setUp() throws IOException {
        fileReaderController = new FileReaderController(testFilePath);
        createTestFile(testFilePath, "1,2,3\n4,5,6\n");
    }

    @After
    public void tearDown() {
        new File(testFilePath).delete();
    }

    @Test
    public void testReadCSV_ValidFile() throws FileNotFoundException {
        List<String[]> result = fileReaderController.readCSV();

        assertNotNull("Result should not be null", result);
        assertEquals("Should read 2 lines", 2, result.size());
        assertArrayEquals("First line should match", new String[]{"1", "2", "3"}, result.get(0));
        assertArrayEquals("Second line should match", new String[]{"4", "5", "6"}, result.get(1));
    }

    @Test(expected = FileNotFoundException.class)
    public void testReadCSV_FileNotFound() throws FileNotFoundException {
        fileReaderController.setFilePath("nonExistingFile.csv");
        fileReaderController.readCSV();
    }

    private void createTestFile(String path, String content) throws IOException {
        File file = new File(path);
        FileWriter writer = new FileWriter(file);
        writer.write(content);
        writer.close();
    }
}
