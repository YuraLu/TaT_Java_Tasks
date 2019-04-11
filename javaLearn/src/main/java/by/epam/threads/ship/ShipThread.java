package by.epam.threads.ship;

import by.epam.threads.port.Port;

public class ShipThread implements Runnable{

    private Port port;
    private Ship ship;

    public ShipThread(Port port, Ship ship) {
        this.port = port;
        this.ship = ship;
    }

    @Override
    public void run() {
        // try dockShip
        if (!port.dockShip()) {
            System.out.println(ship.getShipName() + " could't dock to " + port.getPortName());
        }else {
            // try unload containers At Port
            int initialContainersOnBoard = ship.getCurrentOnBoardContainersQty();
            System.out.println(ship.getShipName() + " docked to " + port.getPortName());
            if (ship.hasContainersOnBoard()) {
                System.out.println(ship.getShipName() + " tries to unload " + ship.getCurrentOnBoardContainersQty() + " containers in port.");
                int notLoadedContainersQty = port.unloadFromShip(ship.getCurrentOnBoardContainersQty());
                ship.setCurrentOnBoardContainersQty(notLoadedContainersQty);
                System.out.println(ship.getShipName() + " leaves in port " + (initialContainersOnBoard - notLoadedContainersQty) + ". Actual container's amount in port " + port.getCurrentContainersInPort() + " containers.");

            }

            // try load ship
            if (ship.hasFreeSpaceOnBoard()) {
                System.out.println(ship.getShipName() + " try to load " + port.getCurrentContainersInPort() + " containers on ship board. Ship have available space for " + ship.getAvailableSpace() + " containers.");
                int loadedContainerQty = port.loadToShip(ship.getMAX_ON_BOARD_CONTAINER_CAPACITY());
                ship.setCurrentOnBoardContainersQty(loadedContainerQty);
                System.out.println(ship.getShipName() + " loaded " + loadedContainerQty + " and going to leave port.");
            }

            port.unDockShip();
            System.out.println(ship.getShipName() + " leaving Port " + port.getPortName());
        }


    }
}
