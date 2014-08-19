package com.inherente.reloaded.core;

import java.io.File;// import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import com.obelit.cc.model.EntityFactory;
import com.obelit.cc.model.WorkingDocument;
import com.obelit.db.pool.Reusable;
import com.sun.istack.internal.logging.Logger;

public class ServletHandler {
	public static final String XML_HEADER ="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n";
	public static final String ROWS_OPEN_TAG ="<rows>\n";
	public static final String ROWS_CLOSE_TAG ="</rows>";
	public static final String ROW_OPEN_TAG ="<row>\n";
	public static final String ROW_CLOSE_TAG ="</row>";
	public static final String HEAD_OPEN_TAG ="<head>\n";
	public static final String HEAD_CLOSE_TAG ="</head>\n";
	public static final String FILE_NAME_KEY ="fileName";

	public static final String LABEL_NAME= "reporte";
	String path ;
	ServletContext context;
	WorkingDocument docDAO;
	List<String> columnReport;
	List<String> reportContent;
	Reusable conn;
	private static Logger log =Logger.getLogger(ServletHandler.class);
	public ServletHandler (Reusable con) {
		conn= con;
		
	}

	public Object getReportHeader() {
		return null;
	}

	public List<String> getColumnReport() {
		if (docDAO == null)
		docDAO= EntityFactory.createDocumentInstance();
		if (columnReport == null) {
			columnReport = docDAO.getReportColumnDetail(conn.instance(), LABEL_NAME);
		}
		return columnReport;
	}
	public List<String> getReportContent() {
		if (docDAO == null)
		docDAO= EntityFactory.createDocumentInstance();
		if (reportContent == null) {
			reportContent = docDAO.getXMLDocument(conn.instance());
		}
		return reportContent;
	}

	public HashMap<String,Object> handleRequest (HttpServletRequest request, ServletContext ctxt) {
		FileOutputStream fileStream;
		File file;
		String fileName = "";
		HashMap<String,Object> map;
		List<String> toWrite = null;
		List<String> row = null;
		toWrite= getColumnReport();
		row = getReportContent();
		String ip;
		context = ctxt;
        path = context.getRealPath(".");
        ip= request.getHeader("x-forwarded-for");// ip= request.getHeader("x-forwarded-for");
        if (ip == null || ip.length()< 1) ip= request.getRemoteHost();

        fileName =  ip.replace(":", ".") + ".xml";
        log.info(fileName);// fileName =  "filename.xml";
     // log.info(fileName);
        file = new File(path+ "/"+ fileName);

		try {
			file.createNewFile();
			fileStream= new FileOutputStream(file);
			fileStream.write(XML_HEADER.getBytes());
			fileStream.write(ROWS_OPEN_TAG.getBytes());
			fileStream.write(HEAD_OPEN_TAG.getBytes());
			for (String value: toWrite) {
				fileStream.write(value.getBytes());
			}
			fileStream.write(HEAD_CLOSE_TAG.getBytes());
			for (String value: row) {
				fileStream.write(value.getBytes());
			}
			fileStream.write(ROWS_CLOSE_TAG.getBytes());
			fileStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		map = new HashMap<String,Object> ();
		map.put(FILE_NAME_KEY, fileName);
		return map;
	}
}
