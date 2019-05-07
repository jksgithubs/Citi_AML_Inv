package org.citi.appUtils;

import org.citi.utils.Constants;
import org.citi.utils.ExpHandler;
import org.citi.utils.Keywords;

public class MenuNavigation {
	public static void Menu(String menu) throws Throwable {
		try {
			//Navigate to Menu
			Keywords.Click(menu);
		} catch(Throwable ex) {
			ExpHandler.Handle(ex, Constants.bDriver);
			ex.printStackTrace();
		}
	}
	
	public static void MenuSubMenu(String menu, String subMenu) throws Throwable {
		try {
			//Navigate to Menu --> Sub Menu
			Keywords.Click(menu);
			Keywords.Click(subMenu);
		} catch(Throwable ex) {
			ExpHandler.Handle(ex, Constants.bDriver);
			ex.printStackTrace();
		}
	}
	
	public static void MenuSubSubMenu(String menu, String subMenu, String subSubMenu) throws Throwable {
		try {
			//Navigate to Menu --> Sub Menu --> Sub Menu
			Keywords.Click(menu);
			Keywords.Click(subMenu);
			Keywords.Click(subSubMenu);
		} catch(Throwable ex) {
			ExpHandler.Handle(ex, Constants.bDriver);
			ex.printStackTrace();
		}
	}
}