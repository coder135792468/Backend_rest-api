package com.note_share_res_api.backend_rest_api.modesl;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Library {

	public Library() {

	}

	@Id
	@GeneratedValue
	private Integer id;
	private String semester;

	private String title;
	private String course;
	private String college;
	private String items;
	private String date;
	public Integer views;

	String note;

	public Library(Integer id, String semester) {
		super();
		this.id = id;
		this.semester = semester;
		this.views = 0;

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public void setNote(String note) {
		this.note = note;
	};

	public String getNote() {
		return this.note;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getItems() {
		return items;
	}

	public void setItems(String items) {
		this.items = items;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public void setViews(Integer views) {
		this.views = views;
	};

	public Integer getViews() {
		return views;
	}

}
