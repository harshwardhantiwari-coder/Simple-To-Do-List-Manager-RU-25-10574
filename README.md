# Simple To-Do List Manager

A beginner-friendly, menu-driven **Java console application** for managing daily tasks. This academic project demonstrates the use of a **custom Singly Linked List**, **ArrayList**, and **Linear Searching**.

## Project Details

| Field | Details |
|---|---|
| Project name | Simple To-Do List Manager |
| Student | Harshwardhan Tiwari |
| Language | Java |
| Data structures | Singly Linked List, ArrayList |
| Searching technique | Linear Search |
| Difficulty | Easy |

## Features

- Add a new task with an automatically generated ID.
- View all tasks and their current status.
- Search tasks by title keyword (case-insensitive).
- Mark a task as completed.
- Delete a task using its ID.
- Validate menu and ID input to prevent invalid-number crashes.

## Concepts Used

### 1. Singly Linked List
A custom singly linked list stores the tasks. Each node contains a `Task` object and a reference to the next node. It supports insertion at the end, deletion by ID, and traversal.

### 2. ArrayList
An `ArrayList<Task>` is used to collect tasks when displaying all tasks and to store matching tasks returned by the search operation.

### 3. Linear Search
The program traverses the linked list one node at a time and checks whether each task title contains the entered keyword. The search is case-insensitive.

## Project Structure

```text
Simple-To-Do-List-Manager/
├── src/
│   └── Main.java
├── .gitignore
└── README.md
```

## Requirements

- Java JDK 8 or later
- A terminal / command prompt, or an IDE such as IntelliJ IDEA, Eclipse, or VS Code

## How to Run

1. Download or clone this repository.
2. Open a terminal in the project folder.
3. Compile the source file:

   ```bash
   javac -d out src/Main.java
   ```

4. Run the program:

   ```bash
   java -cp out Main
   ```

## Sample Output

```text
==================================
       SIMPLE TO-DO MANAGER
==================================

------------- MENU --------------
1. Add a task
2. View all tasks
3. Search task by title
4. Mark task as completed
5. Delete a task
6. Exit
---------------------------------
Enter your choice: 1
Enter task title: Complete Java assignment
Task added successfully. Task ID: 1

Enter your choice: 1
Enter task title: Study data structures
Task added successfully. Task ID: 2

Enter your choice: 2
ID     TASK TITLE                          STATUS
---------------------------------------------------------------
1      Complete Java assignment            Pending
2      Study data structures               Pending

Total tasks: 2

Enter your choice: 3
Enter title keyword to search: java

Matching tasks:
ID     TASK TITLE                          STATUS
---------------------------------------------------------------
1      Complete Java assignment            Pending
Results found: 1

Enter your choice: 4
Enter task ID to mark as completed: 1
Task marked as completed.
```

## Time Complexity

Let `n` be the number of tasks.

| Operation | Time complexity | Explanation |
|---|---:|---|
| Add task | O(n) | Traverses to the last node |
| View tasks | O(n) | Visits every node |
| Search by title | O(n) | Checks every task |
| Find by ID | O(n) | Traverses the list |
| Mark completed | O(n) | Finds the task by ID |
| Delete by ID | O(n) | Searches for the node to remove |

The search result collection uses an `ArrayList`; adding each match is amortized O(1).

## Limitations

- Tasks are stored in memory, so they are cleared when the program exits.
- The application is designed as a simple console-based academic project.
- Task titles are plain text; editing and due dates are not included.

## Possible Future Improvements

- Save and load tasks using a file or database.
- Add task priorities and due dates.
- Add an option to edit task titles.
- Filter tasks by pending or completed status.
- Build a graphical user interface.

## Academic Note

This project is intended for learning and demonstrating basic Data Structures and Java programming concepts. You can explain the linked-list node structure, traversal, deletion, ArrayList usage, and linear search during your practical viva.

---

**Developed by Harshwardhan Tiwari**
