package sit707_tasks;

import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class DateUtilTest {

    @Test
    public void testValidDate() {
        DateUtil date = new DateUtil(15, 3, 2024);
        Assert.assertEquals(15, date.getDay());
        Assert.assertEquals(3, date.getMonth());
        Assert.assertEquals(2024, date.getYear());
    }


    @Test(expected = Exception.class)
    public void testInvalidMonthNegative() {
        new DateUtil(20, -3, 2024);
    }

    @Test(expected = Exception.class)
    public void testInvalidMonthOverMax() {
        new DateUtil(10, 13, 2024);
    }

    @Test(expected = Exception.class)
    public void testInvalidYearUnderMin() {
        new DateUtil(1, 1, 1699);
    }

    @Test(expected = Exception.class)
    public void testInvalidYearOverMax() {
        new DateUtil(20, 2, 2025);
    }

    @Test(expected = Exception.class)
    public void testInvalidLeapYearDay() {
        new DateUtil(29, 2, 2023);
    }

    @Test
    public void testIncrement() {
        DateUtil date = new DateUtil(31, 1, 2024);
        date.increment();
        assertEquals(1, date.getDay()); 
    }



    @Test
    public void testDecrement() {
        DateUtil date = new DateUtil(2, 3, 2024);
        date.decrement();
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(3, date.getMonth());
        Assert.assertEquals(2024, date.getYear());
    }
    
    @Test(expected = Exception.class)
    public void testInvalidDayZero() {
        new DateUtil(0, 1, 2024);
    }
    
    

    @Test(expected = Exception.class)
    public void testInvalidDayNegative() {
        new DateUtil(-5, 2, 2024);
    }
    
    

    @Test(expected = Exception.class)
    public void testInvalidDayOverMax() {
        new DateUtil(32, 12, 2024);
    }
    
    
    

    @Test(expected = Exception.class)
    public void testInvalidMonthZero() {
        new DateUtil(15, 0, 2024);
    }
}
