
## **Atomic Order Processing System – Console Backend Challenge**

---

## **Challenge Overview**

You are tasked with building a **robust, console-based backend system** for an e-commerce platform that processes orders against limited inventory.

The system must handle **simultaneous order requests**, ensure **data consistency**, and **prevent overselling** under all conditions.

This challenge focuses on **backend correctness, transactional safety, and low-level system design**, not UI or frameworks.

---

## **Objective**

Design and implement a system that:

* Processes orders atomically
* Handles concurrent access safely
* Maintains strict data integrity
* Follows clean Low-Level Design (LLD)

---

## **Core Entities**

### **Product**

* `product_id` (INT, Primary Key)
* `name` (VARCHAR)
* `available_stock` (INT)

### **Order**

* `order_id` (INT, Primary Key)
* `product_id` (INT, Foreign Key)
* `quantity` (INT)
* `status` (ENUM: CREATED, CONFIRMED, FAILED, CANCELLED)
* `created_at` (TIMESTAMP)

---

## **Functional Requirements**

### 1. Product Management

* Add new products with initial stock
* View all products with current stock

### 2. Order Placement (Critical Section)

* Input: `product_id`, `quantity`
* Must:

    * Verify stock availability
    * Reserve stock
    * Create order record
    * Commit as a single atomic operation
* If any step fails → rollback completely

### 3. Order Cancellation

* Restore reserved stock
* Update order status to `CANCELLED`

### 4. Order Viewing

* Display all orders with current status

---

## **Concurrency & Transaction Rules**

* Multiple order requests may occur simultaneously
* Stock must **never become negative**
* Competing requests must not oversell inventory
* Database transaction boundaries must be clearly defined
* Appropriate locking or isolation must be used

---

## **Multi-Thread Simulation Rules**

Participants must simulate concurrency by:

* Creating **multiple Java threads** attempting to place orders for the same product
* Each thread represents an independent user
* Threads must run concurrently, not sequentially

### Example Simulation Requirement:

* Product stock: `10`
* 5 threads each try to order `3` units
* Final result:

    * At most **3 orders succeed**
    * Remaining orders must fail gracefully
    * Final stock must be `1` or greater (never negative)

---

## **Hidden Test Cases**

The following test cases will be evaluated but **not disclosed to participants during implementation**:

### 🧪 Test Case 1: Oversell Protection

* 20 concurrent order requests
* Initial stock = 15
* Validate that stock never drops below zero

### 🧪 Test Case 2: Partial Failure Rollback

* Database failure after stock deduction but before order insert
* Validate that stock is restored

### 🧪 Test Case 3: Duplicate Order Handling

* Same order request submitted twice
* Ensure duplicate processing is prevented

### 🧪 Test Case 4: Cancel Edge Case

* Cancel already cancelled order
* Stock must not be restored twice

### 🧪 Test Case 5: High Contention Scenario

* Multiple threads repeatedly ordering and cancelling
* Validate consistency after stress run

---

## **Technical Constraints**

* Language: **Java**
* Database: **PostgreSQL / MySQL / H2**
* Access: **JDBC only**
* Use `PreparedStatement`
* No frameworks (Spring, Hibernate, JPA)
* No in-memory-only solutions

---

## **Design Constraints**

* Clean separation of layers:

    * UI (Console)
    * Service
    * DAO
    * Database Utility
* No SQL inside the `main()` method
* DAO must be interface-driven
* Proper exception handling and logging

---

## **Deliverables**

* Source code
* SQL schema
* README explaining:

    * Transaction strategy
    * Concurrency handling approach
    * How to run concurrency simulation

---

## **Grading Rubric (100 Points)**

### 🧠 Correctness – 40 Points

* No overselling (15)
* Correct order state transitions (10)
* Proper rollback on failure (15)

### 🔒 Concurrency Handling – 25 Points

* Thread-safe order placement (15)
* Correct locking / isolation usage (10)

### 🏗️ Low-Level Design – 20 Points

* Clean architecture (10)
* DAO abstraction & service separation (10)

### ⚙️ Code Quality – 10 Points

* Readability
* Naming conventions
* Resource management

### 📄 Documentation – 5 Points

* Clear README
* Execution instructions

---

## **Disqualification Criteria**

* Stock becomes negative at any point
* No transaction handling
* Business logic inside DAO or UI
* Use of ORM or frameworks

---

## **Bonus Challenges (Optional)**

* Implement optimistic locking
* Add idempotency key for orders
* Generate a concurrency test report

---
