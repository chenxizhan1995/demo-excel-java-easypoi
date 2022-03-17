package cc.xizhan.demo.excel.model;

import cn.afterturn.easypoi.excel.annotation.Excel;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p> Description: 实体类：学生</p>
 */
public class Student {
    @Excel(name = "学号")
    private Long sid;

    @Excel(name = "姓名")
    private String name;
    @Excel(name = "出生日期", format = "yyyy-MM-dd HH:mm:ss")
    private Date birthday;

    public Long getSid() {
        return sid;
    }

    public void setSid(Long sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    private static SimpleDateFormat fmt = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
    @Override
    public String toString() {

        return "Student{" +
                "sid=" + sid +
                ", name='" + name + '\'' +
                ", birthday=" + fmt.format(birthday) +
                '}';
    }
}
