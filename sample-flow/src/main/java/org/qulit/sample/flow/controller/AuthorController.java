package org.qulit.sample.flow.controller;


import org.mybatis.spring.annotation.MapperScan;
import org.qulit.sample.flow.entity.Author;
import org.qulit.sample.flow.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController("mybatis.authorController")
@RequestMapping(value = "/data/mybatis/author")
@MapperScan("com.lianggzone.springboot.action.data.mybatis.dao")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    /**
     * 查询用户列表
     */
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public Map<String, Object> getAuthorList() {
        System.out.println("author find all");
        List<Author> authorList = this.authorService.findAll();
        Map<String, Object> param = new HashMap<>();
        param.put("total", authorList.size());
        param.put("rows", authorList);
        return param;
    }

    /**
     * 查询用户信息
     */
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public String getAuthor(@RequestParam("userId") Long userId) {
        System.out.println("author find userId = " + userId);
        Author author = this.authorService.findById(userId);

        if (author == null) {
            return "Not Found";
        }
        return "realName : " + author.getRealName() + ", nickName : " + author.getNickName();
    }

    /**
     * 新增方法
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void add(@RequestParam(value = "realName") String realName,
                    @RequestParam(value = "nickName") String nickName) {
        System.out.println("add author realName = " + realName + ", nickName = " + nickName);
        Author author = new Author();
        author.setRealName(realName);
        author.setNickName(nickName);
        try {
            this.authorService.add(author.getRealName(), author.getNickName());
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("新增错误");
        }
    }

    /**
     * 更新方法
     */
    @RequestMapping(value = "/update/{userId:\\d+}", method = RequestMethod.PUT)
    public void update(@PathVariable Long userId,
                       @RequestParam(value = "realName") String realName,
                       @RequestParam(value = "nickName") String nickName) {

        System.out.println("update author userId = " + userId
                + ", realName = " + realName + ", nickName = " + nickName);

        Author author = this.authorService.findById(userId);
        author.setRealName(realName);
        author.setNickName(nickName);
        try {
            this.authorService.update(author.getId(), author.getRealName(), author.getNickName());
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("更新错误");
        }
    }

    /**
     * 删除方法
     */
    @RequestMapping(value = "/del/{userId:\\d+}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long userId) {
        System.out.println("delete author userId = " + userId);
        try {
            this.authorService.delete(userId);
        } catch (Exception e) {
            throw new RuntimeException("删除错误");
        }
    }


}
