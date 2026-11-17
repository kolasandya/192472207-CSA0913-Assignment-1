# Campus Smart-Parking System – Assignment 1

**Repository name:** `CSA09-192472207-Assignment1`  
**Language:** Java  
**Suggested JDK:** Java 17 or later

This project contains one separately runnable Java program for each of the 12 assignment tasks. Task 10 uses Java packages and therefore has two source files.

## How to run a task in VS Code

1. Extract this ZIP file.
2. Open the extracted `CSA09-192472207-Assignment1` folder in VS Code using **File → Open Folder**.
3. Open **Terminal → New Terminal**.
4. Move into the task folder. Example for Task 1:

   ```bash
   cd Task01
   javac ParkingModel.java
   java ParkingModel
   ```

5. For another task, first return to the project root using `cd ..`, then enter its folder.

## Run commands for all tasks

| Task | Commands (run from project root) |
|---|---|
| 1 | `cd Task01` then `javac ParkingModel.java` then `java ParkingModel` |
| 2 | `cd Task02` then `javac ParkingArrayDemo.java` then `java ParkingArrayDemo` |
| 3 | `cd Task03` then `javac ParkingFacility.java` then `java ParkingFacility` |
| 4 | `cd Task04` then `javac ConstructorDemo.java` then `java ConstructorDemo` |
| 5 | `cd Task05` then `javac StaticDemo.java` then `java StaticDemo` |
| 6 | `cd Task06` then `javac InheritanceDemo.java` then `java InheritanceDemo` |
| 7 | `cd Task07` then `javac OverridingDemo.java` then `java OverridingDemo` |
| 8 | `cd Task08` then `javac FeeDemo.java` then `java FeeDemo` |
| 9 | `cd Task09` then `javac AbstractionDemo.java` then `java AbstractionDemo` |
| 10 | `cd Task10` then `javac parking/model/ParkingSlot.java parking/app/Main.java` then `java parking.app.Main` |
| 11 | `cd Task11` then `javac SmartParkingSystem.java` then `java SmartParkingSystem` |
| 12 | `cd Task12` then `javac DesignChallenge.java` then `java DesignChallenge` |

If you are already inside a task folder, do not type `cd TaskXX` again. To return to the project root, use `cd ..`.

## Important notes and assumptions

- Task 2 uses zero-based floor and slot indexes in its sample input.
- Task 8 follows the assignment's sample rates: two-wheeler ₹10/hour, car ₹30/hour, EV charging ₹12/kWh; each started parking hour is charged in full.
- Task 11 is a compact demonstration of entry, ticketing, exit, monthly-pass handling, duplicate registration validation and fee calculation. It uses a small sample capacity and simplified fixed rates; it is not a production-ready parking application.
- Task 12 assumes an e-bike flat fee of ₹20 because the assignment does not specify the amount. The delivery-van example charges double the car rate for the portion of parking within 9 AM–5 PM, using a simplified same-day calculation. The visitor-pass class is a demonstration and should be integrated with the entry/exit workflow if a fully connected implementation is required.
- Add your own actual execution screenshots under each Task folder before submission.
- Update this README with your correct name, register number, installed Java version, GitHub URL, and any changes you make. Confirm your register number before submitting; the folder/repository name currently uses `192472207` from the earlier conversation.

## GitHub submission checklist

- Keep each task in its own folder.
- Run all 12 programs yourself.
- Save screenshots of actual output in the matching task folders.
- Add the written explanations, pseudocode, UML diagram, complexity analysis and test table required by the assignment PDF.
- Commit progressively (at least one commit per task), as the assignment asks.
