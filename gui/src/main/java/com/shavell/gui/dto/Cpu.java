package com.shavell.gui.dto;

import lombok.Data;
import java.io.Serializable;

@Data
public class Cpu implements Serializable {

    private String model;
    private int physicalCore;
    private int logicalCore;
    private String uptime;
    private int bitness;

}
