package jsonTest;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

public class JsonTest {
	public static void main(String[] args) throws JSONException {
		
		JSONObject json = new JSONObject();
		json.put("id", "2");
		json.put("name", "张三");
		JSONObject json1= new JSONObject();
		json1.put("id", "3");
		json1.put("name", "张四");
		System.out.println("json格式:"+json);
		
		JSONArray jsonArray = new JSONArray();
		jsonArray.add(json);
		jsonArray.add(json1);
		System.out.println("jsonArray格式:"+jsonArray);
		
		String str = "[{\"name\":\"张三\",\"id\":\"2\"},{\"name\":\"张四\",\"id\":\"3\"}]";
		String str1 = "{\"name\":\"张三\",\"id\":\"2\"}";

		/*json字符串最外层是方括号时：*/
		JSONArray jsonArray1 = JSON.parseArray(str);
		System.out.println("String转jsonArray:"+jsonArray1);
		
		
		JSONObject tt = new JSONObject(str1);
		System.out.println(tt);
		
//		List<JSONObject> list = new ArrayList<>();
//		if(jsonArray1.size()>0) {
//			for (int i = 0; i < jsonArray1.size(); i++) {
//				JSONObject jsb = jsonArray1.getJSONObject(i);
//				list.add(jsb);
//			}
//		}
//		System.out.println(list);
		
	}
}
