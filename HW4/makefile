ZIPFILE=hangman.zip

zip: $(ZIPFILE) *.java
	zip -fr $(ZIPFILE) . -x *.zip -x *.class -x *.ctxt

$(ZIPFILE) :
	zip -r $@ . -x *.zip -x *.class -x *.ctxt

clean:
	rm -f *.zip *.class *.ctxt
