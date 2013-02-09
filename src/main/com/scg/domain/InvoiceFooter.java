package com.scg.domain;

/**
 * Created with IntelliJ IDEA.
 * User: dcostinett
 * Date: 1/21/13
 * Time: 2:26 PM
 */
public class InvoiceFooter {
    private final String businessName;
    private volatile int pageNumber = 1;

    public InvoiceFooter(String businessName) {
        this.businessName = businessName;
    }

    public void incrementPageNumber() {
        pageNumber++;
    }

    @Override
    public String toString() {
        int rightSideFieldSize = 80 - businessName.length();
        return String.format("%-70s Page:%4d", businessName, pageNumber);
    }
}
