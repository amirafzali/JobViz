JFLAGS = -g
JCLASS = -cp ./src:.:$(CLASSPATH):/mnt/c/Users/kitch/Documents/junit4-4.5.jar
JC = javac
JVM = java
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $(JCLASS) $*.java

CLASSES = \
	src/SalaryT.java \
	src/SalariesT.java \
	src/ParseT.java \
    src/HashT.java \
    src/ApplicationT.java \
    # src/TestPointT.java \
    # src/TestLanduseMapT.java \
    # src/TestDemT.java \
    # src/TestPointT.java \
	# src/AllTests.java \

MAIN = AllTests

default: classes

classes: $(CLASSES:.java=.class)

# doc:
# 	doxygen doxConfig
# 	cd latex && $(MAKE)

test: src/$(MAIN).class
	$(JVM) $(JCLASS) org.junit.runner.JUnitCore $(MAIN)

clean:
	rm -rf html
	cd src
	rm **/*.class
