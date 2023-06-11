package com.codingapi.crankycode.domain;

import com.alibaba.fastjson.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class UserMockMvcTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void login() throws Exception {
        JSONObject json = new JSONObject();
        json.put("username","admin");
        json.put("password","123456");

        mockMvc.perform(post("/user/login")
                .content(json.toJSONString().getBytes())
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(result -> {
            String body = result.getResponse().getContentAsString();
            JSONObject jsonObject = JSONObject.parseObject(body);
            assertEquals(jsonObject.getString("errCode"),"login.error");
        }).andExpect(status().isOk());
    }
}
