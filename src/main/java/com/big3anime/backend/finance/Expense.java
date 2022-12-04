package com.big3anime.backend.finance;

import org.json.JSONObject;

public class Expense {
    private String id;
    private String type;
    private String transactionId;
    private String modeOfPayment;
    private String expenseReason;
    private boolean isInputCost;
    public Expense(String id, String type, String transactionId, String expenseReason,String modeOfPayment, boolean isInputCost) {
        this.id = id;
        this.type = type;
        this.transactionId = transactionId;
        this.expenseReason = expenseReason;
        this.isInputCost = isInputCost;
        this.modeOfPayment = modeOfPayment;
    }

    public JSONObject generateExpenseSlip(){
        JSONObject slipComponents = new JSONObject();

        slipComponents.put("Type of Expense", this.type);
        slipComponents.put("Transaction Id from Payment Mode", this.transactionId);
        slipComponents.put("Does this comes under Input Cost?", this.isInputCost);
        slipComponents.put("Expense Reason", this.expenseReason);
        slipComponents.put("Mode of Payment", this.modeOfPayment);

        return slipComponents;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getExpenseReason() {
        return expenseReason;
    }

    public void setExpenseReason(String expenseReason) {
        this.expenseReason = expenseReason;
    }

    public boolean isInputCost() {
        return isInputCost;
    }

    public void setInputCost(boolean isInputCost) {
        this.isInputCost = isInputCost;
    }
    
}
