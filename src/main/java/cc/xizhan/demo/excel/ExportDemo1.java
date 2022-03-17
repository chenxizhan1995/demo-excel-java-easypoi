package cc.xizhan.demo.excel;

import cc.xizhan.demo.excel.model.Student;
import cc.xizhan.demo.excel.util.DataLoader;
import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * <p> Description: </p>
 */
public class ExportDemo1 {
    /** 导出列表数据。从零创建 Excel 文件
     *
     */
    public void export(){
        System.out.println("导出");
        List<Student> students = DataLoader.load();
        ExportParams params = new ExportParams("学生信息", "学生信息", ExcelType.XSSF);
        Workbook workbook = ExcelExportUtil.exportExcel(params, Student.class, students);

        try(FileOutputStream fout = new FileOutputStream("output/students.xlsx")){
            workbook.write(fout);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /** 模板文件导出
     *
     */
    public void exportByTemplate(){

    }
}
