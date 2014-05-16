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
        List<String> errors = TvGuide.Read();

        errorBean bean = new errorBean();
        bean.setError(errors);
        request.setAttribute("errorBean", bean);

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
                languagesBean bean = new languagesBean();
                bean.setLanguages(TvGuide.getLanguages());
                request.setAttribute("languagesBean", bean);

                ServletContext sc = getServletContext();
                RequestDispatcher rd = sc.getRequestDispatcher("/Shows1.jsp");
                rd.forward(request,response);
    		}
            else if(query.equals("sports")){
                languagesBean bean = new languagesBean();
                bean.setLanguages(TvGuide.getLanguages());
                request.setAttribute("languagesBean", bean);

                ServletContext sc = getServletContext();
                RequestDispatcher rd = sc.getRequestDispatcher("/Sports1.jsp");
                rd.forward(request,response);
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

                daysBean bean = new daysBean();
                bean.setDays(TvGuide.getDays());
                bean.setLanguage(language);
                request.setAttribute("daysBean", bean);

                ServletContext sc = getServletContext();
                RequestDispatcher rd = sc.getRequestDispatcher("/Shows2.jsp");
                rd.forward(request,response);
    		}
            else if(query.equals("sports")){
                String language = request.getParameter("language");

                daysBean bean = new daysBean();
                bean.setDays(TvGuide.getDays());
                bean.setLanguage(language);
                request.setAttribute("daysBean", bean);

                ServletContext sc = getServletContext();
                RequestDispatcher rd = sc.getRequestDispatcher("/Sports2.jsp");
                rd.forward(request,response);
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

                showsBean bean = new showsBean();
                List<ShowPkg> films = TvGuide.getFilms(day, channel);
                bean.setShows(films);
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

                channelsBean bean = new channelsBean();
                bean.setChannels(TvGuide.getChannels(day));
                bean.setLanguage(language);
                bean.setDay(day);
                request.setAttribute("channelsBean", bean);

                ServletContext sc = getServletContext();
                RequestDispatcher rd = sc.getRequestDispatcher("/Shows3.jsp");
                rd.forward(request,response);
    		}
            else if(query.equals("sports")){
                String day = request.getParameter("day");
                String language = request.getParameter("language");

                showsBean bean = new showsBean();
                List<ShowPkg> sports = TvGuide.getSportShows(day, language);
                bean.setShows(sports);
                bean.setLanguage(language);
                bean.setDay(day);
                request.setAttribute("showsBean", bean);

                ServletContext sc = getServletContext();
                RequestDispatcher rd = sc.getRequestDispatcher("/Sports3.jsp");
                rd.forward(request,response);
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

                showsBean bean = new showsBean();
                List<ShowPkg> shows = TvGuide.getShows(day, channel, language);
                bean.setShows(shows);
                bean.setLanguage(language);
                bean.setDay(day);
                bean.setChannel(channel);
                request.setAttribute("showsBean", bean);

                ServletContext sc = getServletContext();
                RequestDispatcher rd = sc.getRequestDispatcher("/Shows4.jsp");
                rd.forward(request,response);
    		}
    		else {
    			//do 404
    		}
    	}
    }
}
