package com.big3anime.database;

import org.bson.Document;
import org.junit.Test;

import com.big3anime.backend.profiles.Employee;
import static com.big3anime.backend.profiles.Employee.Department;
import static org.junit.Assert.assertTrue;
import com.big3anime.database.DataBaseUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DataBaseUtilTest {

    @Test(expected = NullPointerException.class)
    public void addDocumentToCollectionNULLTest() {

        DataBaseUtil.INSTANCE.addDocumentToCollection(null, null);

    }

    @Test
    public void addDocumentToCollectionTest() {
        Employee emp = new Employee("dtiwari", "Divyanshu", "Tiwari", "workemail@worked.com", "personalemail@worked.com", null, "QA", Department.QUALITY, "Associate Software Engineer", new Date());
        boolean ans = (DataBaseUtil.INSTANCE.addDocumentToCollection("Employees", emp.toDocument()));
        System.out.println(ans);

        assertTrue(ans);
    }

    @Test
    public void addDocumentsToCollectionTest() {
        List<Document> empList = new ArrayList<>();
        for(int i=0;i<100000;i++){
            Employee emp = new Employee("dtiwari"+i, "Divyanshu"+i, "Tiwari"+i, "workemail@worked.com", "personalemail@worked.com", null, "QA", Department.QUALITY, "Associate Software Engineer", new Date());
            empList.add(emp.toDocument());
        }
        long starttime = System.currentTimeMillis();
        boolean ans = DataBaseUtil.INSTANCE.addDocumentsToCollection("Employees",empList);
        System.out.println(System.currentTimeMillis()-starttime);
        System.out.println(ans);

    }

}
