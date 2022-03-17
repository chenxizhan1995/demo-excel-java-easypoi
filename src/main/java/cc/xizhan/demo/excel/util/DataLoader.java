package cc.xizhan.demo.excel.util;

import cc.xizhan.demo.excel.model.Student;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p> Description: </p>
 */
public class DataLoader {
    public static List<Student> load() {
        List<Student> list = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            Student tmp = new Student();
            tmp.setSid(201400301200L + i);
            tmp.setName("学生-" + i);
            // 1995-12-12
            tmp.setBirthday(new Date(818697600000L));
            list.add(tmp);
        }
        return list;
    }
}
