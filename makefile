# Make file for OS Two assignment
# Nyashadzaishe Bryan Katemauswa

LIB = ../lib
SRCDIR = src
BINDIR = bin
TESTDIR = test
DOCDIR = doc
BARRIERPACKAGE = BarrierS

JAVAC = javac
JFLAGS = -g -d $(BINDIR) -cp $(BINDIR):$(JUNIT)

vpath %.java $(SRCDIR):$(TESTDIR)
vpath %.class $(BINDIR)

.SUFFIXES: .java	.class

.java.class:
	$(JAVAC)	$(JFLAGS) $<

all: Barrier.class\
	BThread.class\
	BarrierTest.class
	

doc: all
	javadoc -d $(DOCDIR) $(SRCDIR)/*.java

testclasses: all
	javac $(JFLAGS) $(TESTDIR)/*.java

test: testclasses
	java -ea -cp $(BINDIR):$(JUNIT) org.junit.runner.JUnitCore JunitTestSuite

run: 
	@java -cp $(BINDIR) $(BARRIERPACKAGE).BarrierTest 8 12

clean:
	@rm -f $(BINDIR)/*.class
	@rm -f doc/*
