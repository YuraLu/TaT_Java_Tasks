package by.epam.classes.TaskB;

import by.epam.classes.TaskB.deviceControl.DeviceControlCenter;

import java.util.Scanner;

public class ConsoleMenu {
    private static DeviceControlCenter deviceControlCenter;
    private static final String devIdStr = "Device ID";

    private static final String[] menuBullets = {
            "1. Add device",
            "2. Delete device",
            "3. List of all devices",
            "4. Power ON/OFF device",
            "5. Show total actual power",
            "6. Sort devices by power",
            "7. Search device menu",
            "0. Exit"};

    private static final String[] powerMenu = {
            "1. Power ON device",
            "2. Power OFF device",
            "3. Power ON ALL device",
            "4. Power OFF ALL device",
            "0. Exit"};

    private static final String[] addMenu = {
            "1. Add pluggable device",
            "2. Add switchable device",
            "0. Exit"};


    public static void main(String[] args) {
        deviceControlCenter = new DeviceControlCenter();
        consoleMenu();
    }

    private static void printConsoleMenu (){
        for (String str: menuBullets) {
            System.out.println(str);
        }
    }

    private static void printPowerMenu (){
        for (String str: powerMenu) {
            System.out.println(str);
        }
    }

    private static void printAddMenu (){
        for (String str: addMenu) {
            System.out.println(str);
        }
    }

    private static void consoleMenu() {
        boolean run = true;
        while (run) {
            printConsoleMenu();
            int menuBullet = intInput("menu bullet");
            switch (menuBullet) {
                case 1:
                    printAddMenu();
                    int addCat = intInput("what to do");
                    switch (addCat){
                        case 1:
                            deviceControlCenter.addDevice(inputString(), intInput("device power"));
                            break;
                        case 2:
                            deviceControlCenter.addDevice(inputString(), intInput("device power"), intInput("device standBy power"));
                            break;
                        case 0:
                            break;
                        default:
                            System.out.println("Please choose correct number");
                    }
                    break;
                case 2:
                    deviceControlCenter.deleteDevice(intInput(devIdStr));
                    break;
                case 3:
                    deviceControlCenter.printAllDevices();
                    break;
                case 4:
                    printPowerMenu();
                    int powerCat = intInput("what to do");
                    switch (powerCat){
                        case 1:
                            deviceControlCenter.powerOn(intInput(devIdStr));
                            break;
                        case 2:
                            deviceControlCenter.powerOff(intInput(devIdStr));
                            break;
                        case 3:
                            deviceControlCenter.powerOnAllDevices();
                            break;
                        case 4:
                            deviceControlCenter.powerOffAllDevices();
                            break;
                        case 0:
                            break;
                        default:
                            System.out.println("Please make correct choice");
                    }
                    break;
                case 5:
                    deviceControlCenter.printTotalPowerConsumption();
                    break;
                case 6:
                    deviceControlCenter.printDevicesSortedByPower();
                    break;
                case 7:
                    deviceControlCenter.findDevice(inputString(), intInput("Device power"));
                    break;
                case 0:
                    run = false;
                default:
                    System.out.println("Please choose correct number from menu bullets");
            }
        }
    }

    private static int intInput(String str) {
        System.out.println("Please choose and input " + str);
        Scanner scan = new Scanner(System.in);
        return scan.nextInt();
    }

    private static String inputString() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please input device name");
        return scan.nextLine();
    }
}
