package com.jk.dao.menu;

import java.util.List;

import com.jk.entity.menu.MenuRequest;
import com.jk.entity.menu.MenuResponse;

public interface MenuDao {

	List<MenuResponse> selectMenuListJson(MenuRequest menuRequest);

	List<MenuResponse> selectFirstMenuList(MenuRequest menuRequest);

	void insertMenu(MenuRequest menuRequest);
	

}
