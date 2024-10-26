package com.scm.qual.fileutility;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.scm.qual.ipathconstants.IPathConstants;

public class JsonUtility implements IPathConstants{

	public String getDataFromJson(String key) {
		JSONObject map = null;
		JSONParser parse = new JSONParser();
		try {
			Object obj = parse.parse(new FileReader(jsonPath));
			map = (JSONObject) obj;
		} catch (Exception e) {
			e.printStackTrace();
		}
		String data = (String) map.get(key);
		return data;
	}
}
