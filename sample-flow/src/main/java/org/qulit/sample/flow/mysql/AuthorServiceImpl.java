package org.qulit.sample.flow.mysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("authorService")
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorDao authorDao;

    @Override
    public int add(Author author) {
        return authorDao.add(author);
    }

    @Override
    public int update(Author author) {
        return authorDao.update(author);
    }

    @Override
    public int delete(Long id) {
        return authorDao.delete(id);
    }

    @Override
    public Author findAuthor(Long id) {
        return authorDao.findAuthor(id);
    }

    @Override
    public List<Author> findAuthorList() {
        return authorDao.findAuthorList();
    }

}
