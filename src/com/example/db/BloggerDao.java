package com.example.db;

import java.util.List;

import com.example.bean.Blogger;

public interface BloggerDao {

	/**
	 * ��Ӳ���
	 * @param blogger
	 */
	public void insert(Blogger blogger);
	
	/**
	 * ��Ӳ����б�
	 * @param list
	 */
	public void insert(List<Blogger> list);
	
	/**
	 * ��ѯĳ�������Ƿ����
	 * @param userId
	 * @return
	 */
	public Blogger query(String userId);
	
	/**
	 * ��ѯ���еĲ���
	 * @return
	 */
	public List<Blogger> queryAll();
	
	/**
	 * ɾ������
	 * 
	 * @param blogger
	 */
	public void delete(Blogger blogger);

	/**
	 * ɾ�������б�
	 * 
	 * @param list
	 */
	public void deleteAll(List<Blogger> list);

	/***
	 * ɾ�����в���
	 * 
	 * @param type
	 */
	public void deleteAll();

	/**
	 * ��ʼ���������ݿ�
	 * @param type
	 */
	public void init(String type);

}
