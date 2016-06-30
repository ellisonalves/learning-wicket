# wicket-learning
This document is about my study of Wicket 7.3.0.

All directories of samples were created using the quick start from wicket official home page.

To run the modules, you just:
- to have maven installed on your environment;
- to move to the project you want to see running;
- run the maven command: mvn jetty:run

## Wicket usefull links

[WicketStuff] (https://github.com/wicketstuff/core)
[Wicket-tutorial-examples] (https://github.com/bitstorm/Wicket-tutorial-examples)
		

## Quickstart
You can use the wicket page to generate your quickstart project using the following link https://wicket.apache.org/start/quickstart.html.

I used the maven command as the follow for all subprojects.

```
mvn archetype:generate -DarchetypeGroupId=org.apache.wicket -DarchetypeArtifactId=wicket-archetype-quickstart -DarchetypeVersion=7.3.0 -DgroupId=com.mycompany -DartifactId=myproject -DarchetypeRepository=https://repository.apache.org/ -DinteractiveMode=false
```

There is a README.me inside of the each subdirectory where I write down about what I have found important during my studies.
		
		
		
	
