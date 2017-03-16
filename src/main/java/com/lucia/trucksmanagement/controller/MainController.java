
package com.lucia.trucksmanagement.controller;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.cxf.helpers.IOUtils;
import org.apache.poi.hssf.util.CellReference;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	@RequestMapping("/")
	public String getHome(ModelMap model) {
		return "home";
	}

	@RequestMapping("/downloadLargeExcel")
	public String downloadLargeFile(HttpServletResponse response) throws IOException {
		
		// Tell the browser is a XLSX
		response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"); 
		// Tell the browser the filename, and that it needs to be downloaded instead of opened
		response.addHeader("Content-Disposition", "attachment; filename=\"myArchive.xlsx\"");        
		// Tell the browser the overall size, so it can show a realistic progressbar
		response.setHeader("Content-Length", String.valueOf(100000));
		
		response.flushBuffer();
		
		ServletOutputStream out = response.getOutputStream();
		BufferedOutputStream buf = new BufferedOutputStream(out);
		
        SXSSFWorkbook wb = new SXSSFWorkbook(-1); // turn off auto-flushing and accumulate all rows in memory
        Sheet sh = wb.createSheet();
        for(int rownum = 0; rownum < 200000; rownum++){
            Row row = sh.createRow(rownum);
            for(int cellnum = 0; cellnum < 20; cellnum++){
                Cell cell = row.createCell(cellnum);
                CellReference c = new CellReference(cell.getRowIndex(), cell.getColumnIndex());
                String address = c.formatAsString();
                cell.setCellValue(address);
            }

           // manually control how rows are flushed
           if(rownum % 10000 == 0) {
                ((SXSSFSheet)sh).flushRows(100); // retain 100 last rows and flush all others
           }
           
           //FileOutputStream temp = new FileOutputStream("/tmp/temp.xlsx");
          
           out.flush();
           wb.write(out);
           out.flush();
           
//           FileInputStream input = new FileInputStream("/tmp/temp.xlsx");
//           IOUtils.copy(input, out);
          // out.flush();
        }
        // dispose of temporary files backing this workbook on disk
       // wb.dispose();
		   
		return null;
	}
	
	
	
}
