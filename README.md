# 🏋️ Blackthrone GYM Management System

A Java-based desktop application for managing gym memberships, built with Swing for the GUI.

---

## 📁 Project Structure

```
├── GymMember.java          # Abstract base class for all gym members
├── PremiumMember.java      # Subclass for premium members
├── RegularMember.java      # Subclass for regular members
└── GymGui.java             # Main GUI class (entry point)
```

---

## 🧱 Class Overview

### `GymMember` (Abstract) 🧩
The base blueprint for all members. Stores core member data and defines shared behavior.

**Fields:** `id`, `name`, `location`, `phone`, `email`, `gender`, `DOB`, `membershipStartDate`, `attendance`, `loyaltyPoints`, `activeStatus`

**Key Methods:**
- `activeMembership()` / `deactiveMembership()` — toggle membership status
- `resetMember()` — resets attendance, loyalty points, and active status
- `markAttendance()` — abstract, implemented by subclasses
- `display()` — prints member info to console

---

### `PremiumMember extends GymMember` ⭐
Handles premium-tier members with a fixed charge of **Rs. 50,000**.

**Additional Fields:** `premiumCharge`, `personalTrainer`, `isFullPayment`, `paidAmount`, `discountAmount`

**Key Methods:**
- `payDueAmount(double amount)` — processes payments toward the premium charge
- `calculateDiscount()` — applies a **10% discount (Rs. 5,000)** if payment is complete
- `revertPremiumMember()` — resets all premium-specific fields
- `markAttendance()` — increments attendance and adds **10 loyalty points** 🏆

---

### `RegularMember extends GymMember` 🙋
Handles regular-tier members with selectable plans.

**Additional Fields:** `attendanceLimit` (30), `isEligibleForUpgrade`, `removalReason`, `referralSource`, `plan`, `price`

**Plans & Pricing 💳:**
| Plan     | Price (Rs.) |
|----------|-------------|
| Basic    | 6,500       |
| Standard | 12,500      |
| Deluxe   | 18,500      |

**Key Methods:**
- `updatePlan(String plan)` — upgrades plan if attendance ≥ 30
- `getPlanPrice(String plan)` — returns the price for a given plan
- `revertRegularMember(String reason)` — resets member and records removal reason
- `markAttendance()` — increments attendance and adds **5 loyalty points** 🏆

---

### `GymGui` 🖥️
The main GUI class and application entry point. Built with Java Swing using a null layout.

**Dashboard Navigation:**
- ➕ **Add Members** — forms to register Premium or Regular members
- 🎛️ **Member Control** — activate/deactivate membership, mark attendance, revert members (search by ID)
- 💰 **Finance Management** — pay due amount, calculate discount (Premium); upgrade plan (Regular)
- 🔍 **Display** — search and view member details by ID
- 💾 **Read / Save to File** — read from or write all member data to `MemberDetails.txt`

---

## ▶️ Getting Started

### Prerequisites
- Java JDK 8 or higher
- Any Java IDE (IntelliJ IDEA, Eclipse, NetBeans) or command line

### 🚀 Running the Application

**From the command line:**
```bash
# Compile all files
javac GymMember.java PremiumMember.java RegularMember.java GymGui.java

# Run the application
java GymGui
```

**From an IDE:** Open the project, then run `GymGui.java` as the main class.

> **Note:** Place `logo in black.png` and `logo in white.png` in the same directory as the compiled classes for the logo to display correctly. 🖼️

---

## ✨ Features

- ➕ Add and manage both Premium and Regular gym members
- 🔍 Search members by ID across all management panels
- 📊 Track attendance and loyalty points per member
- 💳 Finance tools: payment processing, discount calculation, plan upgrades
- 💾 Persistent storage: save all member records to a formatted text file (`MemberDetails.txt`) and read them back
- 🚫 Duplicate ID detection when adding new members
- ✅ Input validation for ID, phone number, and required fields

---

## 🗄️ Data Persistence

Member data is saved to **`MemberDetails.txt`** in the working directory. The file is formatted as a table with separate sections for Premium and Regular members.

> ⚠️ Data is stored in memory during the session. Use **"Save to File"** before closing to persist records.

---

## ⚠️ Known Limitations

- Member data is not automatically loaded from file on startup — it must be re-entered each session or loaded via "Read from File" (display only, not into memory)
- Only one premium and one regular member instance (`pm`, `rm`) is referenced for finance and control operations — operations always act on the most recently added member of each type when multiple share an ID
- Phone number is validated for exactly 10 digits
