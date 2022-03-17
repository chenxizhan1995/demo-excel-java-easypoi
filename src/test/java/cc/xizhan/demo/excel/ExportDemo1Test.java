package cc.xizhan.demo.excel;

import cc.xizhan.demo.excel.model.Student;
import cc.xizhan.demo.excel.util.DataLoader;
import org.junit.Test;

import javax.rmi.CORBA.Stub;

public class ExportDemo1Test {
    private ExportDemo1 app = new ExportDemo1();
    @Test
    public void showData(){
        for (Student student : DataLoader.load()) {
            System.out.println(student);
        }
    }
    @Test
    public void testExport() {
        app.export();;
    }
}
