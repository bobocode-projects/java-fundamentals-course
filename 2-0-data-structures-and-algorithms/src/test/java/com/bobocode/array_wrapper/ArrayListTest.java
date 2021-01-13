package com.bobocode.array_wrapper;

import com.bobocode.linked_list.List;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.NoSuchElementException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ArrayListTest {

    private List<Integer> arrayList = new ArrayList<>();

    @Test
    @Order(1)
    public void add() {
        arrayList.add(10);
        arrayList.add(15);
        arrayList.add(20);

        assertThat(arrayList.get(0)).isEqualTo(10);
        assertThat(arrayList.get(1)).isEqualTo(15);
        assertThat(arrayList.get(2)).isEqualTo(20);
    }

    @Test
    @Order(7)
    public void sizeOfEmptyArrayWrapper() {
        assertThat(arrayList.size()).isEqualTo(0);
    }

    @Test
    @Order(4)
    void testSize() {
        arrayList.add(10);
        arrayList.add(15);
        arrayList.add(20);

        assertThat(arrayList.size()).isEqualTo(3);
    }


    @Test
    @Order(2)
    public void getElementsByIndex() {
        arrayList.add(10);
        arrayList.add(15);
        arrayList.add(20);

        assertThat(arrayList.get(0)).isEqualTo(10);
        assertThat(arrayList.get(1)).isEqualTo(15);
        assertThat(arrayList.get(2)).isEqualTo(20);
        assertThat(arrayList.size()).isEqualTo(3);
    }

    @Test
    @Order(5)
    void testGetFirstElement() {
        arrayList = ArrayList.of(31, 32);

        assertThat(arrayList.getFirst()).isEqualTo(31);

    }

    @Test
    @Order(6)
    void testGetLastElement() {
        arrayList = ArrayList.of(21, 34);

        assertThat(arrayList.getLast()).isEqualTo(34);
    }

    @Test
    @Order(7)
    void testGetFirstOfEmptyList() {
        assertThatExceptionOfType(NoSuchElementException.class)
                .isThrownBy(() -> arrayList.getFirst());
    }

    @Test
    @Order(8)
    void testGetLastOfEmptyList() {
        assertThatExceptionOfType(NoSuchElementException.class)
                .isThrownBy(() -> arrayList.getLast());
    }

    @Test
    @Order(4)
    public void createListWithSpecificCapacity() {
        arrayList = new ArrayList<>(8);

        arrayList.add(10);
        arrayList.add(15);
        arrayList.add(20);

        assertThat(arrayList.get(0)).isEqualTo(10);
        assertThat(arrayList.get(1)).isEqualTo(15);
        assertThat(arrayList.get(2)).isEqualTo(20);
    }

    @Test
    @Order(5)
    public void createListWithWrongCapacity() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> arrayList = new ArrayList<>(-2));
    }

    @Test
    @Order(6)
    public void addElements() {
        arrayList = ArrayList.of(15, 69, 58, 78);

        assertThat(arrayList.get(0)).isEqualTo(15);
        assertThat(arrayList.get(1)).isEqualTo(69);
        assertThat(arrayList.get(2)).isEqualTo(58);
        assertThat(arrayList.get(3)).isEqualTo(78);
        assertThat(arrayList.size()).isEqualTo(4);
    }

    @Test
    @Order(8)
    public void resizeDefaultCapacity() {
        arrayList = new ArrayList<>();

        arrayList.add(15);
        arrayList.add(69);
        arrayList.add(58);
        arrayList.add(78);
        arrayList.add(6);
        arrayList.add(33);
        arrayList.add(21);

        assertThat(arrayList.get(6)).isEqualTo(21);
        assertThat(arrayList.size()).isEqualTo(7);
    }

    @Test
    @Order(9)
    public void resizeSpecificCapacity() {
        arrayList = new ArrayList<>(4);

        arrayList.add(15);
        arrayList.add(69);
        arrayList.add(58);
        arrayList.add(78);
        arrayList.add(6);
        arrayList.add(33);
        arrayList.add(21);

        assertThat(arrayList.get(6)).isEqualTo(21);
        assertThat(arrayList.size()).isEqualTo(7);
    }

    @Test
    @Order(10)
    public void addElementByIndex() {
        arrayList = ArrayList.of(15, 69, 58, 78, 68);

        arrayList.add(50);
        arrayList.add(2, 10);

        assertThat(arrayList.get(2)).isEqualTo(10);
        assertThat(arrayList.get(5)).isEqualTo(68);
        assertThat(arrayList.size()).isEqualTo(7);
    }

    @Test
    @Order(14)
    void testAddElementByNegativeIndex() {
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> arrayList.add(-1, 66));

    }

    @Test
    @Order(15)
    void testAddElementByIndexLargerThanListSize() {
        arrayList = ArrayList.of(4, 6, 11, 9);

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> arrayList.add(5, 88));
    }

    @Test
    @Order(16)
    void testAddElementByIndexEqualToSize() {
        arrayList = ArrayList.of(1, 2, 3, 4, 5); // size = 5

        arrayList.add(5, 111);

        assertThat(arrayList.get(5)).isEqualTo(111);
        assertThat(arrayList.size()).isEqualTo(6);
    }

    @Test
    @Order(11)
    public void getFirstElementFromEmptyList() {
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> arrayList.get(0));
    }

    @Test
    @Order(12)
    public void getElementByNegativeIndex() {
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> arrayList.get(-1));
    }

    @Test
    @Order(13)
    public void getElementByIndexEqualToListSize() {
        arrayList = ArrayList.of(15, 69, 58, 78);

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> arrayList.get(4));
    }

    @Test
    @Order(14)
    public void setElementByIndex() {
        arrayList = ArrayList.of(15, 69, 58, 78);

        arrayList.set(2, 10);

        assertThat(arrayList.get(2)).isEqualTo(10);
        assertThat(arrayList.get(3)).isEqualTo(78);
        assertThat(arrayList.size()).isEqualTo(4);
    }

    @Test
    @Order(15)
    public void setElementByIndexEqualToSize() {
        arrayList = ArrayList.of(15, 69, 58, 78);

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> arrayList.set(4, 10));
    }

    @Test
    @Order(17)
    void testSetFirstElementOnEmptyTree() {
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> arrayList.set(0, 34));
    }

    @Test
    @Order(16)
    public void removeElementByIndex() {
        arrayList = ArrayList.of(15, 69, 58, 78, 100);

        arrayList.remove(2);

        assertThat(arrayList.get(2)).isEqualTo(78);
        assertThat(arrayList.get(1)).isEqualTo(69);
        assertThat(arrayList.size()).isEqualTo(4);
    }

    @Test
    @Order(17)
    public void removeElementByIndexEqualToSize() {
        arrayList = ArrayList.of(15, 69, 58, 78);

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> arrayList.remove(4));
    }

    @Test
    @Order(18)
    public void removeLastElementByIndex() {
        arrayList = ArrayList.of(15, 69, 58, 78, 100);

        arrayList.remove(4);

        assertThat(arrayList.get(3)).isEqualTo(78);
        assertThat(arrayList.size()).isEqualTo(4);
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> arrayList.get(4));
    }

    @Test
    @Order(19)
    public void removeElementByIndexOutOfBounds() {
        arrayList = ArrayList.of(15, 69, 58, 78, 100);

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> arrayList.remove(6));
    }

    @Test
    @Order(27)
    void testContainsOnEmptyList() {
        assertThat(arrayList.contains(8)).isEqualTo(false);
    }

    @Test
    @Order(20)
    public void containsElement() {
        arrayList = ArrayList.of(15, 69, 58, 78, 100);

        assertThat(arrayList.contains(58)).isEqualTo(true);
    }

    @Test
    @Order(21)
    public void findNotExistingElement() {
        arrayList = ArrayList.of(15, 69, 58, 78, 100);

        assertThat(arrayList.contains(200)).isEqualTo(false);
    }

    @Test
    @Order(29)
    void testIsEmptyOnEmptyList() {
        assertThat(arrayList.isEmpty()).isEqualTo(true);
    }

    @Test
    @Order(30)
    void testIsEmpty() {
        arrayList = ArrayList.of(34, 5, 6);

        assertThat(arrayList.isEmpty()).isEqualTo(false);
    }

    @Test
    @Order(32)
    void testClearOnEmptyList() {
        assertThat(arrayList.isEmpty()).isEqualTo(true);
    }

    @Test
    @Order(33)
    void testClearChangesTheSize() {
        arrayList = ArrayList.of(4, 5, 6);

        arrayList.clear();

        assertThat(arrayList.size()).isEqualTo(0);
    }

    @Test
    @Order(34)
    void testClearRemovesElements() {
        arrayList = ArrayList.of(4, 5, 6);

        arrayList.clear();

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> arrayList.get(0));
    }
}
