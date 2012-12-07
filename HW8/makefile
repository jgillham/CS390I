ZIPFILE=Exercises.zip

zip: $(ZIPFILE)

$(ZIPFILE) : *.java
	rm -f *.zip
	zip -r $@ . -x *.zip -x *.class -x *.ctxt -x makefile

clean:
	rm -f *.zip *.class *.ctxt
