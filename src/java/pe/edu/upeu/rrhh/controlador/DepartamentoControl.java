/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.rrhh.controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pe.edu.upeu.rrhh.dao.DepartamentoDAO;
import pe.edu.upeu.rrhh.interfaces.InterfaceDepartamento;
import pe.edu.upeu.rrhh.modelo.Departamento;

/**
 *
 * @author DavidReyna
 */
public class DepartamentoControl extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    

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
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        InterfaceDepartamento aO = new DepartamentoDAO();
        Departamento dep = new Departamento();
        HttpSession session = request.getSession(true);
        RequestDispatcher dispatcher; String pagina;
        String op = request.getParameter("op"); int id;
        switch(Integer.parseInt(op)){
            case 1: pagina = "/vista/dpto/listardpto.jsp";
                    session.setAttribute("list1", aO.list());
                    dispatcher = getServletContext().getRequestDispatcher(pagina);
                    dispatcher.forward(request, response);
            case 2: pagina = "/vista/dpto/ingresardpto.jsp";
                    //session.setAttribute("list", aO.list());
                    dispatcher = getServletContext().getRequestDispatcher(pagina);
                    dispatcher.forward(request, response);
            case 3: pagina = "/vista/dpto/modificardpto.jsp";
                    id = Integer.parseInt(request.getParameter("id"));
                    session.setAttribute("list2", aO.list(id));
                    dispatcher = getServletContext().getRequestDispatcher(pagina);
                    dispatcher.forward(request, response);
            case 4: pagina = "/dpto?op=1";
                    dep.setIddpto(Integer.parseInt(request.getParameter("id")));
                    dep.setDpto(request.getParameter("depar"));
                    dep.setCostos(Integer.parseInt(request.getParameter("costos")));
                    dep.setStatus(Integer.parseInt(request.getParameter("status")));
                    if(aO.edit(dep)){
                    dispatcher = getServletContext().getRequestDispatcher(pagina);
                    dispatcher.forward(request, response);
                    }else{
                        out.println("<h3>Error al modificar registro..!!</h3>");
                    }
            case 5: pagina = "/dpto?op=1";
                    dep.setDpto(request.getParameter("depar"));
                    dep.setCostos(Integer.parseInt(request.getParameter("costos")));
                    dep.setStatus(Integer.parseInt(request.getParameter("status")));
                    if(aO.save(dep)){
                    dispatcher = getServletContext().getRequestDispatcher(pagina);
                    dispatcher.forward(request, response);
                    }else{
                        out.println("<h3>Error AL guardar registro..!!</h3>");
                    }
            case 6: pagina = "/dpto?op=1";
                    id = Integer.parseInt(request.getParameter("id"));
                    if(aO.delete(id)){
                    dispatcher = getServletContext().getRequestDispatcher(pagina);
                    dispatcher.forward(request, response);
                    }else{
                        out.println("<h3>Error al eliminar registro..!!</h3>");
                    }    
        }
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
