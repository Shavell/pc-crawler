package com.shavell.pojo.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Disk implements Serializable {
    private String name;
    private String model;
    private String serial;
    private long size;
    private String partitions;
}
