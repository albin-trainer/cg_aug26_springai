package com.cg;

import java.util.Collection;

public interface BookRepository {

    void save(Book book);

    Book findById(int bookId);

    Collection<Book> findAll();

    void delete(int bookId);

    boolean existsById(int bookId);
}
