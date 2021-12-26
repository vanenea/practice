package com.chen.work;

import java.util.ArrayList;
import java.util.List;

public class SecondList {
	private String id;
	private String title;
	private List<ThirdList> list = new ArrayList<ThirdList>();
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<ThirdList> getList() {
		return list;
	}
	public void setList(List<ThirdList> list) {
		this.list = list;
	}
	@Override
	public String toString() {
		return "SecondList [id=" + id + ", title=" + title + ", list=" + list + "]";
	}
	
	
}
