import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //post方式需要设置编码，防止中文乱码
        request.setCharacterEncoding("UTF-8");

        String fruitName = request.getParameter("fruitName");
        String priceStr = request.getParameter("fruitPrice");
        Integer fruitAmount = Integer.parseInt(request.getParameter("fruitAmount"));
        System.out.println("fruitName:"+fruitName+" price:"+priceStr+" amount:"+fruitAmount);
    }
}
