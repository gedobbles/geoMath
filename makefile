CLASSES = Ebene  GeoMath  Gerade  MathGUI  Vektor

all: $(CLASSES)

start: geomath.sh
	bash geomath.sh

geomath.sh: all
	echo "#!/bin/bash\n	cd bin\n	java GeoMath" > geomath.sh

%: src/%.java
	javac -cp bin -d bin $<
