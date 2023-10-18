Problem Overview: Basic File Operations
Objective: Read the content of a given text file and display it to the console.

Concepts:
FileInputStream: This is an input stream for reading data from a File. It's typically used for reading byte-based data, like images, but can be used for text when wrapped with appropriate readers.

BufferedReader: It reads text from a character-input stream, buffering characters so as to provide for the efficient reading of characters, arrays, and lines. It's commonly wrapped around a FileReader.