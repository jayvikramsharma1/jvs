package uk.co.news.methode.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import uk.co.news.methode.dto.BrightcoveApiResponse;
import uk.co.news.methode.dto.BrightcoveVideoDatum;
import uk.co.news.methode.dto.BrightcoveVideoSourceData;
import uk.co.news.methode.taglibs.BrightcoveIsPaidVideoTaglib;
import uk.co.news.methode.util.BrightcoveUtils;

public class BrightcoveAPIServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Logger logger = Logger.getLogger(BrightcoveAPIServlet.class);

	public BrightcoveAPIServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		logger.debug("###" + request.getServletContext().getInitParameter("brightcove_video_limit_per_page"));
		response.setContentType("application/json");
		logger.debug(request.getParameter("videoSource"));
		if(request.getParameter("videoSource") !=null && request.getParameter("videoSource").equalsIgnoreCase("false")) {
			BrightcoveApiResponse api = (BrightcoveApiResponse) request.getServletContext().getAttribute("credentials");

			List<BrightcoveVideoDatum> brightcoveVideoMetadata = BrightcoveUtils.getVideos(api.getAccessToken(), api.getCmsURL(), request.getParameter("q"), request.getServletContext().getInitParameter("brightcove_video_limit_per_page"), request.getParameter("sort"), request.getParameter("exclusive"));
			response.getWriter().append(BrightcoveUtils.getJsonFromList(brightcoveVideoMetadata));
			response.setHeader("Cache-Control", "private, no-store, no-cache, must-revalidate");
			response.setHeader("Pragma", "no-cache");
		}
		else {
			BrightcoveApiResponse api = (BrightcoveApiResponse) request.getServletContext().getAttribute("credentials");
			logger.debug("#### Access Key : " + api.getAccessToken() + " CMS URL : " + api.getCmsURL() + " Request Param : " + request.getParameter("q"));
			List<BrightcoveVideoSourceData> brightcoveVideoSourceData = BrightcoveUtils.getVideoSource(
					BrightcoveUtils.getVideos(api.getAccessToken(), api.getCmsURL(), request.getParameter("q"), request.getServletContext().getInitParameter("brightcove_video_limit_per_page"), request.getParameter("sort"), request.getParameter("exclusive")),
					api.getAccessToken(), api.getCmsURL(), request.getParameter("flightTimeFlag"), request.getParameter("oldIEBrowserFlag"));
			System.out.println(brightcoveVideoSourceData);
			response.setHeader("Cache-Control", "private, no-store, no-cache, must-revalidate");
			response.setHeader("Pragma", "no-cache");
			response.getWriter().append(BrightcoveUtils.getJsonFromList(brightcoveVideoSourceData));
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
