package servlet;

import manager.ItemManager;
import model.Item;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;

@WebServlet(urlPatterns = "/addItem")
public class AddItemServlet extends HttpServlet {
    private ItemManager itemManager = new ItemManager();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        int price = Integer.parseInt(req.getParameter("price"));
        int categoryId = Integer.parseInt(req.getParameter("category_id"));
        String picUrl = req.getParameter("pic_url");
        int userId = Integer.parseInt(req.getParameter("user_id"));
        itemManager.add(Item.builder()
                .title(title)
                .price(price)
                .categoryID(categoryId)
                .pictureUrl(picUrl)
                .userId(userId)
                .build());
        resp.sendRedirect("/userHome");

    }

}
