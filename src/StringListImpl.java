import java.util.Arrays;

public class StringListImpl implements StringList{
    String[] stringList = {"","","","","","","","","","","","","","","",""};
    String[] shiftLeft(int index){
        for (int i = index; i < stringList.length; i++){
            stringList[i] = stringList[i+1];
            if (i == stringList.length - 2){
                stringList[i+1] = "";
                break;
            }
        }
        return stringList;
    }
    String[] shiftRight(int index){
        if (!stringList[stringList.length-1].isBlank()){
            throw new RuntimeException("Index is out of bounds");
        }
        for (int i = size(); i >= index ; i--){
            stringList[i+1] = stringList[i];
        }
        return stringList;
    }

    @Override
    public String add(String item) {
        if(size() == 0){
            return stringList[0] = item;
        }
        return stringList[(size()+1)] = item;
    }

    @Override
    public String add(int index, String item) {
        if (index > size() || index > stringList.length){
            throw new RuntimeException("Index is out of bounds");
        }
       shiftRight(index);
       return stringList[index] = item;
    }

    @Override
    public String set(int index, String item) {
        if (index > size() || index > stringList.length){
            throw new RuntimeException("Index is out of bounds");
        }
       return stringList[index] = item;
    }

    @Override
    public String remove(String item) {
        for (int i = 0; i < stringList.length; i++) {
            if (stringList[i].equals(item)) {
                shiftLeft(i);
                return item;
            }
        }
       throw new RuntimeException("Item not found");
    }

    @Override
    public String remove(int index) {
       String removedItem;
        if (!stringList[index].isBlank()){
            removedItem = stringList[index];
            shiftLeft(index);
        }else{
            throw new RuntimeException("Index not found");
        }
        return removedItem;
    }

    @Override
    public boolean contains(String item) {
        for (String s : stringList) {
            return s.equals(item);
        }
        return false;
    }

    @Override
    public int indexOf(String item) {
        for (int i = 0; i < stringList.length; i++) {
            if (stringList[i].equals(item)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        for (int i = stringList.length-1; i >= 0; i--) {
            if (stringList[i].equals(item)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
       if (index > size()) {
           throw new RuntimeException("Index is out of bounds");
       }
        return stringList[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        if (otherList.size() != size()) {
            return false;
        }
        for (int i = 0; i < stringList.length; i++) {
            if (!stringList[i].equals(otherList.get(i))){
                return false;
            }
        }
        return true;
    }

    @Override
    public int size() {
        int n = 0;
        for (String s : stringList) {
            if (!s.isBlank()) {
                n++;
            }
        }
        return n;
    }

    @Override
    public boolean isEmpty() {
        for (String s : stringList) {
            if (!s.isBlank()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void clear() {
        Arrays.fill(stringList, "");
    }

    @Override
    public String[] toArray() {
        String[] newArray = new String[size()];
        for (int i = 0; i < size(); i++) {
            newArray[i] = stringList[i];
        }
        return newArray;
    }
}
