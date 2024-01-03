package hw10;

public interface CollectionNew {
    boolean add(String o);
    boolean add(int index, String o);
    boolean delete(String o);
    String get(int index);
    boolean contain(String o);
    boolean equals(CollectionNew collection);
    boolean clear();
    int size();
}
