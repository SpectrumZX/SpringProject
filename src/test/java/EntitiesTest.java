import com.platform.db.dao.PostDAO;
import com.platform.db.dao.UserDAO;
import com.platform.db.entity.AccessLevel;
import com.platform.db.entity.PostEntity;
import com.platform.db.entity.UserEntity;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.Calendar;
import static org.junit.jupiter.api.Assertions.*;

public class EntitiesTest {

    static UserEntity user;
    static PostEntity post = new PostEntity();

    @BeforeAll
    static void prepareEntities(){

        java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());
        user = new UserEntity(
                "TestUser1092837465",
                AccessLevel.GUEST,
                "pass123",
                "h224Bdfdg34vdfnun54",
                currentTimestamp,
                "mail@mail.ru",
                currentTimestamp);

        post.setUserId(1);
        post.setTitle("CCC");
        post.setBody("tttest.<br/>test.<br/>TEST");

    }

    @Test
    void UserDAO() {
       assertNotNull(UserDAO.addUser(user));
       UserDAO.update(user);
    }

    @Test
    void PostDAO() {
        assertNotNull(PostDAO.add(post));
        post.setTitle("Post for a test");
        post.setBody("Text test text test.<br/>New item.<br/>End");
        PostDAO.update(post);
    }

    @AfterAll
    static void deleteUser() throws Exception {
        UserDAO.removeUser(user);
        PostDAO.remove(post);
    }
}
