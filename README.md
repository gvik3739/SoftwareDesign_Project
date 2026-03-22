# Lab Reservation System
EECS 3311 – Software Design | Deliverable 2

---

## ⚠️ Important — Read Before Running

- Open the project at the **`LabReservationProject`** folder level, NOT at `SoftwareDesign_Project` or `Deliverable2`
- When entering login credentials, **type them manually** — do not copy/paste as extra spaces will cause login to fail
- Make sure you have **Java 17 or higher** installed

---

## How to Run

1. Clone or download the repository
2. Open your IDE (VS Code, IntelliJ, etc.)
3. **Open the folder at this level:**
```
SoftwareDesign_Project/Deliverable2/LabReservationProject
```
4. Navigate to:
```
src/Main.java
```
5. Right-click `Main.java` → click **Run Java** (VS Code) or **Run 'Main'** (IntelliJ)
6. The login window will open

---

## Login Credentials

> ⚠️ **Type these manually — do not copy/paste**

| Name | Email | Password | Role |
|---|---|---|---|
| James Carter | jcarter@yorku.ca | Strong@123 | Student |
| Priya Sharma | psharma@yorku.ca | Faculty@123 | Faculty |
| Darius Tehrani | dtehrani@yorku.ca | Research@123 | Researcher |
| Emily Brown | ebrown@yorku.ca | Guest@123 | Guest |
| Arjun Patel | apatel@yorku.ca | Manager@123 | Lab Manager |

> Lab Manager login unlocks the **Admin** tab for managing equipment and viewing all reservations.

---

## Project Structure

```
LabReservationProject/          ← Open your IDE at this level
├── data/                       ← CSV files (do not delete)
│   ├── users.csv
│   ├── equipment.csv
│   ├── reservations.csv
│   └── payments.csv
└── src/
    ├── Main.java               ← Run this
    ├── command/                ← Command pattern
    ├── data/                   ← CSV persistence layer
    ├── factory/                ← Factory pattern
    ├── gui/                    ← Swing GUI
    ├── model/                  ← Domain objects
    ├── service/                ← Service layer
    ├── strategy/               ← Strategy pattern
    └── util/                   ← Observer interfaces + SystemClock
```

---

## Design Patterns

| Pattern | Location |
|---|---|
| Singleton | `util/SystemClock.java`, `model/HeadLabCoordinator.java` |
| Factory | `factory/UserFactory.java` |
| Observer | `util/`, `service/LateArrivalObserver.java`, `service/SensorUpdateObserver.java` |
| State | `model/AvailableState.java`, `model/DisabledState.java`, `model/MaintenanceState.java` |
| Strategy | `strategy/` |
| Command | `command/` |
