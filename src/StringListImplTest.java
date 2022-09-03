import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

public class StringListImplTest {
    private final StringListImpl OUT = new StringListImpl();
    private final String[] EMPTY_LIST = {"","","","","","","","","","","","","","","",""};
    private final String[] TEST_LIST = {"ABC","123","DEF","456","GHI","789","","","","","","","","","",""};
    private final String[] TEST_LIST_1 = {"ABC","321","DEF","456","GHI","789","","","","","","","","","",""};
    private final String[] TEST_ADD_BY_INDEX = {"ABC","123","DEF","456","TEST PASSED","GHI","789","","","","","","","","",""};
    private final String[] LIST_SHIFTED_LEFT = {"ABC","123","DEF","456","789","","","","","","","","","","",""};
    private final String[] LIST_SHIFTED_RIGHT = {"ABC","123","DEF","456","GHI","GHI","789","","","","","","","","",""};
    private final String[] SET_VALUE_BY_INDEX = {"ABC","123","DEF","456","TEST PASSED","789","","","","","","","","","",""};
    private final int TEST_INDEX = 4;
    private final int OUT_OF_SIZE_INDEX = 8;
    private final int OUT_OF_BOUND_INDEX = 16;
    private final String TEST_STRING = "TEST PASSED";

    @BeforeEach
    public  void stringListIni(){
        OUT.stringList = TEST_LIST;
    }

    @Test
    public void shouldReturnlistShiftedLeft(){

        Assertions.assertArrayEquals(LIST_SHIFTED_LEFT,OUT.shiftLeft(TEST_INDEX));
    }
    @Test
    public void shouldReturnListShiftedRight(){
        Assertions.assertArrayEquals(LIST_SHIFTED_RIGHT,OUT.shiftRight(TEST_INDEX));
    }
    @Test
    public void shouldReturnListWithTESTonly(){
        OUT.stringList = EMPTY_LIST;
        OUT.add(TEST_STRING);
        Assertions.assertEquals(TEST_STRING, OUT.stringList[0]);
    }
    @Test
    public void addStringByIndexShouldAddOrThrowException(){
        OUT.add(TEST_INDEX,TEST_STRING);
        Assertions.assertArrayEquals(TEST_ADD_BY_INDEX, OUT.stringList);
        Assertions.assertThrows(RuntimeException.class,()->OUT.add(OUT_OF_BOUND_INDEX, TEST_STRING));
    }
    @Test
    public void setShouldReplaceValuebyIndexOrThrowException(){
        OUT.set(TEST_INDEX, TEST_STRING);
        Assertions.assertArrayEquals(SET_VALUE_BY_INDEX, OUT.stringList);
        Assertions.assertThrows(RuntimeException.class,()->OUT.set(OUT_OF_BOUND_INDEX,TEST_STRING));
        Assertions.assertThrows(RuntimeException.class,()-> OUT.set(OUT_OF_SIZE_INDEX, TEST_STRING));
    }
    @Test
    public void removeByIndexShoudRemoveOrThrowException(){
        OUT.remove(TEST_INDEX);
        Assertions.assertArrayEquals(LIST_SHIFTED_LEFT, OUT.stringList);
        Assertions.assertThrows(RuntimeException.class,()->OUT.remove(OUT_OF_SIZE_INDEX));
    }
    @Test
    public void removeByContentShouldRemoveOrThrowException(){
        OUT.stringList = SET_VALUE_BY_INDEX;
        OUT.remove(TEST_STRING);
        Assertions.assertArrayEquals(LIST_SHIFTED_LEFT, OUT.stringList);
        Assertions.assertThrows(RuntimeException.class,()->OUT.remove(TEST_STRING));
    }
    @Test
    public void equalsShouldCompareArraysOrThrowNPE(){
        Assertions.assertNotEquals(OUT, TEST_LIST_1);
        Assertions.assertNotEquals(OUT,TEST_ADD_BY_INDEX);
    }
}
