package org.sofyan.myktm.ktmservice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.sofyan.myktm.integration.firebase.constant.FirebaseEndpointConstant;
import org.sofyan.myktm.integration.firebase.service.FirebaseServiceRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FirebaseIntegrationTest {

    @Autowired
    private FirebaseServiceRest firebaseServiceRestImpl;

    @Test
    public void testGet() {

        String jsonResp = this.firebaseServiceRestImpl.get(FirebaseEndpointConstant.KTM_GET_ALL);
        System.out.println( jsonResp );
        System.out.println( "Second Call ");
        jsonResp = this.firebaseServiceRestImpl.get(FirebaseEndpointConstant.KTM_GET_ALL);
        System.out.println( jsonResp );

    }



}
