package com.big3anime.backend.profiles;

import java.util.concurrent.ConcurrentHashMap;

enum SubscriptionReoccurrence {
    MONTHLY,
    QUATERLY,
    HALFYEARLY,
    ANNUALLY
}

enum SubscriptionPackage {
    PREMIUM,
    BASIC,
    VIP
}

public class Client {
    private String clientId;
    private String clientRegion;
    private String clientName;
    private SubscriptionReoccurrence clienySubscriptionReoccurrence;
    private SubscriptionPackage clientSubscriptionPackage;
    private ConcurrentHashMap<String, Float> clientBusinessComponentToRevenueMap = new ConcurrentHashMap<>();

    public Client(String clientId, String clientRegion, String clientName,
            SubscriptionReoccurrence clienySubscriptionReoccurrence, SubscriptionPackage clientSubscriptionPackage,
            ConcurrentHashMap<String, Float> clientBusinessComponentToRevenueMap) {
        this.clientId = clientId;
        this.clientRegion = clientRegion;
        this.clientName = clientName;
        this.clienySubscriptionReoccurrence = clienySubscriptionReoccurrence;
        this.clientSubscriptionPackage = clientSubscriptionPackage;
        this.clientBusinessComponentToRevenueMap = clientBusinessComponentToRevenueMap;
    }

    public Client() {
    }

    public Client(Client cli) {
        this(cli.getClientId(), cli.getClientRegion(), cli.getClientName(), cli.getClienySubscriptionReoccurrence(),
                cli.getClientSubscriptionPackage(), cli.getClientBusinessComponentToRevenueMap());
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientRegion() {
        return clientRegion;
    }

    public void setClientRegion(String clientRegion) {
        this.clientRegion = clientRegion;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public SubscriptionReoccurrence getClienySubscriptionReoccurrence() {
        return clienySubscriptionReoccurrence;
    }

    public void setClienySubscriptionReoccurrence(SubscriptionReoccurrence clienySubscriptionReoccurrence) {
        this.clienySubscriptionReoccurrence = clienySubscriptionReoccurrence;
    }

    public SubscriptionPackage getClientSubscriptionPackage() {
        return clientSubscriptionPackage;
    }

    public void setClientSubscriptionPackage(SubscriptionPackage clientSubscriptionPackage) {
        this.clientSubscriptionPackage = clientSubscriptionPackage;
    }

    public ConcurrentHashMap<String, Float> getClientBusinessComponentToRevenueMap() {
        return clientBusinessComponentToRevenueMap;
    }

    public void setClientBusinessComponentToRevenueMap(
            ConcurrentHashMap<String, Float> clientBusinessComponentToRevenueMap) {
        this.clientBusinessComponentToRevenueMap = clientBusinessComponentToRevenueMap;
    }

}
