
public class StringListImpl implements StringList{

    String[] StringList = new String[8];

    @Override
    public String add(String item) {
        for (int i = 0; i < StringList.length; i++) {
            if (StringList[i].isEmpty()) {
                StringList[i] = item;
            }
        }
        return item;
    }

    @Override
    public String add(int index, String item) {

        return null;
    }

    @Override
    public String set(int index, String item) {
        if (index > StringList.length-1){   //Проверить фактическое количество элементов!
            throw new RuntimeException("Index is out of bounds");
        }
       return StringList[index] = item;
    }

    @Override
    public String remove(String item) {
        return null;
    }

    @Override
    public String remove(int index) {
        return null;
    }

    @Override
    public boolean contains(String item) {
        return false;
    }

    @Override
    public int indexOf(String item) {
        return 0;
    }

    @Override
    public int lastIndexOf(String item) {
        return 0;
    }

    @Override
    public String get(int index) {
        return null;
    }

    @Override
    public boolean equals(StringList otherList) {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public String[] toArray() {
        return new String[0];
    }
}
