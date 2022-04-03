package qa;

import java.util.*;

public class Book {

    String author;
    String text;

    public Book(String author, String text) {
        this.author = author;
        this.text = text;
    }

    public String doReadBook() {
        return "книга прочитана! от автота " + author + " с текстом " + text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(author, book.author) && Objects.equals(text, book.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, text);
    }

    public static void main(String[] args) {
        Book book = new Book("Лев Толстой", "Война и мир");
        Book idiot = new Book("Федор Достоевский", "Идиот");
        Book idiot2 = new Book("Федор Достоевский", "Идиот");
        Book idiot3 = new Book("Федор Достоевский", "Анна Каренина");
        Book master = new Book("Михаил Булгаков", "Мастер и Маргарита");
        book.doReadBook();
        idiot.doReadBook();

        System.out.println("Разные объекты" + (book == idiot));
        System.out.println("Одинаковые объекты" + (idiot2.equals(idiot)));// с помощью переопределения equals and hashcode сравниваются посимвольно строки


        Book[] library = new Book[5];//Массив
        //или Book[] library = new Book[] {book, idiot, idiot2, idiot3, master};
        library[0] = book;
        library[1] = idiot;
        library[2] = idiot2;
        library[3] = idiot3;
        library[4] = master;

        List<Book> liblist2 = new ArrayList<>();//Лист
        //или List<Book> liblist = List.of(book, idiot, idiot2, idiot3, master);
        liblist2.add(book);
        liblist2.add(idiot);
        liblist2.add(idiot2);
        liblist2.add(idiot3);
        liblist2.add(master);

        Set<Book> libSet = new HashSet<>();//Множество. Особенность - нельзя добавить одинаковые элементы
        //Set<Book> libSet = Set.of(book, idiot, idiot2, idiot3, master);
        libSet.add(book);
        libSet.add(idiot);
        libSet.add(idiot2);//Тут дубль программа упадёт
        libSet.add(idiot3);
        libSet.add(master);

        Map<Integer, Book> libMap1 = new HashMap<>();//Мап
//        Map<Integer, Book> libMap1 = Map.of(
//                1, book,
//                2, idiot,
//                3, idiot2,
//                4, idiot3,
//                5, master);
        libMap1.put(1, book);
        libMap1.put(2, idiot);
        libMap1.put(3, idiot2);
        libMap1.put(4, idiot3);
        libMap1.put(5, master);

        //или
        Map<Integer, Book> libMap2 = new HashMap<>() {{
            put(1, book);
            put(2, idiot);
            put(3, idiot2);
            put(4, idiot3);
            put(5, master);
        }};



        System.out.println("Длина массива" + library.length);


        //цикл while
        int index = 0;
//        while (index < library.length) {//Как только условие перестаёт действовать цикл заканчивается
//            System.out.println("книга" + library[index].doReadBook());
//            index++;
//        }


        //цикл do while
        do {//этот цикл использвется, если необходимо хотя бы одну итерацию совершить
            System.out.println("книга" + library[index].doReadBook());
            index++;
        } while (index < library.length);


        //цикл for
        for(int i = 0; i < library.length; i++) {
            System.out.println("книга" + library[i].doReadBook());
        }

        //цикл for each. Цикл будет работать, пока не закончатся элементы в массиве
        for(Book boook : library) {
            System.out.println("книга" + book.doReadBook());
        }

        //цикл for each c continue
        for(Book boook : library) {
            if(boook.author.contains("Достоевский"))
                continue;//Если есть автор Достоевский, то цикл не идёт в print, а продолжает двигаться по циклу
            System.out.println("книга" + boook.doReadBook());
        }

        //цикл for each c break
        Book desiredBook;

        for(Book boook : library) {
            if(boook.author.contains("Достоевский")) {
                desiredBook = boook;
                break;//Если есть desiredBook, то цикл заканчивается
            }
        }
    }
}
