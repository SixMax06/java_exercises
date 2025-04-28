import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class MyLinkedListTest {
    @Test
    @Timeout(value = 10, unit = TimeUnit.MILLISECONDS, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
    void addInTesta() {
        MyLinkedList ll = new MyLinkedList();
        ll.addFirst(12);
        ll.addFirst(7);
        ll.addFirst(9);
        String expectedList = "[9, 7, 12]";
        String actualList = ll.toString();

        int expectedSize = 3;
        int actualSize = ll.getSize();

        assertEquals(expectedList, actualList);
        assertEquals(expectedSize, actualSize);
    }

    @Test
    void listaVuota() {
        MyLinkedList ll = new MyLinkedList();
        assertEquals("[]", ll.toString());
    }

}