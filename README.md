# The following issues are currently present in the code: #
- The Overlapping detection in GameControler.placeShip does not work properly and detects an overlap if to ships are next to each other.
- Need to add some line breaks as console output does not look good.
- Need to add println when ship is not placed because of overlap/out of bounds.
- Some try catch might be needed to avoid game crashes.
- Need to make a victory message.
- Hit or miss messages are in the wrong function. They should be in PlayerControler

# Note!!! #
X and Y need to be swapped for player so that X is first int and y is second. This is usually not the case. Might be because of String conversion.