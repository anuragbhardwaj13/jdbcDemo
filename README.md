# JDBC Demo Documentation

## Introduction

This is a simple Java program demonstrating basic operations using JDBC (Java Database Connectivity) to interact with a MySQL database. The program allows the user to create, read, update, and delete records in a database table named "Member."

## Prerequisites

Before running the program, ensure that you have the following set up:

- Java Development Kit (JDK) installed
- MySQL server installed and running
- MySQL Connector/J library in the classpath

## Getting Started

1. **Database Connection:**

   The program establishes a connection to the MySQL database using the following connection string:

   ```
   jdbc:mysql://localhost:3306/jdbcdemo?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC
   ```
   Here ```jdbcdemo``` is the name of Database.

   Modify the connection URL, username, and password in the `getConnection` method if needed.

2. **Run the Program:**

   Compile and run the program using the following commands:

   ```bash
   javac Main.java
   java Main
   ```

## Usage

### Create Records

1. Run the program and enter "yes" when prompted to enter values.
2. Follow the prompts to provide first name, last name, etc.
3. Continue entering more records until you choose to stop.

### Read Records

The program will automatically display the existing records after the creation phase.

### Update Records

1. Enter "yes" when prompted to update records.
2. Provide the ID of the record to be updated.
3. Choose the field (first name or last name) to update.
4. Enter the new value.

### Delete Records

1. Enter "yes" when prompted to delete records.
2. Provide the ID of the record to be deleted.

### Final Table

The program displays the updated table after all operations are completed.

## Example

Here's an example of how the program flow might look:

```plaintext
Do you want to enter any value?
Answer 'yes' or 'no':
> yes

---------CREATE---------
Enter First:
> John
Enter Last:
> Doe
Do you want to enter more value?
Answer 'yes' or 'no':
> yes

Enter First:
> Jane
Enter Last:
> Smith
Do you want to enter more value?
Answer 'yes' or 'no':
> no

The SQL statement is: select id, age, first, last from Member

---------READ---------
id | age | first | last
1 | 5 | John | Doe
2 | 10 | Jane | Smith
Total number of records = 2

---------UPDATE---------
Do you want to update any record?
Answer 'yes' or 'no':
> yes

What user do you want to update?
Please enter ID:
> 2
What field do you want to update?
For first name, enter 'first'
For last name, enter 'last':
> last
What is the new value which you want?:
> Johnson

Updated Row
id | age | first | last
2 | 10 | Jane | Johnson

Do you want to update any more record?
Answer 'yes' or 'no':
> no

---------DELETE---------
Do you want to delete any record?
Answer 'yes' or 'no':
> yes

What record do you want to delete?
Please enter ID:
> 1

Record deleted successfully
Do you want to delete any more record?
Answer 'yes' or 'no':
> no

---------FINAL TABLE---------
id | age | first | last
2 | 10 | Jane | Johnson
Total number of records = 1
```

## Troubleshooting

- Ensure that the MySQL server is running.
- Check the connection parameters in the `getConnection` method.
- Verify that the MySQL Connector/J library is in the classpath.

## Conclusion

This program provides a basic understanding of JDBC operations for interacting with a MySQL database.