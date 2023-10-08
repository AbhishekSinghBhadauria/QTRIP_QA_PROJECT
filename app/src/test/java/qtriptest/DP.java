package qtriptest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DP {

    @DataProvider(name="DatasetsforQTrip")
    public Object [][] DatasetsforQTrip(Method m) throws IOException{
        try {
            File flObj = new File("/home/crio-user/workspace/abhisheksinghbhadauria1-ME_QTRIP_QA_V2/app/src/test/resources/DatasetsforQTrip.xlsx");
            FileInputStream fileInputObj = new FileInputStream(flObj);
            try (XSSFWorkbook wbObj = new XSSFWorkbook(fileInputObj)) {
                switch (m.getName()) {
   
                  case "TestCase01":
                  XSSFSheet sheet1 = wbObj.getSheet("TestCase01");
                  int TC1_rowCount = sheet1.getPhysicalNumberOfRows();
                  int TC1_colCount = sheet1.getRow(0).getLastCellNum();
                  
                  Object[][] testData1 = new Object[TC1_rowCount-1][TC1_colCount-1];
                  
                  for (int i = 1; i < TC1_rowCount; i++) {
                    for(int j = 1; j < TC1_colCount; j++ ){
                      String value = sheet1.getRow(i).getCell(j).toString();
                      testData1[i-1][j-1] = value;
                    }
                  }

                  return testData1;

                  case "TestCase02":
                  XSSFSheet sheet2 = wbObj.getSheet("TestCase02");
                  int TC2_rowCount = sheet2.getPhysicalNumberOfRows();
                  int TC2_colCount = sheet2.getRow(0).getLastCellNum();
                  
                  Object[][] testData2 = new Object[TC2_rowCount-1][TC2_colCount-1];
                  
                  for (int i =1; i < TC2_rowCount; i++) {
                    for(int j = 1; j < TC2_colCount; j++ ){
                      String value = sheet2.getRow(i).getCell(j).toString();
                      testData2[i-1][j-1] = value;
                    }
                }
                     return testData2;

                     case "TestCase03":
                  XSSFSheet sheet3 = wbObj.getSheet("TestCase03");
                  int TC3_rowCount = sheet3.getPhysicalNumberOfRows();
                  int TC3_colCount = sheet3.getRow(0).getLastCellNum();
                  
                  Object[][] testData3 = new Object[TC3_rowCount-1][TC3_colCount-1];
                  
                  for (int i =1; i < TC3_rowCount; i++) {
                    for(int j = 1; j < TC3_colCount; j++ ){
                      String value = sheet3.getRow(i).getCell(j).toString();
                      testData3[i-1][j-1] = value;
                    }
                }
                     return testData3;

                     case "TestCase04":
                     XSSFSheet sheet4 = wbObj.getSheet("TestCase04");
                     int TC4_rowCount = sheet4.getPhysicalNumberOfRows();
                     int TC4_colCount = sheet4.getRow(0).getLastCellNum();
                     
                     Object[][] testData4 = new Object[TC4_rowCount-1][TC4_colCount-1];
                     
                     for (int i =1; i < TC4_rowCount; i++) {
                       for(int j = 1; j < TC4_colCount; j++ ){
                         String value = sheet4.getRow(i).getCell(j).toString();
                         testData4[i-1][j-1] = value;
                         System.out.println(value);
                       }
                   }
                        return testData4;
      }
            }
    }catch(Exception e)
            {
            e.printStackTrace();
          }
        return null;
        }
    }