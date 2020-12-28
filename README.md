# DINS_QA_Automation_Intern_Task

This application is a client part of the application "Phonebook". 

#### Functional ####
This application execute 4 tests:
1) POST new User;
2) GET this user by User ID;
3) Try to PUT changes for userdata to nonexistent user;
4) Try to delete nonexistent user.

#### Application launch ####
You have two ways.
I. For run application from command line you you have to:
1) Install Maven Apache (https://maven.apache.org/install.html);
2) Run command "mvn surefire-report:report"
After this in your project at path "\target\site\" will be create "surefire-report.html".

II. If you don't want to install Maven Apache, you can open project and execute command "mvn surefire-report:report". Result will be same that in first way.
