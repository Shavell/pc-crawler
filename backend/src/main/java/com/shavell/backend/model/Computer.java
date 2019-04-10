package com.shavell.backend.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;

@Data
@Entity
public class Computer implements Serializable {
    private static final long serialVersionUID = 8890435079654208095L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(nullable = false)
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
    @Column(length = 3000)
    private ArrayList<String> gpus = new ArrayList<String>();
    @Column(length = 3000)
    private ArrayList<String> displays = new ArrayList<String>();
    @Column(length = 3000)
    private ArrayList<String> soundCards = new ArrayList<String>();
    @Column(length = 3000)
    private ArrayList<String> usbDevices = new ArrayList<String>();
    @Column(length = 3000)
    private ArrayList<Network> networks = new ArrayList<Network>();
    @Column(length = 3000)
    private ArrayList<Disk> disks = new ArrayList<Disk>();

    @CreationTimestamp
    private Timestamp created;
}