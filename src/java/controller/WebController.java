/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Book;
import entity.History;
import entity.Reader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import session.BookFacade;
import session.HistoryFacade;
import session.ReaderFacade;

/**
 *
 * @author User
 */
@WebServlet(name = "WebController", urlPatterns = {
    "/showAddBook",
    "/createBook",
    "/listBooks",
    "/createReader",
    "/showAddReader",
    "/listReaders",
    "/showHistory",
    "/createHistory",
    "/listHistory",})
public class WebController extends HttpServlet {

    @EJB
    BookFacade bookFacade;
    @EJB
    ReaderFacade readerFacade;
    @EJB
    HistoryFacade historyFacade;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        String path = request.getServletPath();
        String name = request.getParameter("name");
        String author = request.getParameter("author");
        String isbn = request.getParameter("isbn");
        String publishedYear = request.getParameter("publishedYear");
        String quantity = request.getParameter("quantity");
        String nameR = request.getParameter("name");
        String surname = request.getParameter("surname");
        String phone = request.getParameter("phone");

        switch (path) {
            case "/showAddBook":
                request.getRequestDispatcher("/showAddBook.jsp").forward(request, response);
                break;
            case "/createBook":
                Book book = new Book(name, author, isbn, new Integer(publishedYear), new Integer(quantity), new Integer(quantity));
                bookFacade.create(book);
                request.getRequestDispatcher("/index.jsp").forward(request, response);
                break;
            case "/listBooks":
                List<Book> listBooks = bookFacade.findAll();
                request.setAttribute("listBooks", listBooks);
                request.getRequestDispatcher("/listBooks.jsp").forward(request, response);
                break;
            case "/createReader":
                Reader reader = new Reader(nameR, surname, phone);
                readerFacade.create(reader);
                request.getRequestDispatcher("/index.jsp").forward(request, response);
                break;
            case "/showAddReader":
                request.getRequestDispatcher("/showAddReader.jsp").forward(request, response);
                break;
            case "/listReaders":
                List<Reader> listReaders = readerFacade.findAll();
                request.setAttribute("listReaders", listReaders);
                request.getRequestDispatcher("/listReaders.jsp").forward(request, response);
                break;
            case "/createHistory":
                String id = request.getParameter("id");
                Reader reader1 = new Reader(nameR, surname, phone);
                Book book1 = new Book(name, author, isbn, new Integer(publishedYear), new Integer(quantity), new Integer(quantity));
                String dateTakeBook = request.getParameter("dateTakeBook");
                String dateReturnBook = request.getParameter("dateReturnBook");
                History history = new History(new Long(id), reader1, book1, new Date(dateTakeBook), new Date(dateReturnBook));
                break;
            case "/showHistory":
                request.getRequestDispatcher("/showHistory.jsp").forward(request, response);
                break;
            case "/listHistory":
                List<History> listHistory = historyFacade.findAll();
                request.setAttribute("listHistory", listHistory);
                request.getRequestDispatcher("/listHistory.jsp").forward(request, response);
                break;

        }
        // try (PrintWriter out = response.getWriter()) {
        /* TODO output your page here. You may use following sample code. */
 /* out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet WebController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet WebController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");*/
        // }
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
