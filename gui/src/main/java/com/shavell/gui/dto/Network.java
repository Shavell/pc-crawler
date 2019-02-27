package com.shavell.gui.dto;

import lombok.Data;

@Data
public class Network {
    private String name;
    private String macAdress;
    private String ipAdress;
    private String dns;
    private String gateway;
    private String hostname;
    private String domainName;
    private String txPacket;
    private String rxPacket;
}
