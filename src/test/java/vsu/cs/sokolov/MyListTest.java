package vsu.cs.sokolov;


import org.junit.Assert;
import org.junit.Test;

public class MyListTest {

    @Test
    public void writeAndReadingTest() {
        MyList<Integer> list = new MyList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        StringBuilder testString = new StringBuilder();

        for (int i = 0; i < list.getLength(); i++) {
            testString.append(list.getElem(i));
        }

        String expected = "12345";

        Assert.assertEquals(expected, testString.toString());

    }

    @Test
    public void removeTest() {
        MyList<Integer> list = new MyList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        list.replace(1);
        list.replace(1);

        String expected = "145";

        StringBuilder testString = new StringBuilder();

        for (int i = 0; i < list.getLength(); i++) {
            testString.append(list.getElem(i));
        }

        Assert.assertEquals(expected, testString.toString());

        list = new MyList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        list.replace(0);
        list.replace(0);

        expected = "345";

        testString = new StringBuilder();

        for (int i = 0; i < list.getLength(); i++) {
            testString.append(list.getElem(i));
        }

        Assert.assertEquals(expected, testString.toString());

        list = new MyList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        list.replace(3);
        list.replace(3);

        expected = "123";

        testString = new StringBuilder();

        for (int i = 0; i < list.getLength(); i++) {
            testString.append(list.getElem(i));
        }

        Assert.assertEquals(expected, testString.toString());

    }
}