import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Aakanksha
 */
public class register extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            // Using HTTP Sessions
            String u =(String)request.getParameter("username");
            String p =(String)request.getParameter("password");
            
            HttpSession session=request.getSession();
            session.setAttribute("user", u); 
            session.setAttribute("pass", p);

            if (u.equals("admin") && p.equals("123")){ 
                response.sendRedirect("Homepg");
            }
            else{
                response.sendRedirect("index.html");
            }
            
            /*
            
            Using Forward Method -
            
            String u =(String) request.getParameter("username");
            String p =(String) request.getParameter("password"); 
            if (u.equals("admin") && p.equals("123")){ 
                RequestDispatcher rd= request.getRequestDispatcher("Homepg");
                rd.forward(request, response);
            }
            else{
                out.print("Invalid username or password");
                RequestDispatcher rd = request.getRequestDispatcher("index.html");
                rd.include(request, response);
            } 
            */
            /* 
            
            Using Redirect method -
            
            String u =(String) request.getParameter("username");
            String p =(String) request.getParameter("password"); 
            if (u.equals("admin") && p.equals("123")){ 
                response.sendRedirect("Homepg?username="+u);
            }
            else{
                out.print("<html><body>Invalid username or password </body></html>");
            } 
            */
            
            /*
            Using cookies
            
            String u =(String) request.getParameter("username");
            String e =(String) request.getParameter("email");
            out.print("<br><br>Hey, Welcome "+u+"!");
            out.print("<form action='Homepg'><br>");
            out.print("&nbsp;&nbsp;<input type='submit' value='Get Your Email ID'>");
            out.print("</form>");
            
            Cookie c= new Cookie("email", e);
            response.addCookie(c);
            
            */
            
                                 
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
