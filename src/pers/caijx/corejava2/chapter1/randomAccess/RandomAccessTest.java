package pers.caijx.corejava2.chapter1.randomAccess;

import java.io.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by Administrator on 2017/11/25/025.
 */
public class RandomAccessTest {
    
    public static void main(String[] args) throws IOException {
        Employee[] staff = new Employee[3];
        staff[0] = new Employee("Carl Craker",75000,1987,12,15);
        staff[1] = new Employee("Harry Hacker",50000,1989,10,1);
        staff[2] = new Employee("Tony Tester",40000,1990,3,15);
        
        try (DataOutputStream out = new DataOutputStream(new FileOutputStream("employee.dat"))){
            for (Employee employee : staff) {
                writeData(out,employee);
            }
        }

        try (RandomAccessFile in = new RandomAccessFile("employee.dat","r")){
            int n = (int) (in.length() / Employee.RECORD_SIZE);
            Employee[] newStaff = new Employee[n];
            //为了高效的执行，使用随记访问，我们首先读入第三条记录
            for (int i = n - 1; i >=0; i--) {
                newStaff[i] = new Employee();
                //将文件指针设置到距文件开头pos个字节处
                in.seek(i * Employee.RECORD_SIZE);
                newStaff[i] = readData(in);
            }

            for (Employee e : newStaff) {
                System.out.println(e);
            }
        }
    }

    private static void writeData(DataOutputStream out, Employee employee) throws IOException {
        DataIO.writeFixedString(employee.getName(),Employee.NAME_SIZE,out);
        out.writeDouble(employee.getSalary());

        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(employee.getHireDay());
        out.writeInt(calendar.get(Calendar.YEAR));
        out.writeInt(calendar.get(Calendar.MONTH));
        out.writeInt(calendar.get(Calendar.DAY_OF_MONTH));
    }

    private static Employee readData(DataInput in) throws IOException {
        String name = DataIO.readFixedString(Employee.NAME_SIZE,in);
        double salary = in.readDouble();
        int y = in.readInt();
        int m = in.readInt();
        int d = in.readInt();
        return new Employee(name,salary,y,m-1,d);
    }
}
