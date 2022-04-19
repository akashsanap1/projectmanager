package com.projectmanager.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Documents {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int documentId;
	private String fileName;
	private String fileType;
	@Lob
	private byte[] data;
	public int getDocumentId() {
		return documentId;
	}
	public void setDocumentId(int documentId) {
		this.documentId = documentId;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public byte[] getData() {
		return data;
	}
	public void setData(byte[] data) {
		this.data = data;
	}
	public Documents(int documentId, String fileName, String fileType, byte[] data) {
		super();
		this.documentId = documentId;
		this.fileName = fileName;
		this.fileType = fileType;
		this.data = data;
	}
	public Documents() {
		super();
	}
	public Documents(String fileName, String fileType, byte[] data) {
		super();
		this.fileName = fileName;
		this.fileType = fileType;
		this.data = data;
	}
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
