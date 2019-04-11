package by.epam.threads.ship;

public class Ship {

    private String shipName;
    private final int MAX_ON_BOARD_CONTAINER_CAPACITY;
    private int currentOnBoardContainersQty;

    public Ship(String shipName, int MAX_ON_BOARD_CONTAINER_CAPACITY, int currentOnBoardContainerQty) {
        this.shipName = shipName;
        this.MAX_ON_BOARD_CONTAINER_CAPACITY = MAX_ON_BOARD_CONTAINER_CAPACITY;
        this.currentOnBoardContainersQty = currentOnBoardContainerQty;
    }

    public String getShipName() { return shipName; }

    public int getMAX_ON_BOARD_CONTAINER_CAPACITY() {
        return MAX_ON_BOARD_CONTAINER_CAPACITY;
    }

    public int getCurrentOnBoardContainersQty() {
        return currentOnBoardContainersQty;
    }

    public void setCurrentOnBoardContainersQty(int currentOnBoardContainersQty) {
        this.currentOnBoardContainersQty = currentOnBoardContainersQty;
    }

    public boolean hasContainersOnBoard() {
        return currentOnBoardContainersQty > 0;
    }

    public boolean hasFreeSpaceOnBoard() {
        return MAX_ON_BOARD_CONTAINER_CAPACITY > currentOnBoardContainersQty;
    }

    public int getAvailableSpace() {
        return MAX_ON_BOARD_CONTAINER_CAPACITY - currentOnBoardContainersQty;
    }


    @Override
    public String toString() {
        return "ship{" +
                "shipName = '" + shipName + '\'' +
                ", MAX_ON_BOARD_CONTAINER_CAPACITY = " + MAX_ON_BOARD_CONTAINER_CAPACITY +
                ", Containers On Board = " + currentOnBoardContainersQty +
                '}';
    }
}
