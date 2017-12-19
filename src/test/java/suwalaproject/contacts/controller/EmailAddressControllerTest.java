package suwalaproject.contacts.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import suwalaproject.contacts.controllers.EmailAddressController;
import suwalaproject.contacts.entities.EmailAddress;
import suwalaproject.contacts.services.EmailAddressService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = EmailAddressController.class, secure = false)
public class EmailAddressControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmailAddressService emailAddressService;

    EmailAddress mockEmailAddress = new EmailAddress("test@test.pl");

    String exampleEmailAddressJson = "{\"id\":1\",\"emailAddress\":\"pkowalski@email.pl\"}";

    @Test
    public void findEmailAddressById() throws Exception {
        Mockito.when(emailAddressService.findEmailAddressById(Mockito.anyLong())).thenReturn(mockEmailAddress);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("contacts/emailAddress/findEmailAddressById/1").accept(MediaType.APPLICATION_JSON);

        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();

        String expected = "{id:1,emailAddress:test@test.pl}";

        JSONAssert.assertEquals(expected, mvcResult.getResponse().getContentAsString(), false);
    }
}
