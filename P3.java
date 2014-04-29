import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import javax.servlet.*;
import javax.servlet.http.*;
import beans.*;
import packages.*;

public class P3 extends HttpServlet {
	
	TvmlReader TvGuide;

    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException
    {
    	TvGuide = new TvmlReader();
    	TvGuide.Read();

        ServletContext sc = getServletContext();
        RequestDispatcher rd = sc.getRequestDispatcher("/Home.jsp");
        rd.forward(request,response);

    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response)
    	    throws IOException, ServletException
    {
    	String step = request.getParameter("step");
    	response.setContentType("text/html");
        PrintWriter out = response.getWriter();

    	if(step.equals("1")){
    		String query = request.getParameter("query");
    		if(query.equals("movies")){
                daysBean bean = new daysBean();
                bean.setDays(TvGuide.getDays());
                request.setAttribute("daysBean", bean);

                ServletContext sc = getServletContext();
                RequestDispatcher rd = sc.getRequestDispatcher("/Films1.jsp");
                rd.forward(request,response);
    		}
    		else if(query.equals("shows")){
    			out.println("<html><head><title>Servicio TV</title>");
   		     	out.println("</head><body>");
   		     	out.println("<h1>Servicio de consulta de la programaci&oacute;n</h1>");
   		     	out.println("<h2>shows</h2>");
   		     	out.println("<h3>Selecciona un idioma:</h3>");
   		     	out.println("<form method='POST' action='?step=2'>");
   		     	out.println("<input type='hidden' name='query' value='shows'>");
                List<String> languages = TvGuide.getLanguages();
                ListIterator<String> it = languages.listIterator();
                for(int ii=0; ii<languages.size(); ii++){
                    String language = it.next();
   		     		out.println("<input type='radio' name='language' value='" + language + "' > " + language + "<BR>");
   		     	}
   		     	out.println("<input type='radio' name='language' value='all' checked> Todos<BR>");
   		     	out.println("<p><input type='submit' value='Enviar'>");
   		     	out.println("<input type='submit' value='Atr&aacute;s' onClick='document.forms[0].method=\"GET\"'>");
   		     	out.println("</form>");
   		     	out.println("</body></html>");
    		}
    		else {
    			//do 404
    		}
    	}
    	else if(step.equals("2")){
    		String query = request.getParameter("query");

    		if(query.equals("movies")){
    			String day = request.getParameter("day");

                channelsBean bean = new channelsBean();
                bean.setChannels(TvGuide.getChannels(day));
                bean.setDay(day);
                request.setAttribute("channelsBean", bean);

                ServletContext sc = getServletContext();
                RequestDispatcher rd = sc.getRequestDispatcher("/Films2.jsp");
                rd.forward(request,response);
    		}
    		else if(query.equals("shows")){
    			String language = request.getParameter("language");
    			
    			out.println("<h1>Servicio de consulta de la programaci&oacute;n</h1>");
    		    out.println("<h2>Idioma:" + language + "</h2>");
    		    out.println("<h3>Selecciona un d&iacute;a:</h3>");
    		    out.println("<form method='POST' action='?step=3'>");
    		    out.println("<input type='hidden' name='query' value='shows'>");
    		    out.println("<input type='hidden' name='language' value='" + language + "'>");
                List<String> days = TvGuide.getDays();
                ListIterator<String> it = days.listIterator();
                for(int ii=0; ii<days.size(); ii++){
                    String day = it.next();
                    if(ii==days.size()-1){
                        out.println("<input type='radio' name='day' value='" + day + "' checked> " + day + "<BR>");
                    }
                    else{
                        out.println("<input type='radio' name='day' value='" + day + "' > " + day + "<BR>");
                    }
                }
    		    out.println("<p><input type='submit' value='Enviar'>");
    		    out.println("<input type='submit' value='Atr&aacute;s' onClick='document.forms[0].action=\"?step=1\"'>");
    		    out.println("<input type='submit' value='Inicio' onClick='document.forms[0].method=\"GET\"'>");
    		    out.println("</form>");
    		    out.println("</body></html>");
    		}
    		else {
    			//do 404
    		}
    	}
    	else if(step.equals("3")){
    		String query = request.getParameter("query");

    		if(query.equals("movies")){
    			String day = request.getParameter("day");
    			String channel = request.getParameter("channel");

                filmsBean bean = new filmsBean();
                bean.setFilms((FimlPkg)TvGuide.getFilms(day, channel));
                bean.setDay(day);
                bean.setChannel(channel);
                request.setAttribute("filmsBean", bean);

                ServletContext sc = getServletContext();
                RequestDispatcher rd = sc.getRequestDispatcher("/Films3.jsp");
                rd.forward(request,response);
    		}
    		else if(query.equals("shows")){
    			String day = request.getParameter("day");
    			String language = request.getParameter("language");
    			
    			out.println("<h1>Servicio de consulta de la programaci&oacute;n</h1>");
    		    out.println("<h2>Idioma: " + language + ", d&iacute;a: " + day + "</h2>");
    		    out.println("<h3>Selecciona un canal:</h3>");
    		    out.println("<form method='POST' action='?step=4'>");
    		    out.println("<input type='hidden' name='query' value='shows'>");
    		    out.println("<input type='hidden' name='language' value='" + language + "'>");
    		    out.println("<input type='hidden' name='day' value='" + day + "'>");
    		    List<String> channels = TvGuide.getChannels(day, language);
    		    ListIterator<String> it = channels.listIterator();
   		     	for(int ii=0; ii<channels.size(); ii++){
   		     		String channel = it.next();
   		     		out.println("<input type='radio' name='channel' value='" + channel + "' > " + channel + "<BR>");
   		     		if(ii==channels.size()-1){
   		     			out.println("<input type='radio' name='channel' value='all' checked> Todos<BR>");
   		     		}
   		     	}
    		    out.println("<p><input type='submit' value='Enviar'>");
    		    out.println("<input type='submit' value='Atr&aacute;s' onClick='document.forms[0].action=\"?step=2\"'>");
    		    out.println("<input type='submit' value='Inicio' onClick='document.forms[0].method=\"GET\"'>");
    		    out.println("</form>");
    		    out.println("</body></html>");
    		}
    		else {
    			//do 404
    		}
    	}
    	else if(step.equals("4")){
    		String query = request.getParameter("query");
    		
    		if(query.equals("shows")){
    			String day = request.getParameter("day");
    			String language = request.getParameter("language");
    			String channel = request.getParameter("channel");
    			
    			out.println("<h1>Servicio de consulta de la programaci&oacute;n</h1>");
    		    out.println("<h2>Idioma: " + language + ", d&iacute;a: " + day + " , canal: " + channel + "</h2>");
    		    out.println("<h3><h3>Estos son los programas:</h3></h3>");
    		    out.println("<ul>");
    		    List<ShowPkg> shows = TvGuide.getShows(day, channel, language);
   		     	ListIterator<ShowPkg> it = shows.listIterator();
   		     	for(int ii=0; ii<shows.size(); ii++){
   		     		ShowPkg show = it.next();
   		     		out.println(" <li>" + show.name + " a las " + show.time + "<BR>");
   		     		out.println("edad m&iacute;nima " + show.age + " años. <P>");
   		     	}
    		    out.println("</ul>");
    		    out.println("<form method='POST'>");
    		    out.println("<input type='hidden' name='query' value='shows'>");
    		    out.println("<input type='hidden' name='language' value='" + language + "'>");
    		    out.println("<input type='hidden' name='day' value='" + day + "'>");
    		    out.println("<input type='submit' value='Atr&aacute;s' onClick='document.forms[0].action=\"?step=3\"'>");
    		    out.println("<input type='submit' value='Inicio' onClick='document.forms[0].method=\"GET\"'>");
    		    out.println("</form>");
    		    out.println("</body></html>");
    		}
    		else {
    			//do 404
    		}
    	}
    }
}
