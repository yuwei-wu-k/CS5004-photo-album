Based on hw8, I deleted ShapeType enum class since there are already concrete shape class (oval and rectangle)
to represent type. Then I created other three packages, controller, utility, and view for my Shapes Photo Album.

For views, I implemented graphical view and web/SVG view.

In GraphicalView class, I used Java Swing to create three panels to hold different components.
north panel: snapshots ID and description
center panel: current snapshot
south panel: prev, select, next, and quit buttons

For SVGView class, as this is a textual output of the photo album, I applied StringBuilder to product
html text and with outputFile method I can write the content to a new file.

The Panel as a helper class is responsible for drawing shapes for GraphicalView class.

As Controller class manages and coordinates information flow between the modeland views,
I created two constructors and visible methods, each corresponding to a View class.
To handle interactions with buttons in the graphic View, I also added a helper method
called actionPerformed that performs different actions based on which button is clicked.

The FileParse class is to read from a text file that the model will execute.

Finally, the PhotoAlbumMain class is the entry of the program. I made it to adjust the
command-line arguments to make sure it works for valid input according to the given instruction.