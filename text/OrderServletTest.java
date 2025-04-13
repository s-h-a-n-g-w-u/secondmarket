import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import top.example.dao.OrderDAO;
import top.example.domain.Order;
import top.example.service.OrderService;
import top.example.web.servlet.OrderServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class OrderServletTest {

    @InjectMocks
    private OrderServlet orderServlet;

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private OrderService orderService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testDelivery_Success() throws Exception {
        // Arrange
        int oid = 1;
        when(request.getParameter("oid")).thenReturn(String.valueOf(oid));

        Order mockOrder = new Order();
        mockOrder.setId(oid);
        mockOrder.setStatus(OrderDAO.waitDelivery); // 假设初始状态为待发货
        when(orderService.getOrderById(oid)).thenReturn(mockOrder);

        // Act
        String result = orderServlet.delivery(request, response, null);

        // Assert
        verify(orderService, times(1)).getOrderById(oid);
        verify(orderService, times(1)).updateOrder(any(Order.class));

        ArgumentCaptor<Order> orderCaptor = ArgumentCaptor.forClass(Order.class);
        verify(orderService).updateOrder(orderCaptor.capture());

        Order capturedOrder = orderCaptor.getValue();
        assertNotNull(capturedOrder);
        assertEquals(oid, capturedOrder.getId());
        assertNotNull(capturedOrder.getDeliveryDate()); // 验证发货日期是否被设置
        assertEquals(OrderDAO.waitConfirm, capturedOrder.getStatus()); // 验证状态是否被修改为待收货

        assertEquals("%success", result); // 验证返回值是否正确
    }

    @Test
    void testDelivery_Fail() throws Exception {
        // Arrange
        int oid = 1;
        when(request.getParameter("oid")).thenReturn(String.valueOf(oid));
        when(orderService.getOrderById(oid)).thenReturn(null); // 模拟订单不存在的情况

        // Act
        String result = orderServlet.delivery(request, response, null);

        // Assert
        verify(orderService, times(1)).getOrderById(oid);
        verify(orderService, never()).updateOrder(any(Order.class)); // 验证 updateOrder 未被调用

        assertEquals("%fail", result); // 验证返回值是否正确
    }
}
