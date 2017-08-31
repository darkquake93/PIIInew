<%@page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="guest.*"%>

<jsp:useBean id="guestDao" type="guest.GuestDao" scope="request" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <title>JPA Guestbook Web Application Tutorial</title>
    </head>

    <body>
        <form method="POST" action="guest.html">
            <table>
                <tr>
                    <th> Guest name </th>
                    <th> Room No' </th>
                </tr>
                <tr>
                    <td> <input type="text" name="name" /> </td>
                    <td> <input type="text" name="roomno" /> </td>
                    <td> <input type="submit" value="Submit" /> </td>
                </tr>
            </table>
            
        </form>

        <hr><ol> 
            <% for (Guest guest : guestDao.getAllGuests()) {%>
            <li> <%= guest%> </li>
                <% } %>
        </ol><hr>
        <p>
        <% out.println("Total number of guests: " + guestDao.getCount()); %>
        </p>

    </body>
</html>