package com.shavell.pojo.model;

import lombok.Data;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.ArrayList;

@Data
@MappedSuperclass
public class Computer implements Serializable {
    private static final long serialVersionUID = 8890435079654208095L;

    private String doorNo;
    private String username;
    private String os;
    private long memoryTotal;
    private long memoryFree;
    private String baseboard;
    private String vendor;
    private String serialNumber;
    private String baseboardSerialNumber;
    private String vmSpec;
    private Cpu cpu = new Cpu();
    private ArrayList<String> gpus = new ArrayList<String>();
    private ArrayList<String> displays = new ArrayList<String>();
    private ArrayList<String> soundCards = new ArrayList<String>();
    private ArrayList<String> usbDevices = new ArrayList<String>();
    private ArrayList<Network> networks = new ArrayList<Network>();
    private ArrayList<Disk> disks = new ArrayList<Disk>();
}