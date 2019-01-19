package com.userexperior.uewallet.model;

/**
 * Created by userexperior on 15-02-2017.
 */

public class MiniStatement {
    private String txnRef;
    private String txnDateTime;
    private String txnAmount;

    public String getTxnRef() {
        return txnRef;
    }

    public void setTxnRef(String txnRef) {
        this.txnRef = txnRef;
    }

    public String getTxnDateTime() {
        return txnDateTime;
    }

    public void setTxnDateTime(String txnDateTime) {
        this.txnDateTime = txnDateTime;
    }

    public String getTxnAmount() {
        return txnAmount;
    }

    public void setTxnAmount(String txnAmount) {
        this.txnAmount = txnAmount;
    }
}
