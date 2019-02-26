package ua.boring.project.service.impl

import org.assertj.core.api.Assertions
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import ua.boring.project.config.BaseTestConfig
import ua.boring.project.data.dto.PaymentDto
import ua.boring.project.data.entity.User
import ua.boring.project.data.repository.PaymentRepo
import ua.boring.project.data.repository.UserRepo

class PaymentServiceImplTest extends BaseTestConfig {

    @Mock
    private PaymentServiceImpl paymentService

    @Mock
    private PaymentRepo paymentRepo

    @Mock
    private UserRepo userRepo

    @Before
    void setUp() throws Exception {
        MockitoAnnotations.initMocks(this)
        paymentService = new PaymentServiceImpl(paymentRepo, userRepo)
    }

    @Test
    void testSuccessMakePayment() {
        User user = new User().with { res ->
            id = 2

            return res
        }

        PaymentDto paymentDto = new PaymentDto().with { result ->
            cost = 123
            paymentDescription = "Test"
            userId

            return result
        }


        Assertions.assertThat(paymentService.makePayment(user, paymentDto)).isEqualTo(0)
    }

    @Test
    void testFailedMakePayment() {
        User user = null

        PaymentDto paymentDto = new PaymentDto().with { result ->
            cost = 123
            paymentDescription = "Test"
            userId

            return result
        }

        Assertions.assertThat(paymentService.makePayment(user, paymentDto)).isEqualTo(-1)
    }

    @Test
    void testSuccessGetPayment() {

    }

}