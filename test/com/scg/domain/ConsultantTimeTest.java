package com.scg.domain;

import com.scg.util.Name;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: dcostinett
 * Date: 1/20/13
 * Time: 7:19 AM
 */
public class ConsultantTimeTest {

    private static final Calendar cal = new GregorianCalendar();
    private static final Date now = cal.getTime();
    private static final ClientAccount account = new ClientAccount("MyTestClient", new Name("Last", "First"));
    private static final ConsultantTime consultantTime = new ConsultantTime(now, account, Skill.PROJECT_MANAGER, 100);


    @Test
    public void testGetDate() throws Exception {

        Date when = consultantTime.getDate();
        assertTrue(now.equals(when));
    }

    @Test
    public void testSetDate() throws Exception {
        Date when = consultantTime.getDate();
        assertTrue(now.equals(when));

        //add a month YEAR == 1, MONTH == 2
        cal.add(Calendar.MONTH, 1);

        consultantTime.setDate(cal.getTime());
        when = consultantTime.getDate();
        assertTrue(cal.getTime().equals(when));
    }

    @Test
    public void testGetAccount() throws Exception {
        assertEquals(account, consultantTime.getAccount());
    }

    @Test
    public void testSetAccount() throws Exception {
        assertEquals(account, consultantTime.getAccount());

        ClientAccount otherClient = new ClientAccount("MyOtherTestClient", new Name("OtherLast", "OtherFirst"));
        consultantTime.setAccount(otherClient);
    }

    @Test
    public void testGetSkill() throws Exception {
        assertEquals("Expected Kill = Skill.PROJECT_MANAGER", Skill.PROJECT_MANAGER, consultantTime.getSkill());
    }

    @Test
    public void testSetSkill() throws Exception {
        consultantTime.setSkill(Skill.SOFTWARE_ENGINEER);
        assertEquals("Expected Kill = Skill.SOFTWARE_ENGINEER", Skill.SOFTWARE_ENGINEER, consultantTime.getSkill());
        consultantTime.setSkill(Skill.PROJECT_MANAGER);
        assertEquals("Expected Kill = Skill.PROJECT_MANAGER", Skill.PROJECT_MANAGER, consultantTime.getSkill());
    }

    @Test
    public void testGetHours() throws Exception {
        //test object's constructor initializes value to 100
        assertEquals("Expected hours to initially be 100", 100, consultantTime.getHours());
    }

    @Test
    public void testSetHours() throws Exception {
        consultantTime.setHours(10);
        assertEquals("Expected hours to be 10", 10, consultantTime.getHours());
        consultantTime.setHours(100);
        assertEquals("Expected hours to be 100", 100, consultantTime.getHours());
    }

    @Test
    public void testIsBillable() throws Exception {
        assertTrue(consultantTime.isBillable());
        assertEquals(account.isBillable(), consultantTime.isBillable());
    }

    @Test
    public void testSetBillable() throws Exception {
        assertTrue(consultantTime.isBillable());
        consultantTime.setBillable(false);
        assertTrue(!consultantTime.isBillable());
        consultantTime.setBillable(true);
        assertTrue(consultantTime.isBillable());
    }
}
