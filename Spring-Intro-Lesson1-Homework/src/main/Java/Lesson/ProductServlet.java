package Lesson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@WebServlet(name = "productServlet", value = "/product-servlet")
public class ProductServlet extends HttpServlet {
    private ArrayList<Product> products;


    @Override
    public void init() throws ServletException {
        products = new ArrayList<>(
                List.of(
                        new Product(142, "Orange", 1.3),
                        new Product(325, "Apple", 0.3),
                        new Product(668, "Milk", 1.8),
                        new Product(111, "Coffee", 1.0),
                        new Product(765, "Tea", 1.0),
                        new Product(617, "Potato", 1.3),
                        new Product(781, "Chips", 1.7),
                        new Product(488, "Water", 0.5),
                        new Product(972, "Chocolate", 1.2)
                ));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + "ProductCart:" + "</h1>");
        for (int i = 0; i <products.size(); i++) {
            Random random = new Random();
            int x = random.nextInt(8);
            out.println("<h2>" + products.get(x).toString() + "</h2>");
        }
        out.println("</body></html>");

    }
}

