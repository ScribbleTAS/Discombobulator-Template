# Discombobulator-Template
Discombobulator is a preprocessor for Minecraft mods. This project is useful, if you create mods for multiple versions at once.

## Features
### Version blocks
You can define version specific code in the text via comments:

```java
	//#1.16.1
	System.out.println("Only enabled in 1.16.1 and above");
	//#end
```

In other versions this line will be commented out.

This works also with multiple version statements:
```java
	//# 1.15.2
//$$	System.out.println("Only enabled in 1.15.2 and above");
	//# 1.14.4
	System.out.println("Only enabled in 1.14.4 and above");
	//# end
```

Version blocks can be defined in the main build.gradle:

```groovy
discombobulator {
	versions = [
		"1.15.2: Fabric1.15.2",
		"1.14.4: Fabric1.14.4"
	]
}
```
where *1.15.2* is the name defining the version block and *Fabric1.15.2* being the folder that contains this version.

It's advisable to always go from highest version to lowest in the list, the order in the build.gradle dictates the order of how version blocks get processed!

The order can be reversed when adding `inverted = true` to the file.

### Patterns
Patterns are one line version blocks, which are useful for smaller changes.

Similar to version blocks, patterns are defined in the discombobulator block in the build.gradle:
```groovy
discombobulator {
	patterns = [
		GetWindow: [
			"def": "mc.window",
			"1.15.2": "mc.getWindow()"
		],
		GetMinecraft: [
			//etc...
		]
	]
}
```
*GetWindow* is the name of the pattern. *def* is the default behaviour and 1.15.2 is the behaviour for 1.15.2 and above.

We can apply the patterns in our code like so:

```java
System.out.println(mc.window); // @GetWindow;
```
This will simply replace the old value via String.replace depending on the version.

Multiple patterns can be applied to the same line:

```java
Minecraft.getMinecraft().setWindow(mc.window); // @GetWindow,GetMinecraft;
```

## Setup
Create a new project then clone this repository into it. You can then import the one or both gradle projects and rename them.

The preprocessor has 2 main gradle tasks:
- `preprocessBase` copies the src folder to all versions and preprocesses it.
- `preprocessWatch` watches over all source folders for changes and updates the base src when a change happens.

You should first do preprocessBase to setup your versions, then run the fabric specific tasks like genSources.

For coding, run preprocessWatch, preferrably in a seperate console window, as eclipse's content assist will not update when the task is started from the IDE.

