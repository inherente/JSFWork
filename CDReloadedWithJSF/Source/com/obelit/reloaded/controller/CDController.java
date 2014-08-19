package com.obelit.reloaded.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.servlet.ServletContext;

import com.obelit.cc.model.EntityFactory;
import com.obelit.cc.model.WorkingDocument;
import com.obelit.db.pool.Reusable;
import com.obelit.db.pool.ReusablePool;
import com.sun.istack.internal.logging.Logger;
import com.inherente.pool.db.SimpleConnectionPool;
import com.inherente.reloaded.bean.ReportHeader;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@ManagedBean(name = "controlla")
@RequestScoped
public class CDController {
	public static final String LABEL_NAME= "reporte";
	ReusablePool pool;
	Reusable conn;
	private ReportHeader reportHeader;
	WorkingDocument docDAO;
	private List<HashMap<String,String>> document;
	private List<String> gottenDocuments;
	private List<String> columnReport;
	File file;
	String path ;
	ServletContext context;
	private static Logger log =Logger.getLogger(CDController.class);
	public CDController() {
		pool = new SimpleConnectionPool(1, "connection.properties");// pool = new SimpleConnectionPool().createInstance(SimpleConnectionPool.DEFAULT_IMPLEMENTATION, "\\connection.properties");
		conn= pool.acquireReusable();
		docDAO= EntityFactory.createDocumentInstance();
		reportHeader = getReportHeader();
		columnReport = getColumnReport();
		file = new File("user.txt");
		try {
			file.createNewFile();
			log.info(file.getCanonicalPath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public List<HashMap<String,String>> getDocument() {
		document = docDAO.getDocument(pool.acquireReusable().instance());

		return document;
	}

	public void setDocument(List<HashMap<String,String>> document) {
		this.document = document;
	}

	public List<String> getGottenDocuments() {
		gottenDocuments = docDAO.getXMLDocument(conn.instance());
		return gottenDocuments;
	}

	public void setGottenDocuments(List<String> gottenDocuments) {
		this.gottenDocuments = gottenDocuments;
	}

	public void setReportHeader(ReportHeader reportHeader) {
		this.reportHeader = reportHeader;
	}

	public ReportHeader getReportHeader() {
		HashMap<String,String> header ;
		
		if (reportHeader == null ) {
			reportHeader =new ReportHeader();
			header = docDAO.getReportHeader(conn.instance(), LABEL_NAME);
			reportHeader.setDisplayName(header.get(WorkingDocument.DISPLAY_NAME_COLUMN_NAME));
			reportHeader.setGridObjectName(header.get(WorkingDocument.NAME_COLUMN_NAME));
			reportHeader.setHandlerName(header.get(WorkingDocument.HANDLER_COLUMN_NAME));
			reportHeader.setSkin(header.get(WorkingDocument.LAYOUT_COLUMN_NAME));

		}
 
		return reportHeader;
	}

	public List<String> getColumnReport() {
		if (columnReport == null) {
			columnReport = docDAO.getReportColumnDetail(conn.instance(), LABEL_NAME);
		}
		return columnReport;
	}

	public void setColumnReport(List<String> columnReport) {
		this.columnReport = columnReport;
	}

}
