FILES = Ebene.class
FILES += GeoMath.class
FILES += Gerade.class
FILES += MathGui.class
FILES += Vektor.class


all: $(FILES)

%.class : %.java
	javac -d ../bin $<
