package com.cg;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class BookRepoImpl implements BookRepository {
  private Map<Integer, Book> bookMap = new HashMap<>();
    @Override
    public void save(Book book) {
       
    }

    @Override
    public Book findById(int bookId) {
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public Collection<Book> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public void delete(int bookId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public boolean existsById(int bookId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'existsById'");
    }
}
    