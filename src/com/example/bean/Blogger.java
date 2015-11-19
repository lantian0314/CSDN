package com.example.bean;

import com.example.base.BaseEntity;

public class Blogger extends BaseEntity{

	private static final long serialVersionUID = 6569781303855823679L;

	/**
	 * ����ID
	 */
	private String userId;

	/**
	 * ��������
	 */
	private String title;

	/**
	 * ��������
	 */
	private String description;

	/**
	 * ����ͷ���ַ
	 */
	private String imgUrl;

	/**
	 * ������������
	 */
	private String link;

	/**
	 * �������ͣ�С���ࣩ
	 */
	private String type;

	/**
	 * ������𣨴���ࣩ
	 */
	private String category;

	/**
	 * �Ƿ��������
	 */
	private int isNew;

	/**
	 * �Ƿ��ö�
	 */
	private int isTop;

	/**
	 * ��������ʱ��
	 */
	private long updateTime;

	/**
	 * �����ֶ�
	 */
	private String reserve;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getIsNew() {
		return isNew;
	}

	public void setIsNew(int isNew) {
		this.isNew = isNew;
	}

	public int getIsTop() {
		return isTop;
	}

	public void setIsTop(int isTop) {
		this.isTop = isTop;
	}

	public long getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(long updateTime) {
		this.updateTime = updateTime;
	}

	public String getReserve() {
		return reserve;
	}

	public void setReserve(String reserve) {
		this.reserve = reserve;
	}
	
}
