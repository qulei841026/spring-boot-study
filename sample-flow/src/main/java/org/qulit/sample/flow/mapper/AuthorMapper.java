package org.qulit.sample.flow.mapper;

import org.apache.ibatis.annotations.*;
import org.qulit.sample.flow.entity.Author;

import java.util.List;

@Mapper
public interface AuthorMapper {

    @Insert("insert into t_author(real_name, nick_name) values(#{real_name}, #{nick_name})")
    int add(@Param("real_name") String realName, @Param("nick_name") String nickName);

    @Delete("delete from t_author where id = #{id}")
    int delete(Long id);

    @Update("update t_author set real_name = #{real_name}, nick_name = #{nick_name} where id = #{id}")
    int update(@Param("id") Long id, @Param("real_name") String real_name, @Param("nick_name") String nick_name);

    @Select("select id, real_name as realName, nick_name as nickName from t_author")
    List<Author> findAll();

    @Select("select id, real_name as realName, nick_name as nickName from t_author where id = #{id}")
    Author findById(@Param("id") Long id);

}
