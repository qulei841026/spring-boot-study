package org.qulit.sample.flow.service;

import org.qulit.sample.flow.entity.Author;
import org.qulit.sample.flow.mapper.AuthorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorMapper authorMapper;

    public int add(String realName, String nickName) {
        return this.authorMapper.add(realName, nickName);
    }

    public int update(Long id, String realName, String nickName) {
        return this.authorMapper.update(id, realName, nickName);
    }

    public int delete(Long id) {
        return this.authorMapper.delete(id);
    }

    public Author findById(Long id) {
        return this.authorMapper.findById(id);
    }

    public List<Author> findAll() {
        return this.authorMapper.findAll();
    }
}
