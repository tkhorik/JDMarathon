import javaAdvanced.mycontsctsbook.dao.IDAOContact;
import javaAdvanced.mycontsctsbook.model.Contact;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
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

        List<Contact> contactList = getContacts(response);

        // create HTML form
        PrintWriter writer = response.getWriter();
        writer.append("<!DOCTYPE html>\r\n")
                .append("<html>\r\n")
                .append("		<head>\r\n")
                .append("    <meta charset=\"utf-8\">\n" +
                        "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n" +
                        "\n" +
                        "    <!-- Bootstrap CSS -->\n" +
                        "    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\" integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">\n")
                .append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">")
                .append("			<title>Form input</title>\r\n")
                .append("		</head>\r\n")
                .append("		<body>\r\n")
                .append("<h2>My Contact Address Book страница номер раз</h2>")
                .append("<select name=\"whatActionToDo\">\n" +
                        "\t<option value=\"tech\">Add new contact</option>\n" +
                        "\t<option value=\"admin\">Find contact</option>\n" +
                        "\t<option value=\"biology\">Edit contact</option>\n" +
                        "\t<option value=\"biology\">Show all contacts</option>\n" +
                        "</select> ")
                .append("<select name=\"showContactListOrNot\">\n" +
                        "\t<option value=\"tech\">Show all contact list</option>\n" +
                        "\t<option value=\"biology\">Do not show contact list</option>\n" +
                        "</select> ")
                .append("<hr>")
                .append("			<form action=\"phonebook\" method=\"POST\" acceptcharset=\"UTF-8\">\r\n")
                .append("				Enter your name and push the button: \r\n")
                .append("				<input type=\"text\" name=\"user\" />\r\n")
                .append("				<input type=\"text\" name=\"contactNumber\" />\r\n")
                .append("				<input type=\"text\" name=\"name\" />\r\n")
                .append("				<input type=\"text\" name=\"surname\" />\r\n")
                .append("				<input type=\"text\" name=\"phoneNumber\" />\r\n")
                .append("				<input type=\"submit\" value=\"Submit\" />\r\n")
                .append("			</form>\r\n")
                .append("<span>")
                .append("<hr>")
                .append("		</div>\r\n")
                .append("<div style=\"background-color:E2E2E2\">");
        for (Contact contact : contactList) {
            writer.append("<div>").append(contact.toString()).append("		</div>\r\n");
        }
        writer.append("		</div>\r\n");
        writer.append("</html>\r\n");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String user = request.getParameter("user");
        String contactNumber = request.getParameter("contactNumber");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String phoneNumber = request.getParameter("phoneNumber");

        Contact contact1 = new Contact(contactNumber, name, surname, phoneNumber);
        try {
            daoDBimpl.addContact(contact1);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        List<Contact> contactList = getContacts(response);

        // create HTML response
        response.sendRedirect("/");
        PrintWriter writer = response.getWriter();
        writer.append("<!DOCTYPE html>\r\n")
                .append("<html>\r\n")
                .append("		<head>\r\n")
                .append("<META http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">")
                .append("			<title>Welcome message</title>\r\n")
                .append("		</head>\r\n")
                .append("		<body>\r\n");

        if (user != null && !user.trim().isEmpty()) {
            writer.append("	Welcome " + user + ".\r\n");
            writer.append("	You successfully redirected.\r\n")
                    .append("<h2>My Contact Address Book Results</h2>");

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

    private List<Contact> getContacts(HttpServletResponse response) {
        List<Contact> contactList = null;
        contactList = getContacts(contactList);


        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        return contactList;
    }

    private List<Contact> getContacts(List<Contact> contactList) {
        try {
            contactList = daoDBimpl.getAllStoredContacts();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contactList;
    }

}