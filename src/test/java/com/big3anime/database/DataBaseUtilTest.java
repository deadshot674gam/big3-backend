package com.big3anime.database;

import org.junit.Test;

import com.big3anime.backend.profiles.Employee;
import static com.big3anime.backend.profiles.Employee.Department;
import static org.junit.Assert.assertTrue;
import com.big3anime.database.DataBaseUtil;

import java.util.Date;

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

}
