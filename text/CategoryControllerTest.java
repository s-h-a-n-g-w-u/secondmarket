import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import top.example.domain.Category;
import top.example.domain.PageBean;
import top.example.service.CategoryService;
import top.example.web.servlet.BaseBackServlet;
import top.example.web.servlet.CategoryServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class CategoryControllerServletTest {

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
    void testUpdate() throws Exception {
        // Arrange
        int categoryId = 1;
        String categoryName = "Updated Category";
        when(request.getParameter("id")).thenReturn(String.valueOf(categoryId));
        when(request.getParameter("name")).thenReturn(categoryName);

        PageBean page = new PageBean();
        page.setStart(0);

        // Act
        String result = categoryServlet.update(request, response, page);

        // Assert
        verify(categoryService, times(1)).updateCategory(any(Category.class)); // 验证 categoryService.updateCategory 被调用了一次
        ArgumentCaptor<Category> argumentCaptor = ArgumentCaptor.forClass(Category.class); // 显式声明泛型类型
        verify(categoryService).updateCategory(argumentCaptor.capture());

        // 验证传入的 Category 对象是否正确
        Category capturedCategory = argumentCaptor.getValue();
        assertEquals(categoryId, capturedCategory.getId(), "Category ID should match the parameter");
        assertEquals(categoryName, capturedCategory.getName(), "Category name should match the parameter");

        // 验证返回值
        assertEquals("@admin-category-list?page.start=0", result, "Return value should be correct");
    }
}
