package top.xiaoming.demo.springbootdemo.domain.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.xiaoming.demo.springbootdemo.domain.entity.ExampleTb;
import top.xiaoming.demo.springbootdemo.domain.entity.ExampleTbExample;

@Mapper
public interface ExampleTbMapper {
    long countByExample(ExampleTbExample example);

    int deleteByExample(ExampleTbExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ExampleTb record);

    int insertSelective(ExampleTb record);

    List<ExampleTb> selectByExample(ExampleTbExample example);

    ExampleTb selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ExampleTb record, @Param("example") ExampleTbExample example);

    int updateByExample(@Param("record") ExampleTb record, @Param("example") ExampleTbExample example);

    int updateByPrimaryKeySelective(ExampleTb record);

    int updateByPrimaryKey(ExampleTb record);
}