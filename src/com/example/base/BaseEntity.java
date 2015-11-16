package com.example.base;

import java.io.Serializable;

/**
 * 实体类-基类
 * @author xingyatong
 *
 */
public class BaseEntity implements Serializable{
	private static final long serialVersionUID = 4995176180527325406L;
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
