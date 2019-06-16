**Spark-Drools**

This is a project which integrates Spark 2.x with Drools Rule Engine

Here we have explored, how Spark 2.x can use its feature to send the Drools
Rule base to the data and not send the data to the rule engine. This pattern can be leveraged to apply 
Drools Rule of a huge volume of data efficiently and in a performant way.

To read more about, how we have achieved this, please read the blog:



**Running in Local using IntelliJ**

1. To run this project in local using intelliJ, download & install intelliJ
2. Install Scala plugin in IntelliJ
3. You can run eith ScalaBeanRuleTestDriver or JavaBeanTestDriver.
4. To run either of these classes, go to run Run > Edit Configuration.
5. Click + and select Application
6. On the Application window, Set the name of the runconfig; browse and select the appropriate main class, set the working directory correctly and in VM arguments add -Dspark.master=local. Click Ok.
7. Click the Run button after selecting appropriate Run config that was setup in step 6.