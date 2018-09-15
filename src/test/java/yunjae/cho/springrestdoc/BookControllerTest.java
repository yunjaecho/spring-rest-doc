package yunjae.cho.springrestdoc;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.restdocs.JUnitRestDocumentation;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@RunWith(SpringRunner.class)
@SpringBootTest
public class BookControllerTest {

    //@Autowired
    MockMvc mockMvc;

    @Autowired
    WebApplicationContext webApplicationContext;


    @Rule
    public JUnitRestDocumentation restDocumentation = new JUnitRestDocumentation();

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                .apply(documentationConfiguration(restDocumentation))
                .build();
        /*this.mockMvc = MockMvcBuilders.standaloneSetup(BookController.class)
                .apply(documentationConfiguration(restDocumentation))
                .build();*/
    }



    @Test
    public void getAllBook() throws Exception {
        mockMvc.perform(get("/books"))
            .andExpect(status().isOk())
            .andDo(document("allBook"))
        ;
    }

    @Test
    public void getBook() throws Exception {
        mockMvc.perform(get("/book/1"))
                .andExpect(status().isOk())
                .andDo(document("get-a-book"))
        ;
    }

}


