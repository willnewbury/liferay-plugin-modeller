# liferay-plugin-modeller

Steps to use on linux:

1. Clone git repo

2. In folder that you cloned into:
	ant clean deploy
	ant process-xmls -Dportlet.base.dir="PATH TO PORTLET BASE DIR"

This will generate a ServiceXMLProcessing.er in the output directory

3. in terminal, sudo apt-get install haskell-platform

4. sudo cabal install erd

5. navigate to place where it installed the erd bin:
	./erd -i PATH TO OUTPUT DIR/ServiceXMLProcessing.er -o DESIRED OUTPUT PATH
