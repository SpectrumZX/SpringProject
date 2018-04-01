package com.platform.controller;

import com.platform.db.dao.PostDAO;
import com.platform.db.dao.UserDAO;
import com.platform.db.entity.PostEntity;
import com.platform.db.entity.UserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;


@RestController
@RequestMapping("/manage")
public class PostController {

    private static final Logger logger = LoggerFactory.getLogger(PostController.class);

    @CrossOrigin(origins = "*")
    @GetMapping(value = "/posts")
    @ResponseBody
    public ResponseEntity allPosts() {
        List<PostEntity> postList = PostDAO.findAll();
        return new ResponseEntity(postList, HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @GetMapping(value = "/posts/{post_id}")
    @ResponseBody
    public ResponseEntity getPostById(@PathVariable("post_id") Integer post_id) {
        PostEntity post = PostDAO.findById(post_id);
        if (post == null) return new ResponseEntity("post not found", HttpStatus.NOT_FOUND);
        return new ResponseEntity(post, HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @PostMapping(value = "/posts")
    @ResponseBody
    public ResponseEntity addPost(@RequestBody PostEntity jsonPost) {
        Calendar calendar = Calendar.getInstance();
        java.util.Date date = new java.util.Date();
        java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(date.getTime());
        jsonPost.setDateCreated(currentTimestamp);
        PostDAO.add(jsonPost);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping(value = "/posts/{post_id}")
    @ResponseBody
    public ResponseEntity deletePostById(@PathVariable("post_id") Integer post_id) {
        PostEntity post = PostDAO.findById(post_id);
        if (post==null)
            if (PostDAO.remove(post)) return new ResponseEntity("Post was deleted. id" + post.getId(), HttpStatus.OK);

        logger.warn(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
        return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);

    }
}
