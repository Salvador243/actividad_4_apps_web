package test;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.ThreadLocalRandom;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author salva
 */
public class server extends HttpServlet {

    Contador contador = new Contador();
    int partidas = 1;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet server</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet server at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

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
        int cliente = Integer.parseInt(request.getParameter("tiro"));

        String[] opciones = {"piedra", "papel", "tijera"};
        PrintWriter out = response.getWriter();
        ThreadLocalRandom tlr = ThreadLocalRandom.current();
        int randomNum = tlr.nextInt(1, 3 + 1);
        String random = opciones[randomNum - 1];
        int server = (randomNum);

        if (partidas <= 5) {
            try {
                if (cliente == server) {
                    contador.setEmpatadas((contador.getEmpatadas() + 1));
                    contador.setJugada_cliente(random);
                    contador.setJugada_servidor(random);
                    contador.setGanador("Empate");
                    request.setAttribute("empates", (contador.getEmpatadas()));
                    request.setAttribute("cliente", (random));
                    request.setAttribute("servidor", (random));
                    request.setAttribute("ganada_ser", (contador.getJugadas_ganadas_servidor()));
                    request.setAttribute("ganada_cli", (contador.getJugadas_ganadas_cliente()));
                    request.setAttribute("ganadas", "Empate");
                } else {
                    if (server == 1 & cliente == 3) {
                        int ganadas_S = (contador.getJugadas_ganadas_servidor() + 1);
                        contador.setJugadas_ganadas_servidor(ganadas_S);
                        contador.setJugada_cliente("tijera");
                        contador.setJugada_servidor(random);
                        contador.setGanador("Servidor");
                        request.setAttribute("empates", (contador.getEmpatadas()));
                        request.setAttribute("cliente", ("tijera"));
                        request.setAttribute("servidor", (random));
                        request.setAttribute("ganada_ser", (ganadas_S));
                        request.setAttribute("ganada_cli", (contador.getJugadas_ganadas_cliente()));
                        request.setAttribute("ganadas", "Servidor");
                    } else if (server == 1 & cliente == 2) {
                        contador.setJugadas_ganadas_cliente(contador.getJugadas_ganadas_cliente() + 1);
                        contador.setJugada_cliente("papel");
                        contador.setJugada_servidor(random);
                        contador.setGanador("Cliente");
                        request.setAttribute("empates", (contador.getEmpatadas()));
                        request.setAttribute("cliente", ("papel"));
                        request.setAttribute("servidor", (random));
                        request.setAttribute("ganada_ser", (contador.getJugadas_ganadas_servidor()));
                        request.setAttribute("ganada_cli", (contador.getJugadas_ganadas_cliente()));
                        request.setAttribute("ganadas", "Cliente");
                    } else if (server == 3 & cliente == 2) {
                        contador.setJugadas_ganadas_servidor(contador.getJugadas_ganadas_servidor() + 1);
                        contador.setJugada_cliente("papel");
                        contador.setJugada_servidor(random);
                        contador.setGanador("Servidor");
                        request.setAttribute("empates", (contador.getEmpatadas()));
                        request.setAttribute("cliente", ("papel"));
                        request.setAttribute("servidor", (random));
                        request.setAttribute("ganada_ser", (contador.getJugadas_ganadas_servidor()));
                        request.setAttribute("ganada_cli", (contador.getJugadas_ganadas_cliente()));
                        request.setAttribute("ganadas", "Servidor");
                    }
                }
                partidas++;
                request.setAttribute("win_server", contador.getWin_server());
                request.setAttribute("win_cliente", contador.getWin_client());
                request.setAttribute("win_empate", contador.getWin_empate());
                RequestDispatcher view = getServletContext().getRequestDispatcher("/home");
                view.forward(request, response);

            } catch (Exception e) {
                out.print("<html>"
                        + "<h3>  " + e + "</h3>"
                        + "</html>");
            }
        } else {

            int win_server = contador.getJugadas_ganadas_servidor();
            int win_client = contador.getJugadas_ganadas_cliente();

            if (win_server > win_client) {
                contador.setWin_server(contador.getWin_server() + 1);
                request.setAttribute("win_server", contador.getWin_server());
            } else if (win_client > win_server) {
                contador.setWin_server(contador.getWin_client() + 1);
                request.setAttribute("win_cliente", contador.getWin_client());
            } else {
                contador.setWin_empate(contador.getWin_empate() + 1);
                request.setAttribute("win_empate", contador.getWin_empate());
            }

            partidas = 1;

            contador.setCliente_ganadas(0);
            contador.setEmpatadas(0);
            contador.setJugadas_ganadas_cliente(0);
            contador.setJugadas_ganadas_servidor(0);
            contador.setServidor_ganadas(0);
            //metodo que reinicie todo
            RequestDispatcher view = getServletContext().getRequestDispatcher("/home");
            view.forward(request, response);
        }

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
