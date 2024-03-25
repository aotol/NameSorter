# Name Sorter Application Documentation

## Overview

The Name Sorter Application is a command-line utility designed to read a text file containing names, sort them alphabetically by last name, and then by given name (first name), and finally save the sorted names into a new text file.

## Usage

### Running the Application
To use Maven to build & run the Name Sorter Application, following the following steps:
1. Open a command-line interface (CLI) such as Terminal (macOS/Linux) or Command Prompt (Windows).
2. Navigate to the directory where the `pom.xml` file is located.
3. Execute command:
   ```
   mvn install 
   ```
4. Execute command:
   ```
   mvn clean compile exec:java
   ```
   The input file location `unsorted-names-list.txt` is defined in `pom.xml` at `line 28`.

To run the test cases, run the following commnad:
   ```
   mvn test
   ```

To use build and run the project without Maven, follow these steps:

1. Open a command-line interface (CLI) such as Terminal (macOS/Linux) or Command Prompt (Windows).
2. Navigate to the directory where the `App.java` file is located.
3. Compile the Java files using the Java compiler:
   ```
   javac App.java
   ```
4. Run the compiled Java application with the path to the input text file as the argument:
   ```
   java App <path_to_input_file>
   ```
   Replace `<path_to_input_file>` with the actual path to your input text file (e.g.: ./unsorted-names-list.txt).

### Input File Format

The input text file should contain a list of names, with each name on a separate line. Each name should follow the format `<first_name> <last_name>`, where `<first_name>` represents the given name(s) and `<last_name>` represents the last name. The application supports up to three given names for each name entry.

Example of a valid input text file:
```
John Smith
Alice Johnson
David Michael Brown
```

### Output File

The sorted names will be saved into a new text file named `sorted-names-list.txt` in the same directory where the application is run.
Note: This `sorted-names-list.txt` will be overwritten everytime when the code is executed according to the requriement.

### Error Handling

The application provides error handling for the following scenarios:

- Invalid input file path or file corruption.
- Incorrect name format in the input file.

In case of any errors, appropriate error messages will be displayed in the console along with a stack trace for further debugging.

## Dependencies

The Name Sorter Application relies on the following Java classes:

- `FileHelper`: Responsible for reading names from the input text file and writing sorted names to the output text file.
- `NameFormatException`: Custom exception class for handling invalid name formats.
- `FirstNameLastNameSorter`: Class for Name Sorter alphabetically by last name and then by given name.
- `NameFormatHelper`: Helper class for converting between string representations of names and `FirstNameLastName` objects.

## Development Environment

According to instruction: `We would like your solution to be written in a language of your choosing`, hence the application is developed in Java and requires a Java Development Kit (JDK) to compile and run. It has been tested and verified on various operating systems, including Windows, macOS, and Linux.

## Support and Feedback

For any issues, questions, or feedback regarding the Name Sorter Application, please contact Zhan Zhang.
