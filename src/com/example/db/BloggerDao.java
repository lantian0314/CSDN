package com.example.db;

import java.util.List;

import com.example.bean.Blogger;

public interface BloggerDao {

	/**
	 * 添加博主
	 * @param blogger
	 */
	public void insert(Blogger blogger);
	
	/**
	 * 添加博主列表
	 * @param list
	 */
	public void insert(List<Blogger> list);
	
	/**
	 * 查询某个博主是否存在
	 * @param userId
	 * @return
	 */
	public Blogger query(String userId);
	
	/**
	 * 查询所有的博主
	 * @return
	 */
	public List<Blogger> queryAll();
	
	/**
	 * 删除博主
	 * 
	 * @param blogger
	 */
	public void delete(Blogger blogger);

	/**
	 * 删除博主列表
	 * 
	 * @param list
	 */
	public void deleteAll(List<Blogger> list);

	/***
	 * 删除所有博主
	 * 
	 * @param type
	 */
	public void deleteAll();

	/**
	 * 初始化博客数据库
	 * @param type
	 */
	public void init(String type);

}
