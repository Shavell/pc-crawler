package com.shavell.gui;

import com.shavell.gui.model.ComputerModel;
import com.shavell.pojo.model.Disk;
import com.shavell.pojo.model.Network;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import oshi.SystemInfo;
import oshi.hardware.*;
import oshi.software.os.NetworkParams;
import oshi.software.os.OperatingSystem;
import oshi.util.FormatUtil;

import java.util.Arrays;

public class SystemDetails {

    private static final Logger logger = LoggerFactory.getLogger(SystemDetails.class);

    private static ComputerModel computer = new ComputerModel();

    public ComputerModel callDetails(String doorNo) {
        logger.debug("Initializing System...");
        SystemInfo si = new SystemInfo();

        HardwareAbstractionLayer hal = si.getHardware();
        OperatingSystem os = si.getOperatingSystem();

        computer.setDoorNo(doorNo);
        computer.setOs(String.valueOf(os));
        computer.getCpu().setBitness(64);

        logger.debug("Checking computer system...");
        printComputerSystem(hal.getComputerSystem());

        logger.debug("Checking Processor...");
        printProcessor(hal.getProcessor());

        logger.debug("Checking Memory...");
        printMemory(hal.getMemory());

        logger.debug("Checking Disks...");
        printDisks(hal.getDiskStores());

        logger.debug("Checking Network interfaces...");
        printNetworkInterfaces(hal.getNetworkIFs());

        logger.debug("Checking Network parameters...");
        printNetworkParameters(os.getNetworkParams());

        logger.debug("Checking Displays...");
        printDisplays(hal.getDisplays());

        logger.debug("Checking USB Devices...");
        printUsbDevices(hal.getUsbDevices(true));

        logger.debug("Checking Sound Cards...");
        printSoundCards(hal.getSoundCards());

        return computer;
    }

    private static void printComputerSystem(final ComputerSystem computerSystem) {
        final Baseboard baseboard = computerSystem.getBaseboard();

        computer.setVendor(computerSystem.getManufacturer() + "/" + computerSystem.getModel());
        computer.setSerialNumber(computerSystem.getSerialNumber());
        computer.setBaseboard(baseboard.getManufacturer() + "/" + baseboard.getModel());
        computer.setBaseboardSerialNumber(baseboard.getSerialNumber());

        //    if (Utils.identifyVM().length() > 0) { // support oshi version after 3.13.0
        //      computer.setVmSpec(Arrays.toString(Utils.identifyVM()));
        //    }
    }

    private static void printProcessor(CentralProcessor processor) {
        computer.getCpu().setModel(String.valueOf(processor));
        computer.getCpu().setPhysicalCore(processor.getPhysicalProcessorCount());
        computer.getCpu().setLogicalCore(processor.getLogicalProcessorCount());
        computer.getCpu().setUptime(FormatUtil.formatElapsedSecs(processor.getSystemUptime()));
    }

    private static void printMemory(GlobalMemory memory) {
        computer.setMemoryTotal(memory.getTotal());
        computer.setMemoryFree(memory.getAvailable());
    }

    private static void printDisks(HWDiskStore[] diskStores) {
        for (HWDiskStore disk : diskStores) {
            Disk tmpDisk = new Disk();
            tmpDisk.setName(disk.getName());
            tmpDisk.setModel(disk.getModel());
            tmpDisk.setSerial(disk.getSerial());
            tmpDisk.setSize(disk.getSize());
            // tmpDisk.setPartitions(disk.getPartitions());
            computer.getDisks().add(tmpDisk);
        }
    }

    private static void printNetworkInterfaces(NetworkIF[] networkIFs) {
        for (NetworkIF net : networkIFs) {
            Network network = new Network();
            network.setName(String.format(" Name: %s (%s)%n", net.getName(), net.getDisplayName()));
            network.setMacAdress(net.getMacaddr());
            network.setIpAdress(Arrays.toString(net.getIPv4addr()));
            computer.getNetworks().add(network);

            boolean hasData = net.getBytesRecv() > 0 || net.getBytesSent() > 0 || net.getPacketsRecv() > 0
                    || net.getPacketsSent() > 0;

            network.setRxPacket(hasData ? FormatUtil.formatBytes(net.getBytesRecv()) : "?");
            network.setTxPacket(hasData ? FormatUtil.formatBytes(net.getBytesSent()) : "?");
        }
    }

    private static void printNetworkParameters(NetworkParams networkParams) {
        Network network = new Network();
        network.setHostname(networkParams.getHostName());
        network.setDomainName(networkParams.getDomainName());
        network.setGateway(networkParams.getIpv4DefaultGateway());
        network.setDns(Arrays.toString(networkParams.getDnsServers()));
        computer.getNetworks().add(network);
    }

    private static void printDisplays(Display[] displays) {
        for (Display display : displays) computer.getDisplays().add(String.valueOf(display));
    }

    private static void printUsbDevices(UsbDevice[] usbDevices) {
        for (UsbDevice usbDevice : usbDevices) computer.getUsbDevices().add(String.valueOf(usbDevice));
    }

    private static void printSoundCards(SoundCard[] cards) {
        for (SoundCard card : cards) computer.getSoundCards().add(String.valueOf(card));
    }
}
