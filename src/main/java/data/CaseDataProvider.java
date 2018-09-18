package data;

import jxl.read.biff.BiffException;
import org.testng.annotations.DataProvider;
import utils.ReadExcel;

import java.io.IOException;
import java.util.Iterator;

public class CaseDataProvider {

    @DataProvider(name="dp")
    private Iterator<Object[]> dp() throws Exception {
        return new ReadExcel(sheetName);
}
