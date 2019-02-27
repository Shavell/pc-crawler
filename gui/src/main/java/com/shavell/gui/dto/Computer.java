package com.shavell.gui.dto;

import lombok.Data;
import java.util.ArrayList;

@Data
public class Computer {

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
    private ArrayList<String> gpus = new ArrayList<>();
    private ArrayList<String> displays = new ArrayList<>();
    private ArrayList<String> soundCards = new ArrayList<>();
    private ArrayList<String> usbDevices = new ArrayList<>();
    private ArrayList<Network> networks = new ArrayList<>();
    private ArrayList<Disk> disks = new ArrayList<>();
}
