package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel implements Iterator<Object[]> {
    private String excelName;
    private Workbook wb;
    private InputStream is;
    private Sheet sheet;
    private Row row;
    private int curRowNum=2;
    private int rownum;
    private int colnum;
    private String[] columnName;
    private int[] runCase;
    private int realRow;
    public static String dataPath;

    public ReadExcel(String sheetName,String... comm){
        if (comm.length==0){
            excelName=dataPath;
        }
        else if (comm.length==1){
            excelName=System.getProperty("user.dir")+"/测试数据/"+comm[0];
        }

        try {
            is=new FileInputStream(excelName);
            wb=new XSSFWorkbook(is);
        } catch (Exception e) {
            e.printStackTrace();
        }
        sheet = wb.getSheet(sheetName);
        runCase=


    }

    private int[] getRunCaseId(){
        String[] caseId;
        int[] runcaseId;
        row=sheet.getRow(0);
        Cell cell = row.getCell(1);



    }

    private boolean assertCell(Cell cell){
        boolean ret = false;
        if(cell.getRichStringCellValue().toString()==""){
            ret = true;
        }
        return ret;

    }



    /**
     *      判断是否还有可迭代对象
     * @return
     */
    @Override
    public boolean hasNext() {
        boolean ret = false;
        int length=runCase.length;
        if(runCase[0]==0){
            realRow=this.curRowNum;
            if(this.curRowNum>=rownum){
                ret=false;
            }
            else {
                ret=true;
            }

        }
        else {
            for(;this.curRowNum-2<length;){
                realRow=runCase[this.curRowNum-2];
                ret=true;
                break;
            }
        }
        return ret;
    }

    @Override
    public Object[] next() {
        HashMap<String,Object> map=new HashMap<String, Object>();
        Object temp;
//       Row row = sheet.getRow(this.realRow);
        int endscols=3;
        for (int i =0;i<colnum-endscols;i++){
            Cell cell = row.getCell();
            if(assertCell(cell)){

            }
        }

        return new Object[0];
    }

}
