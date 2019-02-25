package ua.boring.project.controller

import org.junit.Test
import org.junit.jupiter.api.Assertions
import org.springframework.http.MediaType
import org.springframework.security.test.context.support.WithMockUser
import org.springframework.test.web.servlet.MvcResult
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import ua.boring.project.config.AbstractControllerTest
import ua.boring.project.data.dto.PaymentDto


class PaymentControllerTest extends AbstractControllerTest {

    @Test
    @WithMockUser(username = "testUser", roles = ["USER", "ADMIN"])
    void makePaymentSuccesses() {
        String uri = "/payments/create"
        String inputJson = super.mapToJson(new PaymentDto().with { payment ->
            cost = 123.3
            paymentDescription = "Test payment"
            userId = 234

            return payment
        })

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                                                                .contentType(MediaType.APPLICATION_JSON_VALUE)
                                                                .content(inputJson)).andReturn()

        int status = mvcResult.getResponse().getStatus()

        Assertions.assertEquals(201, status)

        String content = mvcResult.getResponse().getContentAsString()

        Assertions.assertNotEquals("-1", content)
    }

}
