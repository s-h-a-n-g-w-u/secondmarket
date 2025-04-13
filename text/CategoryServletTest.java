import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import top.example.domain.Category;
import top.example.service.CategoryService;
import top.example.web.servlet.BaseBackServlet;
import top.example.web.servlet.CategoryServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class CategoryServletTest {

    @InjectMocks
    private CategoryServlet categoryServlet;

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private CategoryService categoryService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAdd() throws Exception {
        // Arrange
        String categoryName = "New Category";
       when(request.getParameter("name")).thenReturn(categoryName);

        // Act
        String result = categoryServlet.add(request, response, null); // PageBean is not used in the method

        // Assert
        verify(categoryService, times(1)).addCategory(any(Category.class)); // 验证 categoryService.addCategory 被调用了一次
        ArgumentCaptor<Category> argumentCaptor = ArgumentCaptor.forClass(Category.class); // 显式声明泛型类型
        verify(categoryService).addCategory(argumentCaptor.capture());

        // 验证传入的 Category 对象是否正确
        Category capturedCategory = argumentCaptor.getValue();
        assertEquals(categoryName, capturedCategory.getName(), "Category name should match the parameter");

        // 验证返回值
        assertEquals("@admin-category-list", result, "Return value should be correct");
    }
}
