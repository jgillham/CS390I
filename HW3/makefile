ZIPFILE=HW3_HangmanAPI_JoshGillham.zip

zip: $(ZIPFILE) *.java
	zip -fr $(ZIPFILE) . -x *.zip -x *.class -x *.ctxt

$(ZIPFILE) :
	zip -r $@ . -x *.zip -x *.class -x *.ctxt

clean:
	rm *.zip
	rm *.class
	rm *.ctxt
