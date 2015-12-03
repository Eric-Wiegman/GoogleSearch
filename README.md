TABLE OF CONTENTS
-----------------
<ol>
<li> Introduction  </li>
<li> Statement of Work </li>
<li> Requirements </li>
<li> What was automated </li>
<li> Project (Location, Structure) </li>
<li> API Documentation (Javadoc) </li>
<li> Command-line Invocation </li>
<li> Output (Expected) </li>
<li> Explanation of Issues seen with Automation Exercise </li>
</ol>


1. Introduction
---------------------------------------------------------------------------
This is the README.md file for the Wells Fargo Digital Channel Technology  
Quality Assurance Group Code Assessment exercise presented to Eric Wiegman
as part of his consideration for the _"Senior Automation Engineer"_ position

2. Statement of Work
------------------------------
 I have created a Web Automation framework and associated tests, written with 
 Java and Selenium Webdriver that perform the following:
 
<br>Search Google for "12345" and verify, in order:
<br>1 The results page appears
<br>2 There is an image (map) link
<br>4 The link's url starts with "http://www.google.com/maps/place"
<br>5 The search box contains the text "12345"


 Maven is used as the tool to perform the build and deploy the test (running 
 the TestNG suite with the surefire plugin).


3. Specified Project Requirements
-------------------------------------------------------------
The requirement is

Write automation code in Java and Selenium Webdriver that perform the following:
 
<br>Search Google for "12345" and verify, in order:
<br>1 The results page appears
<br>2 There is an image (map) link
<br>4 The link's url starts with "http://www.google.com/maps/place"
<br>5 The search box contains the text "12345"

3.1. Notes on Requirements
--------------------------
1. The actual map link URL (checked in many browsers) is:
<br> "https://www.google.com/maps/vt"


4. The following is a general outline of what was automated:
---------------------------------------------------------------------------
1. This is a simple exercise, and no further explanation needs to be said
beyond what has already been stated above.


5. Project Location and Structure
---------------------------------------------------------------------------
1. Project is stored on GitHub at public repository Eric-Wiegman/GoogleSearch.

6. Directory Structure
---------------------------------------------------------------------------
1. The directory structure is shown below:

<pre>
.
│   pom.xml
│
├───src
│   ├───main
│   │   ├───java
│   │   │   └───com
│   │   │       └───google
│   │   │           └───testing
│   │   │               ├───utils
│   │   │               │       Consts.java
│   │   │               │       package-info.java
│   │   │               │       Utilities.java
│   │   │               │
│   │   │               └───webtestsbase
│   │   │                       BasePage.java
│   │   │                       Browser.java
│   │   │                       package-info.java
│   │   │                       WebDriverFactory.java
│   │   │
│   │   └───resources
│   │       │   resources.properties
│   │       │   testng.xml
│   │       │
│   │       ├───chromedriver_linux32
│   │       │       chromedriver
│   │       │       readme.md
│   │       │
│   │       ├───chromedriver_mac32
│   │       │       chromedriver
│   │       │       readme.md
│   │       │
│   │       └───chromedriver_win32
│   │               readme.md
│   │
│   └───test
│       └───java
│           ├───pages
│           │       LandingPage.java
│           │       ResultsPage.java
│           │
│           └───testNG
│                   GoogleSearchTests.java
</pre>

6.2 Please note that the directory structure is important, and file/directory
    changes should **not** be made. Failure to leave the structure as is will
    cause Maven, the surefire plugin, or other tools to not recognize the
    classpath items correctly, leading to failures.

7. API Documentation (Javadoc)
------------------------
Sorry, this was not done for this project. If desired, I can quickly whip up some more 
extensive Javadoc comments and generate the API Documentation.

8. Command-line invocation
---------------------------
1. To call the test from the command line (from within your Windows (DOS)
    Command Prompt or Macintosh/Linux Terminal), you need to ensure some
    prerequisites have first been met.
2. You should have your path set so that it will recognize the Maven binary
    'mvn' no matter which directory you are currently browsing.
3. As it is required by Maven, if you have not already done so set your
    JAVA\_HOME environment variable to be where you installed your Java
    (for instance, 'C:\Program Files\Java\jdk1.8.0_40' if using defaults for
    Windows installation).
4. To simplify the command line call, you should use your Terminal to
    navigate to the directory where the desired pom.xml file is located.
    For this case, this is the directory 'GoogleSearch'.
    In that way, the command line call will assume there is only one POM file
     to be run and will assume it is in the current directory.

8.2. The following is the command line text to be entered in the Command Prompt
    or Terminal:

        mvn compile test

9. Output
---------
9.1. The command line output that I am seeing is shown below
<pre>
[INFO] Scanning for projects...
[INFO]
[INFO] ------------------------------------------------------------------------
[INFO] Building Google Search tests project 1.0-SNAPSHOT
[INFO] ------------------------------------------------------------------------
[INFO]
[INFO] --- maven-resources-plugin:2.5:resources (default-resources) @ google-search ---
[debug] execute contextualize
[WARNING] Using platform encoding (Cp1252 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] Copying 7 resources
[INFO]
[INFO] --- maven-compiler-plugin:2.3.2:compile (default-compile) @ google-search ---
[WARNING] File encoding has not been set, using platform encoding Cp1252, i.e. build is platform dependent!
[INFO] Compiling 2 source files to C:\Users\Eric the Boss\Documents\GitHub\GoogleSearch\target\classes
[INFO]
[INFO] --- maven-resources-plugin:2.5:resources (default-resources) @ google-search ---
[debug] execute contextualize
[WARNING] Using platform encoding (Cp1252 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] Copying 7 resources
[INFO]
[INFO] --- maven-compiler-plugin:2.3.2:compile (default-compile) @ google-search ---
[WARNING] File encoding has not been set, using platform encoding Cp1252, i.e. build is platform dependent!
[INFO] Compiling 2 source files to C:\Users\Eric the Boss\Documents\GitHub\GoogleSearch\target\classes
[INFO]
[INFO] --- maven-resources-plugin:2.5:testResources (default-testResources) @ google-search ---
[debug] execute contextualize
[WARNING] Using platform encoding (Cp1252 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] skip non existing resourceDirectory C:\Users\Eric the Boss\Documents\GitHub\GoogleSearch\src\test\resources
[INFO]
[INFO] --- maven-compiler-plugin:2.3.2:testCompile (default-testCompile) @ google-search ---
[INFO] Nothing to compile - all classes are up to date
[INFO]
[INFO] --- maven-surefire-plugin:2.14.1:test (default-test) @ google-search ---
[INFO] Surefire report directory: C:\Users\Eric the Boss\Documents\GitHub\GoogleSearch\target\surefire-reports
-------------------------------------------------------
 T E S T S
-------------------------------------------------------
Running TestSuite
Tests run: 4, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 23.477 sec
Results :
Tests run: 4, Failures: 0, Errors: 0, Skipped: 0
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 32.544s
[INFO] Finished at: Thu Dec 03 15:11:08 PST 2015
[INFO] Final Memory: 22M/138M
[INFO] ------------------------------------------------------------------------
</pre>
9.2. At the point where the 'Running TestSuite' is announced, Maven should call
    surefire, which in turn calls TestNG harness that runs the XML suite in
    Selenium Java code. This performs the steps outlined in README section 4.

9.3. The directory 'target' should be created in the root, where 
binaries and pass/fail report files are found.

9.4. To see a graphical representation of the pass/fail/skip data associated
    with the testNG Suite run, open the file /target/surefire-reports/index.html
    in your favorite browser.
    
