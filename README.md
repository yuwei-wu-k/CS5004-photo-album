# CS5004-photo-album

Many of us use our phones (and cameras) to take pictures of friends and family members,
and then share those pictures in photo albums.

Pictures can be used to succinctly and effectively illustrate many things.
For example, a stationary histogram visually depicts the distribution of some data points.
A histogram with moving bar heights visually depicts music (e.g. a music equalizer).

This application creates a simple "photo album" from shapes using Model-View-Controller architecture.

I created four packages, model, controller, utility, and view for my Shapes Photo Album.

The model represents a shapes photo album.

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
