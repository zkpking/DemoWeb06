package com.base.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Excel的poi解析工具类
 * @author 
 *
 */
public class ExcelToDb {
	
	/**
	 * 测试方法
	 * @param args
	 */
	/*public static void main(String[] args) {
		Test test = null;
		File file = new File("d://2.xlsx");
		try {
			List<List<Object>> list = getByExcel(file);
			for(List<Object> entry:list){
				test = new Test();
				test.setInterviewTime(entry.get(0).toString());
				test.setName(entry.get(1).toString());
				test.setWorkAge(entry.get(2).toString());
				test.setEducation(entry.get(3).toString());
				test.setPosition(entry.get(4).toString());
				test.setPlaceWork(entry.get(5).toString());
				test.setInitial(Integer.parseInt(entry.get(6).toString()));
				test.setInterviewer(entry.get(7).toString());
				test.setReinitial("".equals(entry.get(8))?0:Integer.parseInt(entry.get(8).toString()));
				test.setResultsInterview(entry.get(9).toString());
				test.setIsEntry("".equals(entry.get(10))?0:Integer.parseInt(entry.get(10).toString()));
				test.setRemark(entry.get(11).toString());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}*/

	
	/**
	 * 对外提供的读取excel文件的内容值返回
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public static List<List<Object>> getByExcel(File file) throws IOException {
		String fName = file.getName();
		String eName = fName.lastIndexOf(".")==-1?"":fName.substring(fName.lastIndexOf(".")+1);
		if("xls".equals(eName)){
			return read2003(file);
		}else if("xlsx".equals(eName)){
			return read2007(file);
		}else{
			throw new IOException("不支持格式");
		}
	}
	 
	/**
	 * 读取excel表头
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public static String[] readExcelHead(File file) throws IOException {
		HSSFWorkbook wb = new HSSFWorkbook(new FileInputStream(file));
		HSSFSheet sheet = wb.getSheetAt(0);
		HSSFRow row = null;
		HSSFCell cell = null;
		row = sheet.getRow(0);
		String[] buff = new String[row.getLastCellNum()];
		for (int i = row.getFirstCellNum(); i < row.getLastCellNum(); i++) {
			cell = row.getCell(i);
			buff[i] = cell.getStringCellValue();
		}
		return buff;
	}
	
	/**
	 * 读取2003格式excel文件以.xls结尾
	 * @param file
	 * @return
	 * @throws IOException
	 */
	private static List<List<Object>> read2003(File file) throws IOException{
		List<List<Object>> dataList = new ArrayList<List<Object>>();
		HSSFWorkbook wb = new HSSFWorkbook(new FileInputStream(file));
		HSSFSheet sheet = wb.getSheetAt(0);
		HSSFRow row = null;
		HSSFCell cell = null;
		Object val = null;
		DecimalFormat df = new DecimalFormat("0");// 格式化数字
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 格式化日期字符串
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");// 格式化日期字符串
		for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
			row = sheet.getRow(i);
			if (row == null) {
				continue;
			}
			List<Object> objList = new ArrayList<Object>();
			for (int j = row.getFirstCellNum(); j < row.getLastCellNum(); j++) {
				cell = row.getCell(j);
				if (cell == null) {
					val = null;
					objList.add(val);
					continue;
				}
				switch (cell.getCellType()) {
				case HSSFCell.CELL_TYPE_STRING:
					if("".equals(cell.getStringCellValue().trim())||null==cell.getStringCellValue().trim()){
						val=0;
					}else if("否".equals(cell.getStringCellValue().trim())){
						val=0;
					}else if("是".equals(cell.getStringCellValue().trim())){
						val=1;
					}else{
						val=cell.getStringCellValue();
					}
					break;
				case HSSFCell.CELL_TYPE_NUMERIC:
					if ("@".equals(cell.getCellStyle().getDataFormatString())) {
						val = df.format(cell.getNumericCellValue());
					} else if ("General".equals(cell.getCellStyle().getDataFormatString())) {
						val = df.format(cell.getNumericCellValue());
					} else {
						val = sdf.format(HSSFDateUtil.getJavaDate(cell.getNumericCellValue()));
					}
					break;
				case HSSFCell.CELL_TYPE_BOOLEAN:
					val = cell.getBooleanCellValue();
					break;
				case HSSFCell.CELL_TYPE_BLANK:
					val = "";
					break;
				default:
					val = cell.toString();
					break;
				}
				objList.add(val);
			}
			dataList.add(objList);
		}
		return dataList;
	}
	
	/**
	 * 读取2007格式excel文件以.xlsx结尾
	 * @param file
	 * @return
	 * @throws IOException
	 */
	private static List<List<Object>> read2007(File file) throws IOException {
		List<List<Object>> dataList = new ArrayList<List<Object>>();
		XSSFWorkbook xwb = new XSSFWorkbook(new FileInputStream(file));
		XSSFSheet sheet = xwb.getSheetAt(0);
		XSSFRow row = null;
		XSSFCell cell = null;
		Object val = null;
		DecimalFormat df = new DecimalFormat("0");// 格式化数字
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 格式化日期字符串
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");// 格式化日期字符串
		for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
			row = sheet.getRow(i);
			if (row == null) {
				continue;
			}
			List<Object> objList = new ArrayList<Object>();
			for (int j = row.getFirstCellNum(); j < row.getLastCellNum(); j++) {
				cell = row.getCell(j);
				if (cell == null) {
					val = null;
					objList.add(val);
					continue;
				}
				switch (cell.getCellType()) {
				case XSSFCell.CELL_TYPE_STRING:
					if("".equals(cell.getStringCellValue().trim())||null==cell.getStringCellValue().trim()){
						val=0;
					}else if("否".equals(cell.getStringCellValue().trim())){
						val=0;
					}else if("是".equals(cell.getStringCellValue().trim())){
						val=1;
					}else{
						val=cell.getStringCellValue();
					}
					break;
				case XSSFCell.CELL_TYPE_NUMERIC:
					if ("@".equals(cell.getCellStyle().getDataFormatString())) {
						val = df.format(cell.getNumericCellValue());
					} else if ("General".equals(cell.getCellStyle()
							.getDataFormatString())) {
						val = df.format(cell.getNumericCellValue());
					} else {
						val = sdf.format(HSSFDateUtil.getJavaDate(cell
								.getNumericCellValue()));
					}
					break;
				case XSSFCell.CELL_TYPE_BOOLEAN:
					val = cell.getBooleanCellValue();
					break;
				case XSSFCell.CELL_TYPE_BLANK:
					val = "";
					break;
				default:
					val = cell.toString();
					break;
				}
				objList.add(val);
			}
			dataList.add(objList);
		}
		return dataList;
	}
			
}
