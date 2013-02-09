package com.scg.domain;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: dcostinett
 * Date: 1/21/13
 * Time: 7:44 PM
 */
public class InvoiceFooterTest {

    @Test
    public void testIncrementPageNumber() throws Exception {
        String businessName = "MyBusiness";
        InvoiceFooter footer = new InvoiceFooter(businessName);

        //there's a number f ways to do thi... tokenize and grab last token also comes to mind,
        // but I don't know if one way is inherently better than another.
        String numberStr = footer.toString().substring(businessName.length()).trim().substring("Page:".length()).trim();
        int pageNumber = Integer.parseInt(numberStr);
        assertEquals(1, pageNumber);
        footer.incrementPageNumber();
        pageNumber = Integer.parseInt(
                footer.toString().substring(businessName.length()).trim().substring("Page:".length()).trim());
        assertEquals(2, pageNumber);
    }


    @Test
    public void testToString() throws Exception {
        String businessName = "MyBusiness";
        InvoiceFooter footer = new InvoiceFooter(businessName);
        assertTrue(footer.toString().startsWith(businessName));
        assertTrue(footer.toString().endsWith("1"));
    }
}
