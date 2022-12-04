package com.big3anime.backend.finance;

import org.json.JSONObject;

public class Expense {
    private String type;
    private String transactionId;
    private String modeOfPayment;
    private String expenseReason;
    private boolean isInputCost;
    public Expense(String type, String transactionId, String expenseReason,String modeOfPayment, boolean isInputCost) {
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
    
}
