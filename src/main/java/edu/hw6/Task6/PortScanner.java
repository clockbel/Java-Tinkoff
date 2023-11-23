package edu.hw6.Task6;

import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class PortScanner {
    private final static Logger LOGGER = LogManager.getLogger();
    private final static String HEADER = "Протокол  Порт   Используется  Сервис";
    private final static int MAX_PORT = 49151;
    private static List<PortsInfo> portsInfoList = new ArrayList<>();
    private final static Map<Integer, String> KNOWN_PORTS = Map.of(
        135, "EPMAP",
        137, "Служба имен NetBIOS",
        139, "Служба сеансов NetBIOS",
        445, "Microsoft-DS Active Directory",
        843, "Adobe Flash",
        1900, "Simple Service Discovery Protocol (SSDP)",
        3702, "Динамическое обнаружение веб-служб",
        5353, "Многоадресный DNS",
        17500, "Dropbox",
        27017, "MongoDB"
    );

    private enum Protocol {
        TCP, UDP
    }

    private PortScanner() {
    }

    private static void scanPorts(int port) {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            serverSocket.close();
        } catch (Exception e) {
            portsInfoList.add(tracePort(Protocol.TCP, port));
        }

        try (DatagramSocket datagramSocket = new DatagramSocket(port);) {
            datagramSocket.close();
        } catch (Exception e) {
            portsInfoList.add(tracePort(Protocol.UDP, port));
        }
    }

    private static PortsInfo tracePort(Protocol protocol, int port) {
        String process = KNOWN_PORTS.getOrDefault(port, "");
        return new PortsInfo(protocol.toString(), port, process);
    }

    public static void PortsOutput() {
        for (int i = 0; i < MAX_PORT; i++) {
            scanPorts(i);
        }
        for (PortsInfo portsInfo : portsInfoList) {
            LOGGER.info(String.format(
                    "%-4s  %-5d %-30s", portsInfo.protocol(), portsInfo.port(), portsInfo.process()));
        }
    }

    public static void main(String[] args) {
        PortsOutput();
    }
}
