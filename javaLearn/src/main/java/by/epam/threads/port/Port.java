package by.epam.threads.port;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class Port {
    private String portName;
    private final int DOCKS_IN_PORT;
    private int freeDocks;
    private final int MAX_PORT_CONTAINER_CAPACITY;
    private int currentContainersInPort;
    private int dockedShips;
    private Lock lock = new ReentrantLock();

    public Port(String portName, int DOCKS_IN_PORT, int MAX_PORT_CONTAINER_CAPACITY, int currentContainersInPort) {
        this.portName = portName;
        this.DOCKS_IN_PORT = DOCKS_IN_PORT;
        this.MAX_PORT_CONTAINER_CAPACITY = MAX_PORT_CONTAINER_CAPACITY;
        this.currentContainersInPort = currentContainersInPort;
        freeDocks = DOCKS_IN_PORT;
        dockedShips = 0;
    }

    public String getPortName() {
        return portName;
    }

    public boolean dockShip() {
        while (!this.tryDock()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }


    public void unDockShip() {
        lock.lock();
        try {
            dockedShips--;
            freeDocks++;
        } finally {
            lock.unlock();
        }
    }

    public int loadToShip(int containersToLoad) {
        lock.lock();
        try {
            if (currentContainersInPort >= containersToLoad) {
                currentContainersInPort -= containersToLoad;
                System.out.println("Loaded on board from Port " + containersToLoad);
                return containersToLoad;
            }else {
                int loadedContainerAmount = currentContainersInPort;
                currentContainersInPort = 0;
                System.out.println("Loaded on board from Port " + loadedContainerAmount + ". Nothing left in Port");
                return loadedContainerAmount;
            }
        } finally {
            lock.unlock();
        }
    }

    public int unloadFromShip(int containersToLeaveInPort) {
        lock.lock();
            try {
                if (!hasPlaceForContainersAtPort(containersToLeaveInPort)) {
                    int tempQty = currentContainersInPort + containersToLeaveInPort - MAX_PORT_CONTAINER_CAPACITY;
                    currentContainersInPort = MAX_PORT_CONTAINER_CAPACITY;
                    return tempQty;
                }
                currentContainersInPort += containersToLeaveInPort;
                return 0;
            } finally {
                lock.unlock();
            }
    }

    private boolean tryDock() {
        lock.lock();
        try {
            if (dockedShips < DOCKS_IN_PORT) {
                dockedShips++;
                freeDocks--;
                return true;
            }
            return false;
        } finally {
            lock.unlock();
        }
    }

    private boolean hasPlaceForContainersAtPort(int containersAmount) {
        return currentContainersInPort + containersAmount <= MAX_PORT_CONTAINER_CAPACITY;
    }

    public int getCurrentContainersInPort() {
        return currentContainersInPort;
    }

    @Override
    public String toString() {
        return "Port{" +
                "portName='" + portName + '\'' +
                ", DOCKS_IN_PORT=" + DOCKS_IN_PORT +
                ", MAX_PORT_CONTAINER_CAPACITY=" + MAX_PORT_CONTAINER_CAPACITY +
                ", currentContainersInPort=" + currentContainersInPort +
                '}';
    }
}