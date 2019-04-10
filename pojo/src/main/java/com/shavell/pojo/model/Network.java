package com.shavell.pojo.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Network implements Serializable {
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
