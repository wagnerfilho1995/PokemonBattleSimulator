"""
Pokemon Battle Simulator

Play Pokemon in Python! You can choose wether to play with Pikachu or Charmander, and your opponent will always be the other Pokemon.
"""

class Pokemon(object):
	def __init__(self, element, health, move1, move2, move3, move4):
		self.element = element
		self.health = health
		self.move1 = move1
		self.move2 = move2
		self.move3 = move3
		self.move4 = move4
	def __repr__(self):
		return "I am a Pokemon"

Pikachu = Pokemon("electric", 60, "Thunderbolt", "Electro Ball", "Iron Tail", "Volt Tackle")
Charmander = Pokemon("fire", 60, "Flamethrower", "Skull Bash", "Tackle", "Heat Crash")

print("Pikachu is of type", Pikachu.element + ".", "It has", str(Pikachu.health) + " health.", "It knows", Pikachu.move1, ",", Pikachu.move2, ",", Pikachu.move3, ",and", Pikachu.move4 + ".", "\n")

print("Charmander is of type", Charmander.element + ".", "It has", str(Charmander.health) + " health.", "It knows", Charmander.move1, ",", Charmander.move2, ",", Charmander.move3, ",and", Charmander.move4 + ".", "\n")

yourPick = str(input("Which Pokemon would you like to play with? Pick 'P' for Pikachu or 'C' for Charmander."))
opponentPick = None
if yourPick == "P":
    print("You have picked to play with", Pikachu.name)
    yourPick = Pikachu
    opponentPick = Charmander
elif yourPick == "C":
     print("You have picked to play with", Charmander.name)
    yourPick = Charmander
    opponentPick = Charmander