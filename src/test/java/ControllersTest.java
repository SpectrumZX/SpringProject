import com.platform.db.dao.UserDAO;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebAppConfiguration
@ContextConfiguration("classpath:ApiDispatcher-servlet.xml")
public class ControllersTest {

    @Autowired
    WebApplicationContext ctx;

   @Test
    public void testUserAPI() throws Exception{

       Integer TEST_USER_ID;
       String TEST_USER_NAME = "TestUser";

       MockMvc mvc = MockMvcBuilders
                .webAppContextSetup(ctx)
                //.apply(springSecurity())
                .build();

       mvc.perform(get("/manage/users/")
               .accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
               .andExpect(status().isOk())
               .andExpect(content().contentType("application/json;charset=UTF-8"))
               .andExpect(jsonPath("$", Matchers.hasSize(Matchers.greaterThan(2))))
               .andExpect(jsonPath("$[0].id").exists())
               .andExpect(jsonPath("$[0].userName").exists())
               .andExpect(jsonPath("$[0].accessLevel").exists())
               .andExpect(jsonPath("$[0].password").exists())
               .andExpect(jsonPath("$[0].token").exists());


       mvc.perform(post("/manage/users/")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \"userName\": \""+TEST_USER_NAME+"\",\n" +
                        "    \"accessLevel\": \"GUEST\",\n" +
                        "    \"password\": \"mypass000\",\n" +
                        "    \"token\": \"hash0384053\",\n" +
                        "    \"email\": \"mail@mma.ru\"\n" +
                        "}"))
                .andExpect(status().isOk());

        TEST_USER_ID = UserDAO.findByName(TEST_USER_NAME).getId();

        mvc.perform(put("/manage/users/")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \"id\": \"" + TEST_USER_ID + "\",\n" +
                        "    \"userName\": \""+TEST_USER_NAME+"\",\n" +
                        "    \"accessLevel\": \"GUEST\",\n" +
                        "    \"password\": \"mypass222\",\n" +
                        "    \"token\": \"hash1111111\",\n" +
                        "    \"email\": \"mail1@mma1.ru\"\n" +
                        "}"))
                .andExpect(status().isOk());


        mvc.perform(get("/manage/users/"+TEST_USER_ID)
                .accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
               .andExpect(status().isOk())
               .andExpect(content().contentType("application/json;charset=UTF-8"))
               .andExpect(jsonPath("$.id").value(TEST_USER_ID));

       mvc.perform(delete("/manage/users/"+TEST_USER_ID)
               .accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
               .andExpect(status().isOk());

    }

}
