package com.shavell.gui.dto;

import lombok.Data;

@Data
public class Disk {
    private String name;
    private String model;
    private String serial;
    private long size;
    private String partitions;
}
