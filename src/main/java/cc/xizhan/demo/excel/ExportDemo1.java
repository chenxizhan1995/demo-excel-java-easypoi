package cc.xizhan.demo.excel;

import cc.xizhan.demo.excel.model.Student;
import cc.xizhan.demo.excel.util.DataLoader;
import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p> Description: </p>
 */
public class ExportDemo1 {
    /**
     * 导出列表数据。从零创建 Excel 文件
     */
    public void export() {
        System.out.println("导出");
        List<Student> students = DataLoader.load();
        ExportParams params = new ExportParams("学生信息", "学生信息", ExcelType.XSSF);
        Workbook workbook = ExcelExportUtil.exportExcel(params, Student.class, students);

        try (FileOutputStream fout = new FileOutputStream("output/students.xlsx")) {
            workbook.write(fout);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getTemplate() {
        File file = new File("target/test-classes/students.xlsx");
        System.out.println(file.exists());
    }

    /**
     * 模板文件导出
     */
    public void exportByTemplate() {
        System.out.println("模板导出");

        Map<String, Object> data = new HashMap<>();
        List<Student> students = DataLoader.load();
        data.put("students", students);
        data.put("date", new Date());
        data.put("comment", "模板导出示例");

        TemplateExportParams params = new TemplateExportParams("students.xlsx", 0);
        Workbook wb = ExcelExportUtil.exportExcel(params, data);

        try (OutputStream fout = new FileOutputStream("output/student-by-tempalte.xlsx")) {
            wb.write(fout);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
