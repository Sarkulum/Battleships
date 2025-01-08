# Description #
A fairly simplistic Battleships game. The bot pics all positions (ships and where to fire) at random. The player can input there name and age which currently is not used. They can input coordinate separated by "," to shot. While placing the ships they can also decide the orientation by adding ",V" or ",H" after the coordinates.  

# To-Do #
- Add an age gate.
- Add a score.
- Add a file to save name and high score of player.
- Add some more text to some of the println.

# The following issues are currently present in the code: #
- The Overlapping detection in GameControler.placeShip does not work properly and detects an overlap if to ships are next to each other.
- Need to add some line breaks as console output does not look good.
- Need to add println when ship is not placed because of overlap/out of bounds.
- Some try catch might be needed to avoid game crashes.
- Need to make a victory message.
- Hit or miss messages are in the wrong function. They should be in PlayerControler

# Note!!! #
X and Y need to be swapped inside the code for player so that X is first int and y is second. This is usually not the case. Might be because of String conversion.