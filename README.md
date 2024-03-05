# LibraryManager

## Borrowing Limit Requirement:
- REQ001: A user who is a student can borrow a maximum of 7 books.
- REQ002: A user who is a lecturer can borrow a maximum of 14 books.
- REQ003: A user who is a non-student can borrow a maximum of 4 books.

## Borrowing Time Limit Requirement:
- REQ004: A user who is a student can have a maximum of 6 weeks of books on loan.
- REQ005: A user who is a lecturer can have a book borrowed for a maximum of 10 weeks.
- REQ006: A user who is a non-student can have a book borrowed for a maximum of 4 weeks.

## Requirements for Adding Books:
- REQ007: The librarian should be able to add new books to the library collection with detailed information such as title, author, ISBN, etc.
- REQ008: The librarian should be able to remove books from the library collection by providing the UUID (barcode on the book) number if they are no longer available or current.

## Additional Features:
- REQ009: The system should store a loan history for each user, allowing them to view previous loans and return dates.
- REQ010: Users should be able to reserve books that are currently borrowed by other users.
- REQ011: The book reservation system should prioritize first the lecturer, then the student, and finally the non-university users.
- REQ012: Users should be able to extend the loan period of a book.
- REQ013: The system should charge penalties, 10gr for each day of delay up to and including 6 months, and then 15gr per day.
- REQ014: The librarian returning the book should enter the grade that the user provided from 1 to 10.
- REQ015: The librarian should be able to track the number of available copies of each book in the library collection, including copies borrowed and available for loan. Books can be searched by ISBN, Author, or Title - without regex implementation.
- REQ016: The system should handle edge cases, such as the lack of available copies of a book, in which case the user should be able to sign up for a waiting list for that book and receive notifications when the book becomes available.
- REQ017: The system should automatically block the ability to borrow new books for users who have unpaid book hold fees above a certain limit (e.g., 30 days overdue).
- REQ018: The system should lock the user, when he exceeds the deadlines for returning books too often, the maximum number of delays is 3 times up to 1 month or once up to six months

## Non-Functional Requirements:
- The system should be able to load data into the database from a CSV file.
- The system should have the ability to save data from the database to a CSV file.
- The system shall be based on PostgreSQL database.