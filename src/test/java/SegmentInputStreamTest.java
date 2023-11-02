
import nl.ben221199.wapi.SegmentInputStream;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.io.InputStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.when;


public class SegmentInputStreamTest {

    @Mock
    private InputStream mockInputStream;

    private SegmentInputStream segmentInputStream;

    @BeforeEach
    public void setUp() {
        mockInputStream = Mockito.mock(InputStream.class);
        segmentInputStream = new SegmentInputStream(mockInputStream);
    }

    @Test
    public void testReadInt24BE() throws IOException {
        byte[] data = { 0x01, 0x02, 0x03 };

        when(mockInputStream.read()).thenReturn((int) data[0], (int) data[1], (int) data[2]);

        int result = segmentInputStream.readInt24BE();

        assertEquals(0x010203, result);

    }

    @Test
    public void testReadSegment() throws IOException {
        byte[] segmentData = { 0x00, 0x00, 0x03, (byte) 0x01, (byte) 0x02, (byte) 0x03 };
        when(mockInputStream.read()).thenReturn(
                (int) segmentData[0], (int) segmentData[1], (int) segmentData[2],
                (int) segmentData[3], (int) segmentData[4], (int) segmentData[5]
        );

        byte[] result = segmentInputStream.readSegment();

        assertArrayEquals(new byte[] { (byte) 0x01, (byte) 0x02, (byte) 0x03 }, result);

    }

}