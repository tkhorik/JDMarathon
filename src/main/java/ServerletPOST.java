import javaAdvanced.mycontsctsbook.dao.IDAOContact;
import javaAdvanced.mycontsctsbook.model.Contact;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServerletPOST extends HttpServlet {
    private static final long serialVersionUID = -1641096228274971485L;

    private ApplicationContext context;
    private IDAOContact idaoContact;
    private IDAOContact daoDBimpl;

    public void init(ServletConfig servletConfig) throws ServletException {
        super.init(servletConfig);
        context = new ClassPathXmlApplicationContext("context.xml");
        daoDBimpl = (IDAOContact) context.getBean("myDbMethodsRealization");
        idaoContact = (IDAOContact) context.getBean("myPersonalBean");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Contact> contactList = null;
        try {
            contactList = daoDBimpl.getAllStoredContacts();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // set response headers
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        // create HTML form
        PrintWriter writer = response.getWriter();
        writer.append("<!DOCTYPE html>\r\n")
                .append("<html>\r\n")
                .append("		<head>\r\n")
                .append("			<title>Form input</title>\r\n")
                .append("		</head>\r\n")
                .append("		<body>\r\n")
                .append("			<form action=\"welcome\" method=\"POST\">\r\n")
                .append("				Enter your name and push the button: \r\n")
                .append("				<input type=\"text\" name=\"user\" />\r\n")
                .append("				<input type=\"text\" name=\"contactNumber\" />\r\n")
                .append("				<input type=\"text\" name=\"name\" />\r\n")
                .append("				<input type=\"text\" name=\"surname\" />\r\n")
                .append("				<input type=\"text\" name=\"phoneNumber\" />\r\n")
                .append("				<input type=\"submit\" value=\"Submit\" />\r\n")
                .append("			</form>\r\n")
                .append("		<div>\r\n");
        for (Contact contact : contactList) {
            writer.append("<div>" + contact + "		</div>\r\n");
        }
        writer.append("		<div>\r\n");
        writer.append("</html>\r\n");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String user = request.getParameter("user");
        List<Contact> contactList = null;
        try {
            contactList = daoDBimpl.getAllStoredContacts();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        // create HTML response
        PrintWriter writer = response.getWriter();
        writer.append("<!DOCTYPE html>\r\n")
                .append("<html>\r\n")
                .append("		<head>\r\n")
                .append("			<title>Welcome message</title>\r\n")
                .append("		</head>\r\n")
                .append("		<body>\r\n");
        if (user != null && !user.trim().isEmpty()) {
            writer.append("	Welcome " + user + ".\r\n");
            writer.append("	You successfully redirected.\r\n");

        } else {
            writer.append("	You did not entered a name!\r\n");
        }
        writer.append("		</body>\r\n")
                .append("		<div>\r\n");
        for (Contact contact : contactList) {
            writer.append("<div>" + contact + "		</div>\r\n");
        }
        writer.append("		<div>\r\n");
        writer.append("</html>\r\n");
    }

}