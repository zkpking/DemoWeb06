package main.java.com.test.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.base.utils.ExportCSV;

public class TestExportCsv {

	public static void main(String[] args) {
		System.out.println("--->start");
		List exportData = new ArrayList<Map>();
		Map row1 = new LinkedHashMap<String, String>();
		row1.put("1", "11");
		row1.put("2", "12");
		row1.put("3", "13");
		row1.put("4", "14");
		exportData.add(row1);
		row1 = new LinkedHashMap<String, String>();
		row1.put("1", "21");
		row1.put("2", "22");
		row1.put("3", "23");
		row1.put("4", "24");
		exportData.add(row1);
		LinkedHashMap map = new LinkedHashMap();
		map.put("1", "第一列");
		map.put("2", "第二列");
		map.put("3", "第三列");
		map.put("4", "第四列");

		String path = "e:/export/";
		String fileName = "文件导出";
		File file = ExportCSV.createCSVFile(exportData, map, path, fileName);
		System.out.println("--->end");
	}

}
