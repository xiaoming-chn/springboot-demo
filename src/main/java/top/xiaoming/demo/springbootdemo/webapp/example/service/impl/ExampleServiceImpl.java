package top.xiaoming.demo.springbootdemo.webapp.example.service.impl;

import org.springframework.stereotype.Service;
import top.xiaoming.demo.springbootdemo.domain.dao.ExampleTbMapper;
import top.xiaoming.demo.springbootdemo.domain.entity.ExampleTb;
import top.xiaoming.demo.springbootdemo.domain.entity.ExampleTbExample;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ExampleServiceImpl {
    @Resource
    private ExampleTbMapper tbMapper;

    public ExampleTb getExampleTbById(int id) {
        return  tbMapper.selectByPrimaryKey(id);
    }

    public List<ExampleTb> getAllExampleTb() {
        return tbMapper.selectByExample(new ExampleTbExample());
    }

    public int insertExampleTb(ExampleTb... tbs) {
        int rowChange = 0;
        for (int i = 0; i < tbs.length; i++) {
            tbMapper.insertSelective(tbs[i]);
            rowChange++;
        }
        return rowChange;
    }

    public int deleteExampleTbById(int... ids) {
        int rowChange = 0;
        for (int i = 0; i < ids.length; i++) {
            tbMapper.deleteByPrimaryKey(ids[i]);
            rowChange++;
        }
        return rowChange;
    }

}
