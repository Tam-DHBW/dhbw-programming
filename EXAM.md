# Welcome to the Learning Outcomes Evaluation

Dear students,

Welcome to this Learning Outcomes Evaluation session. The goal is to assess your understanding and mastery of the learning outcomes for this semester as evidenced by your work that was submitted on your personal git account. Remember to answer each question thoroughly by referencing **Java** code and provide clear explanations where necessary.

Best regards,
Kay Berkling

## Ethics Section regarding generative and other forms of AI

The student acknowledges and agrees that the use of AI is strictly prohibited during this evaluation. By submitting this report, the student affirms that they have completed the form independently and without the assistance of any AI technologies. This agreement serves to ensure the integrity and authenticity of the students work, as well as their understanding of the learning outcomes.


## Checklist before handing in your work

* [ ] Review the assignment requirements to ensure you have completed all the necessary tasks.
* [ ] Double-check your links and make sure that links lead to where you intended. Each answer should have links to work done by you in your own git repository. (Exception is Speed Coding)
* [ ] Make sure you have at least 10 references to your project code (This is important evidence to prove that your project is substantial enough to support the learning outcome of object oriented design and coding within a larger piece of code.)
* [ ] Include comments to explain your referenced code and why it supports the learning outcome.
* [ ] Commit and push this markup file to your personal git repository and hand in the link and a soft-copy via email at the end of the designated time period.

Remember, this checklist is not exhaustive, but it should help you ensure that your work is complete, well-structured, and meets the required standards.

Good luck with your evaluation!

# Project Description (70%)


## Link

https://github.com/NewStudy2024/dhbw-discord-bot

## TECH STACK

- Build system
    - Gradle
- Discord API
    - JDA (Java Discord API)
    - JDA-Chewtils (Command creation)
- Github GraphQL API
    - Apollo GraphQL client
- JSON serialization/deserialization
    - Kotlin serialization
- Rapla calendar parsing
    - ICal4J didn’t work
    - Built my own
- Logging
    - slf4j
    - logback
- Deployment
    - Docker


## What did you achieve? 

An automated discord user (bot) to help the students of our course.
Its features consist of:

- Display the Rapla calendar on Discord
    - Shows the schedule for the current day
    - Automatically updates itself
    - Automatic timezone localization for the viewer of the calendar
    - Notify students 5 minutes before a lecture starts
    - Button to indicate one is late for the lecture
    - Works by fetching `ical` calendar data from https://dhbw.app
    - Custom Stream/lambda based `ical` format parser to retrieve calendar data
- Github Blog discussion notifications
    - Send a notification with discussion title and a link to the discussion that was created on a repository of a student
    - Was relevant last semester when we had to do the coding blog
    - Remembers which discussions were already sent into the notification channel
    - Commands to track/untrack/list repositories
    - Untrack command has autocompletion of tracked repositories
    - Uses the github GraphQL API for the discussion data
    - I used the Apollo GraphQL client library and wrote a GraphQL query
- Deadline tracker
    - Students can add and delete deadlines which are then displayed in a list with automatic rainbow coloring.
    - Deadlines include: Title, description and due date
    - Makes heavy use of discord's interaction api to create buttons lists and modals:
        - Button to add deadline
        - Modal to fill out deadline data
        - Select list with autocompletion for deleting deadlines
- Replaceable backend (On which platforms the bot can run)
    - Discord backend implemented
        - Using JDA discord api wrapper
    - Possibly matrix support in the future without having to rewrite the whole project




## Learning Outcomes

| Exam Question | Total Achievable Points | Points Reached During Grading |
|---------------|------------------------|-------------------------------|
| Q1. Algorithms    |           4            |                               |
| Q2.Data types    |           4            |                               |
| Q3.Complex Data Structures |  4            |                               |
| Q4.Concepts of OOP |          6            |                               |
| Q5.OO Design     |           6            |                               |
| Q6.Testing       |           3            |                               |
| Q7.Operator/Method Overloading | 6 |                               |
| Q8.Templates/Generics |       4            |                               |
| Q9.Class libraries |          4            |                               |


## Evaluation Questions

Please answer the following questions to the best of your ability to show your understanding of the learning outcomes. Please provide examples from your project code to support your answers.


## Evaluation Material


### Q1. Algorithms

Algorithms are manyfold and Java can be used to program these. Examples are sorting or search strategies but also mathematical calculations. Please refer to **two** areas in either your regular coding practice (for example from Semester 1) or within your project, where you have coded an algorithm. Do not make reference to code written for other classes, like theoretical informatics.

- My ICAL calendar format parser if you count that as an algorithm:
https://github.com/NewStudy2024/dhbw-discord-bot/blob/82f9acf66d27b97b09130b9f51ce21ee3e1ec189/src/main/java/dhbw/mos/bot/cal/IcsParser.java#L21
- Algorithm for blurring a heatmap image:
https://github.com/Tam-DHBW/dhbw-programming/blob/d78c239135df43961c788bd8af0bcb2a29c65c51/pollutionmap/src/main/java/dhbw/tam/pollutionmap/HeatMap.java#L35
- Algorithm for transposing a matrix if you dont think the first one is an algorithm:
https://github.com/Tam-DHBW/dhbw-programming/blob/d78c239135df43961c788bd8af0bcb2a29c65c51/app/src/main/java/dhbw/tam/loops/Main.java#L74


| Total Achievable Points | Points Reached During Grading |
|------------------------|-------------------------------|
|                        |                               |
|           4            |                               |


### Q2. Data types

Please explain the concept of data types and provide examples of different data types in Java.
typical data types in java are int, double, float, char, boolean, long, short, byte, String, and arrays. Please provide one example for each of the **four** following data types in your code.
* arrays
* Strings
* boolean
* your choice


A data type usually groups one or more values. When creating a variable the data type has to be specified to hint what kind of data we want to store in the variable, like numbers (int) or text (String).

- Array:
    https://github.com/NewStudy2024/dhbw-discord-bot/blob/82f9acf66d27b97b09130b9f51ce21ee3e1ec189/src/main/java/dhbw/mos/bot/cal/IcsParser.java#L55
    Stores possibly multiple results from string splitting
- Strings:
    https://github.com/NewStudy2024/dhbw-discord-bot/blob/82f9acf66d27b97b09130b9f51ce21ee3e1ec189/src/main/kotlin/dhbw/mos/bot/config/Config.kt#L15
    Stores the API token for github
- Boolean
    https://github.com/NewStudy2024/dhbw-discord-bot/blob/82f9acf66d27b97b09130b9f51ce21ee3e1ec189/src/main/java/dhbw/mos/bot/cal/CalendarRoutine.java#L57
    Method returns a boolean to indicate whether two time slots overlap
- List (my choice):
    https://github.com/NewStudy2024/dhbw-discord-bot/blob/82f9acf66d27b97b09130b9f51ce21ee3e1ec189/src/main/java/dhbw/mos/bot/cal/CalendarService.java#L20
    The CalendarService keeps track of a list of events


| Total Achievable Points | Points Reached During Grading |
|------------------------|-------------------------------|
|                        |                               |
|           4             |                               |



### Q3. Complex Data Structures

Examples of complex data structures in java are ArrayList, HashMap, HashSet, LinkedList, and TreeMap. Please provide an example of how you have used **two** of these complex data structures in your code and explain why you have chosen these data structures.

1:
https://github.com/Tam-DHBW/dhbw-programming/blob/d78c239135df43961c788bd8af0bcb2a29c65c51/logisim/src/main/java/dhbw/tam/logisim/CircuitUI.java#L33
Used a ArrayList here to store multiple points, and have the ability to add more points to the list dynamically.

2:
https://github.com/Tam-DHBW/dhbw-programming/blob/d78c239135df43961c788bd8af0bcb2a29c65c51/algorithms/src/main/java/dhbw/mos/algorithms/Fibonacci.java#L23
Used a HashMap so cache and read the results from previous iterations by key in O(1) time


| Total Achievable Points | Points Reached During Grading |
|------------------------|-------------------------------|
|                        |                               |
|           4             |                               |


### Q4. Concepts of OOP
Concepts of OOP are the basic building blocks of object-oriented programming, such as classes, objects, methods, and attributes. 
Explain HOW and WHY your **project** demonstrates the use of OOP by using all of the following concepts:
* Classes/Objects
* Methods
* Attributes 
Link to the code in your project that demonstrates what you have explained above.

- Classes:
    https://github.com/NewStudy2024/dhbw-discord-bot/blob/82f9acf66d27b97b09130b9f51ce21ee3e1ec189/discord/src/main/java/dhbw/mos/bot/discord/DiscordBackend.java
    The DiscordBackend class contains the functionality to handle the Discord backend implementation
    It is required to implement the Backend interface, which the common code requires.
    It abstracts away the backend implementation so the common code does not ahve to wrorry about the platform
- Methods:
    https://github.com/NewStudy2024/dhbw-discord-bot/blob/82f9acf66d27b97b09130b9f51ce21ee3e1ec189/discord/src/main/java/dhbw/mos/bot/discord/DiscordBackend.java#L81
    Method to post a new discussion notification in discord
    Required, as the common code does not know how to post something on discord, so the implementation is provided by a method and the call site does not have to know about the implementation
- Attributes:
    https://github.com/NewStudy2024/dhbw-discord-bot/blob/82f9acf66d27b97b09130b9f51ce21ee3e1ec189/discord/src/main/java/dhbw/mos/bot/discord/DiscordBackend.java#L38
    The DiscordBackend has the configManager attribute for storing the class responsible for reading and writing the configuration file, so it can access the config later on aswell


| Total Achievable Points | Points Reached During Grading |
|------------------------|-------------------------------|
|                        |                               |
|             6           |                               |

### Q5. OO Design
Please showcase **two** areas where you have used object orientation and explain the advantage that object oriented code brings to the application or the problem that your code is addressing.
Examples in java of good oo design are encapsulation, inheritance, polymorphism, and abstraction. 

https://github.com/NewStudy2024/dhbw-discord-bot/blob/82f9acf66d27b97b09130b9f51ce21ee3e1ec189/discord/src/main/java/dhbw/mos/bot/discord/DiscordBackend.java#L38
The DiscordBackend class contains the functionality to handle the Discord backend implementation.
It abstracts the implentation away and encapsulates the data it needs
It also implements the Backend interface, so through polymorphism the common code can work with multiple backends, making the project more modular and flexible.

https://github.com/NewStudy2024/dhbw-discord-bot/blob/82f9acf66d27b97b09130b9f51ce21ee3e1ec189/discord/src/main/java/dhbw/mos/bot/discord/commands/ListTrackedRepositories.java
The ListTrackedRepositories command inherits from `SlashCommand`.
This means a lot of the functionality required for discord commands is already provided, which makes creating them a lot simpler.


| Total Achievable Points | Points Reached During Grading |
|------------------------|-------------------------------|
|                        |                               |
|              6          |                               |



### Q6. Testing
Java code is tested by using JUnit. Please explain how you have used JUnit in your project and provide a link to the code where you have used JUnit. Links do not have to refer to your project and can refer to your practice code. If you tested without JUnit, please explain how you tested your code.
Be detailed about what you are testing and how you argue for your test cases. 

Feel free to refer to the vibe coding session where you explored testing. (pair programming - you may link to your partner git and name him/her.)

Test cases usually cover the following areas:
* boundary cases
* normal cases
* error cases / catching exceptions 

I do not have any unit tests, since they take a lot of time to write by hand and maintain. I also dont use AI to writem them for me.
My code is tested by trial and error, however good programming practices avoid many bugs which testing would catch.
The tests generated in the vibe coding lecture were so bad i had to delete them later again.

| Total Achievable Points | Points Reached During Grading |
|------------------------|-------------------------------|
|                        |                               |
|         3               |                               |

### Q7. Operator/Method Overloading
An example of operator overloading is the "+" operator that can be used to add two numbers or concatenate two strings. An example of method overloading is having two methods with the same name but different parameters. Please provide an example of how you have used operator or method overloading in your code and explain why you have chosen this method of coding.
The link does not have to be to your project and can be to your practice code.

https://github.com/NewStudy2024/dhbw-discord-bot/blob/82f9acf66d27b97b09130b9f51ce21ee3e1ec189/src/main/java/dhbw/mos/bot/Util.java#L8-L21
Here i have overloaded the `scheduleAtRate` method to be able to choose, whether i provide an initial delay or not.
Doing so i dont have to always add Duration.ZERO to the parameters when i dont want to add a delay to the scheduling

| Total Achievable Points | Points Reached During Grading |
|------------------------|-------------------------------|
|                        |                               |
|          6              |                               |



### Q8. Templates/Generics
Generics in java are used to create classes, interfaces, and methods that operate on objects of specified types. Please provide an example of how you have used generics in your code and explain why you have chosen to use generics. The link does not have to be to your project and can be to your practice code.


https://github.com/NewStudy2024/dhbw-discord-bot/blob/82f9acf66d27b97b09130b9f51ce21ee3e1ec189/src/main/kotlin/dhbw/mos/bot/config/ConfigManager.kt#L11
https://github.com/NewStudy2024/dhbw-discord-bot/blob/82f9acf66d27b97b09130b9f51ce21ee3e1ec189/discord/src/main/java/dhbw/mos/bot/discord/DiscordBackend.java#L38

The ConfigManager is generic over the backend configuration class.
This allows storing of different configuration values depending on the backend


| Total Achievable Points | Points Reached During Grading |
|------------------------|-------------------------------|
|                        |                               |
|           6             |                               |

### Q9. Class Libraries
Examples of class libraries in java are the Java Standard Library, JavaFX, Apache Commons, JUnit, Log4j, Jackson, Guava, Joda-Time, Hibernate, Spring, Maven, and many more. Please provide an example of how you have used a class library in your **project** code and explain why you have chosen to use this class library. 

Dependencies in gradle:
https://github.com/NewStudy2024/dhbw-discord-bot/blob/82f9acf66d27b97b09130b9f51ce21ee3e1ec189/discord/build.gradle.kts#L18-L20
Imports from class library:
https://github.com/NewStudy2024/dhbw-discord-bot/blob/82f9acf66d27b97b09130b9f51ce21ee3e1ec189/discord/src/main/java/dhbw/mos/bot/discord/DiscordBackend.java#L16-L26

Rewriting the discord api wrapper from scratch would have taken ages.
When using the library i can simply built on the work others have dont already and dont reinvent the wheel.


| Total Achievable Points | Points Reached During Grading |
|------------------------|-------------------------------|
|                        |                               |
|            6            |                               |


# Creativity (10%)
Which one did you choose: 

* [ ] Web Interface with Design
* [ ] Database Connected
* [ ] Multithreading
* [ ] File I/O
* [ ] API
* [ ] Deployment

- File I/O
    - Reading and writing the JSON configuration file
- API
    - Using with dhbw.app, discord, and github apis
- Deployment
    - Gradle shadow plugin for building a fat-jar with all dependencies
    - Dockerfile for containerizing and deploying the application




| Total Achievable Points | Points Reached During Grading |
|------------------------|-------------------------------|
|                        |                               |
|            10          |                               |



# Speed Coding (20%)
Please enter **three** Links to your speed coding session GITs and name your partner. 

Grade manager with Meenakshi:
https://github.com/Tam-DHBW/dhbw-programming/tree/d78c239135df43961c788bd8af0bcb2a29c65c51/grade-manager

Car rental with David:
https://github.com/Tam-DHBW/dhbw-programming/tree/d78c239135df43961c788bd8af0bcb2a29c65c51/car-rental

Brainfuck interpreter with Daniel:
https://github.com/Tam-DHBW/dhbw-programming/tree/d78c239135df43961c788bd8af0bcb2a29c65c51/brainfuck


Paste your class diagram for your project that you developed during the peer review class here: 

Brainfuck class diagram:
https://github.com/Tam-DHBW/dhbw-programming/blob/e0af8ef9049025c49989b1cdafa9795b563da59b/bf_diagram.png

It can be done very simply by just copying any image and pasting it while editing Readme.md.


| Total Achievable Points | Points Reached During Grading |
|------------------------|-------------------------------|
|                        |                               |
|            16            |                               |





