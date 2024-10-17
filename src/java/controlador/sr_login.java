/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import modelo.Usuario;

@WebServlet("/sr_login")
public class sr_login extends HttpServlet {

    Usuario usuario;
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try { 
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            usuario = new Usuario(username,password);

            String[] respuesta = usuario.Login();

            if(respuesta[0] != null)
            {
                // Guardar el ID del usuario y el rol en la sesión
                HttpSession session = request.getSession();
                session.setAttribute("userId", respuesta[0]);
                session.setAttribute("userIdPuesto", respuesta[1]);

                // Redirigir al usuario a la página de bienvenida o dashboard
                response.sendRedirect("master.jsp");
            }
            else
            {
                response.sendRedirect("index.jsp?error=1");
            }
        }
        catch(Exception e){
            System.out.println(e);
            response.sendRedirect("index.jsp?error=2");
        }
    }
}
