package org.citi.gfx.apputils;

import org.citi.gfx.utils.ExpHandler;
import org.citi.gfx.utils.Keywords;
import static org.citi.gfx.utils.GlobalVariables.*;

public class MenuNavigation {
	public static void Menu(String menu) throws Throwable {
		try {
			//Navigate to Menu
			Keywords.Click(menu);
		} catch(Throwable ex) {
			ExpHandler.Handle(ex, cDriver);
			ex.printStackTrace();
		}
	}
	
	public static void MenuSubMenu(String menu, String subMenu) throws Throwable {
		try {
			//Navigate to Menu --> Sub Menu
			Keywords.Click(menu);
			Keywords.Click(subMenu);
		} catch(Throwable ex) {
			ExpHandler.Handle(ex, cDriver);
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
			ExpHandler.Handle(ex, cDriver);
			ex.printStackTrace();
		}
	}
}