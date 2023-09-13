# CS5004-photo-album
A photo album animator application that creates 2D animations from shapes using Model-View-Controller architecture, decoupling the description of an algorithm or phenomenon from its visual representation on the screen. This separation will enable the creation of an application that will render an animation according to its textual description.


# Manuel
- command-line arguments explanation
```Java
in "name-of-command-file" -view "type-of-view" [-out "where-output-should-go"] [xmax] [ymax]
```
-in "name-of-animation-file"
-out "where-output-show-go"
-view "text", "svg", "visual", or "playback"

For example: 
```
MyProgram -in buildings.txt -out myWeb.html  -v web
MyProgram -in buildings.txt -v graphical 800 800
```


# MVC Design
1. model
   - Album
   - IAlbum Interface
2. view
   - GraphicalView
   - Panel
   - SVGView
3. controler
   - Controller
4. shape
   - AbstractShape
   - IShape Interface
   - Color, Oval, Position, Recatangle class
5. utility
   - FilePars
