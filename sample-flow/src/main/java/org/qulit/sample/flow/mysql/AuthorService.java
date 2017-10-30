package org.qulit.sample.flow.mysql;

import java.util.List;

public interface AuthorService {

    int add(Author author);

    int update(Author author);

    int delete(Long id);

    Author findAuthor(Long id);

    List<Author> findAuthorList();
}
