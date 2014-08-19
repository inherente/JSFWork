package com.obelit.reloaded.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class Helper {
	public static boolean setAttibutes(HttpServletRequest request, HashMap<String,Object> map) {
		boolean returnValue ;
		Iterator<Map.Entry<String,Object>> iterator = null;
		Map.Entry<String,Object> mapEntry;

		if (map == null) {
			returnValue = false;
		} else {
			iterator = map.entrySet().iterator();
		}
		if (request == null) {
			returnValue= false;
		} else {
			returnValue= true;
			while (iterator!= null && iterator.hasNext()) {
				mapEntry = iterator.next();
				request.setAttribute(mapEntry.getKey(), mapEntry.getValue());
			}
						
		}
		return returnValue;
	}

}
