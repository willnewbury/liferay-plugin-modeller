# liferay-plugin-modeller

This ant project can be used to auto generate an entity relationship diagram for Liferay 6.2 portlet.
As a proof of concept, we created an adaptor to output a simple text file, which can then be converted into a graphical entity relationship diagram using [erd](https://github.com/BurntSushi/erd)

## Produce text file
1. Clone git repo
2. In folder that you cloned into:
	* create a folder named "output" next in the highest level folder (next to src
	* ant clean compile  
	* ant process-xmls -Dportlet.base.dir="PATH TO PORTLET BASE DIR"  

This will generate a ServiceXMLProcessing.er in the output directory

## INSTALL ERD

Follow instructions on [erd] to install [Haskell](http://www.haskell.org/platform/) and [GraphViz](http://www.graphviz.org/Download..php) for your platform.

### Linux
1. In terminal, sudo apt-get install haskell-platform  
2. sudo cabal install erd  

### Windows
1. Install Haskell and GraphViz and add to PATH environment variables
2. cabal update
3. cabal get erd-0.1.3.0 (might need to run cabal install <dependency> if you run into any errors)

## Visualize
 Navigate to the erd folder:  
	./erd -i PATH TO OUTPUT DIR/ServiceXMLProcessing.er -o DESIRED OUTPUT PATH
