package top.xiaoming.demo.springbootdemo;

import org.junit.Before;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.Resource;

public class MockMvcTests extends ApplicationTests {
    @Resource
    private WebApplicationContext ctx;

    protected MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.ctx).build();
    }
}
