# The following issues are currently present in the code: #
- The Overlapping detection in GameControler.placeShip does not work properly and detects an overlap if to ships are next to each other.
- BotControler.placeBotShips does not seam to work as it does not end. Might be because of improper random number generation.
- Need to add some line breaks as console output does not look good.
- Need to add println when ship is not placed because of overlap/out of bounds.
- Some try catch might be needed to avoid game crashes.
- Misses and hits are displayed on the player map.
- Still need to add fog of war.

# Note!!! #
X and Y need to be swapped for player so that X is first int and y is second. This is usually not the case. Might be because of String conversion.