// package qtriptest.tests;

// import java.io.File;
// import java.io.FileInputStream;
// import java.io.IOException;
// import com.google.gson.Gson;
// import org.apache.poi.ss.usermodel.DataFormatter;
// import org.apache.poi.xssf.usermodel.XSSFSheet;
// import org.apache.poi.xssf.usermodel.XSSFWorkbook;

// public class ExcelUtility {

//     public static String[][] getDataFromExcel(String sheetName) 
//     {
//         try
//         {

//             File excelDataFile = new File("/home/crio-user/workspace/abhisheksinghbhadauria1-ME_QTRIP_QA_V2/app/src/test/resources/DatasetsforQTrip.xlsx");
//             FileInputStream fis = new FileInputStream(excelDataFile);
//             try (XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
//                 XSSFSheet sheet = workbook.getSheet(sheetName);
//                 int rowCount=sheet.getPhysicalNumberOfRows();
//                 int colCount=sheet.getRow(1).getLastCellNum();
//                 DataFormatter dataFormatter = new DataFormatter();
//                 String[][] data = new String[rowCount-1][colCount-1];
//                 int writeCountRow = 0;
//                 int writeCountCol = 0;

//                  for(int i =1;i<rowCount;i++)
//                  {
//                     writeCountCol=0;
//                     // System.out.println("rowCount: "+rowCount);
//                     // System.out.println("i: "+i);


//                     if(i==(rowCount)){
//                         break;
//                     }

//                     for(int j =1;j<colCount;j++)
//                     {
//                         if(j==(colCount)){
//                             break;
//                             }

//                         String value = dataFormatter.formatCellValue(sheet.getRow(i).getCell(j));
//                         // System.out.println("i: "+i);
//                         // System.out.println("j: "+j);

//                         data[writeCountRow][writeCountCol] = value;
//                         // System.out.println(value);
//                         writeCountCol++ ;
//                     }
//                     writeCountRow++;
//                 }

//                 // System.out.println(new Gson().toJson(data));
//                 return data; // Returned the retrieved data
//             }
//         } catch (Exception e) {
//             e.printStackTrace();
//             return null;
//         }
//     }
// }

// public class ExcelUtility
// {
//     public static String[][] getDataFromExcel(String sheetName)
//     {
//         try
//         {
//         File excelDataFile=new File("./src/test/resources/DatasetsforQTrip.xlsx");
//         FileInputStream fis=new FileInputStream(excelDataFile);
//         XSSFWorkbook workbook=new XSSFWorkbook(fis);
//         XSSFSheet sheet=workbook.getSheet(sheetName);
//         int rowCount=sheet.getPhysicalNumberOfRows();
//         int colCount=sheet.getRow(0).getLastCellNum();
//         DataFormatter dataFormatter=new DataFormatter();
//         String[][] data=new String[rowCount-1][colCount-1];
//         for(int i=0;i<rowCount-1;i++)
//         {
//             for(int j=0;j<colCount;j++)
//             {
//                 String value=dataFormatter.formatCellValue(sheet.getRow(i+1).getCell(j));
//                 data[i][j]=value;
               
//             }
//         }
//         System.out.println(new Gson().toJson(data));
//         workbook.close();
//         fis.close();
//    return data;
        
//     }
//     catch(IOException e)
//     {
//         e.printStackTrace();
//         e.getMessage();
//     }
//     return new String[0][];
//     }
// }


