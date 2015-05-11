# git.Rubrica.Infosons
MVC based phone book java application \n
This is a phone book application in Java. It is designed following MVC design pattern, so it has a presentation layer,
implemented using Java swing library, a BC layer that builds a class that inherits from DefaultTableModel, and a Data layer
that writes and reads all the informations from a .txt file.
All the records will be saved within it using the format:

name1;surname1;address1;phone1;age1 
name2;surname2;address2;phone2;age2 
......... 

they will be retrieved at any subsequent run of the application. If the file doesn't exist, the application runs and behaves without problems, but it won't save anything.
