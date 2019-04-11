package by.epam.threads;

import by.epam.threads.ship.ShipThread;
import by.epam.threads.ship.Ship;
import by.epam.threads.port.Port;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class PortMain {

    public static void main(String[] args) {
        List<Ship> ships = new ArrayList<>();
        Port port = new Port("NewPort", 4 ,300_000, 20_000);

        for(int i = 1; i <= 7; i++) {
            ships.add(new Ship("ship-" + i, 5000 * 2 * i, 5_000 * i));
        }

        System.out.println(port.toString());
        System.out.println();
        ships.forEach(System.out::println);
        System.out.println();

        System.out.println("Total amount on Board of all ships = " + ships.stream()
                .map(Ship::getCurrentOnBoardContainersQty)
                .mapToInt(Integer::intValue)
                .sum());
        System.out.println();


        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 7 ; i++) {
            executor.submit(new ShipThread(port,ships.get(i)));
        }
        awaitTerminationAfterShutdown(executor);


        System.out.println();
        System.out.println(port.toString());
        System.out.println();
        ships.forEach(System.out::println);
        System.out.println();
        System.out.println("Total amount on Board of all ships = " + ships.stream()
                .map(Ship::getCurrentOnBoardContainersQty)
                .mapToInt(Integer::intValue)
                .sum());
        System.out.println();
    }

    private static void awaitTerminationAfterShutdown(ExecutorService threadPool) {
        threadPool.shutdown();
        try {
            if (!threadPool.awaitTermination(10, TimeUnit.SECONDS)) {
                threadPool.shutdownNow();
            }
        } catch (InterruptedException ex) {
            threadPool.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}