package com.springsecurity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springsecurity.entity.UserEntity;
import com.springsecurity.repository.UserRepository;
import com.springsecurity.service.UserServiceDB;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


@RunWith(SpringRunner.class)
@Configuration
@SpringBootTest
public class SpringSecurityMockitoTests {

    //private MockMvc mockMvc;

    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext webApplicationContext;
    @Autowired
    UserServiceDB userServiceDB;

    @MockBean
    UserRepository userRepository;
    @Autowired
    ObjectMapper mapper;

//    @Test
//    public void getUserTest(){
//        when(userRepository.findAll()).thenReturn(Stream
//                .of(new UserEntity(1l,"jyoti","98756","jyoti@123","NORMAL","jyoti@123","31"),
//                        new UserEntity(1l,"anurag","98756","anurag@123","NORMAL","anurag@123","34"),
//                        new UserEntity(1l,"veerawal","98756","veerawal@123","ADMIN","veerawal@123","37"))
//                        .collect(Collectors.toList()));
//        assertEquals(3,userServiceDB.getAllUsers().size());
//    }


    @Before
    public void setup(){
        mockMvc= MockMvcBuilders.webAppContextSetup(webApplicationContext).apply(springSecurity()).build();
    }

//    @WithMockUser("/kanishka")
//    @Test
//    public void testSaveUsers() throws Exception{
//        UserEntity user = UserEntity.builder().userName("abc").password("abc123").role("ROLE_NORMAL").build();
//        String jsonRequest = mapper.writeValueAsString(user);
//        MvcResult mvcResult = mockMvc.perform(post("/user/add").content(jsonRequest)
//                .contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andReturn();
//        assertEquals(200, mvcResult.getResponse().getStatus());
//    }

    @WithMockUser("/kanishka")
    @Test
    public void testGetUsers() throws Exception{
        MvcResult mvcResult = mockMvc.perform(get("/user/all").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn();
        assertEquals(200,mvcResult.getResponse().getStatus());
    }
}
