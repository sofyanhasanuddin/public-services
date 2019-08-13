package org.sofyan.myktm.ktmctrl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc(secure = false)
public class MainCtrlTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void findNearestKtmStationTest() throws Exception {

        String content = mvc.perform(get("/api/find-ktm-nearest-station/3.0860/101.6619"))
                .andExpect(status().isOk())
                //.andDo(MockMvcResultHandlers.print())
                .andReturn().getResponse().getContentAsString();

        System.out.println("Content : " + content);

    }

    @Test
    public void getKtmRouteTest() throws Exception {

        String content = mvc.perform(get("/api/find-ktm-route"))
                .andExpect(status().isOk())
                //.andDo(MockMvcResultHandlers.print())
                .andReturn().getResponse().getContentAsString();

        System.out.println("Content : " + content);

    }

    @Test
    public void getKtmStationByRouteTest() throws Exception {

        String content = mvc.perform(get("/api/find-ktm-station-by-route/TANJUNG MALIM - PELABUHAN KLANG"))
                .andExpect(status().isOk())
                //.andDo(MockMvcResultHandlers.print())
                .andReturn().getResponse().getContentAsString();

        System.out.println("Content : " + content);

    }


}
