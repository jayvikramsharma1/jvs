package uk.co.news.methode.servlets;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.eidosmedia.wa.util.EomDb;

import EOM.EventAdmin;
import EOM.EventAdminHelper;
import EOM.File;
import EOM.FileHelper;
import EOM.ObjectAdmin;
import EOM.ObjectAdminHelper;
import uk.co.news.methode.util.BrightcoveMethodeImportUtil;

public class BrightcoveMethodeImportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Logger logger = Logger.getLogger(BrightcoveMethodeImportServlet.class);
	public BrightcoveMethodeImportServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		File videoFile = null;
		File imageFile = null;
		EomDb db = BrightcoveMethodeImportUtil.getEmoDb(request, response);

		try {
			String enc = BrightcoveMethodeImportUtil.getEncoding(request);
			String objLoid = request.getParameter("eomid");
			String brightCoveId = URLDecoder.decode(request.getParameter("brightCoveId"), enc);
			videoFile = FileHelper.narrow(db.getFileSystemAdmin().get_object_with_uri("eom:/loids/" + objLoid));
			
			imageFile = writeImageIntoFile(db, videoFile, imageFile, brightCoveId, request);
			if(imageFile != null){
				witeVideoContentMetadataIntoFile(db, videoFile, imageFile, brightCoveId, request, response);
				String systemAttributes = videoFile.get_system_attributes();
				
				logger.debug("------------------------------------------------------------------------------------------------------------------------------------------------------ \n"+systemAttributes);
				/*<props><title>4. Reasons to Love Sundays_V2</title><summary/></props>*/
			}
			else 
				response.getWriter().write("Error In Writing Video Metadata Content");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected File writeImageIntoFile(EomDb db, File videoFile, File imageFile, String brightCoveId, HttpServletRequest request) {
		try {
			String imagePath = BrightcoveMethodeImportUtil.getImagePath(videoFile);
			imageFile = FileHelper.narrow(db.getFileSystemAdmin().create_object_with_uri(
					imagePath + brightCoveId + "_" + System.currentTimeMillis() + ".jpg?locked"));
			imageFile.write_all(BrightcoveMethodeImportUtil.getImageByteArray(request));
			String workflow = "PictureFlow";
			String step = "Raw";
			try {
				String statusName = workflow + "/" + step;
				ObjectAdmin oa = ObjectAdminHelper.narrow(db.getSession().resolve_initial_references("ObjectAdmin"));
				oa.set_status_name(imageFile, statusName);
				if (logger.isDebugEnabled()) {
					logger.debug("Object: " + imageFile.get_loid_string() + ", new status: " + statusName);
				}
				EventAdmin ea = EventAdminHelper.narrow(db.getSession().resolve_initial_references("EventAdmin"));
				ea.fire_event(imageFile, "set_status");
				if (logger.isDebugEnabled()) {
					logger.debug("Object: " + imageFile.get_loid_string() + ", fired set_status event");
				}

			} catch (Exception e1) {
				logger.error("Failed forceing transiction on object " + imageFile.get_loid_string() + " workflow "
						+ workflow + " step " + step, e1);
			}
			return imageFile;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (imageFile != null)
					imageFile.unlock();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return imageFile;
	}
	
	protected void witeVideoContentMetadataIntoFile(EomDb db, File videoFile, File imageFile, String brightCoveId, HttpServletRequest request, HttpServletResponse response) {
		try {
			try {
				videoFile.lock();
			} catch (Exception e) {
				//e.printStackTrace();
			}
			logger.debug(BrightcoveMethodeImportUtil
					.getFormatedBrightcoveMetadataXml(request, response, imageFile).getBytes());
			videoFile.write_all(BrightcoveMethodeImportUtil
					.getFormatedBrightcoveMetadataXml(request, response, imageFile).getBytes());
			String embargoedFlag = URLDecoder.decode(request.getParameter("embargoedFlag"), BrightcoveMethodeImportUtil.getEncoding(request));
			String flightTimeString = URLDecoder.decode(request.getParameter("flightTimeString"), BrightcoveMethodeImportUtil.getEncoding(request));
			logger.debug("brightcove embargoed video flag " + embargoedFlag);
			String competitionId = URLDecoder.decode(request.getParameter("competitionId"), BrightcoveMethodeImportUtil.getEncoding(request));
			videoFile.set_attributes(BrightcoveMethodeImportUtil.getVideoMetadata(brightCoveId, embargoedFlag, flightTimeString, competitionId));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (videoFile != null)
					videoFile.unlock();
				response.getWriter().write(" ");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
