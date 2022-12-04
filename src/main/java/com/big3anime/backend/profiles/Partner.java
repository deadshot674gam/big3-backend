package com.big3anime.backend.profiles;

import java.util.concurrent.ConcurrentHashMap;

import com.big3anime.backend.finance.Expense;

public class Partner {
    private PartnerType partnerType;
    private String partnerName;
    private ConcurrentHashMap<String, String> partnerContact;
    private String partnerId;
    private Expense partnerExpense;
    public Partner(PartnerType partnerType, String partnerName, ConcurrentHashMap<String, String> partnerContact, String partnerId,
            Expense partnerExpense) {
        this.partnerType = partnerType;
        this.partnerName = partnerName;
        this.partnerContact = partnerContact;
        this.partnerId = partnerId;
        this.partnerExpense = partnerExpense;
    }
    public PartnerType getPartnerType() {
        return partnerType;
    }
    public String getPartnerName() {
        return partnerName;
    }
    public ConcurrentHashMap<String, String> getPartnerContact() {
        return partnerContact;
    }
    public String getPartnerId() {
        return partnerId;
    }
    public Expense getPartnerExpense() {
        return partnerExpense;
    }
    public void setPartnerType(PartnerType partnerType) {
        this.partnerType = partnerType;
    }
    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName;
    }
    public void setPartnerContact(ConcurrentHashMap<String, String> partnerContact) {
        this.partnerContact = partnerContact;
    }
    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId;
    }
    public void setPartnerExpense(Expense partnerExpense) {
        this.partnerExpense = partnerExpense;
    }

    
}

enum PartnerType {
    MEDICAL,
    TECHNOLOGY,
    MEDIA,
    MEALS,
    INFRASTRUCTURE,
    WORKSPACE
}
