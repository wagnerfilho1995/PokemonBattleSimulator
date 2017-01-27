"""
PokemonBattleSimulator.py

Play Pokemon in Python! You can choose wether to play with Pikachu or Charmander, and your opponent will always be the other Pokemon.
"""
import random

#Pokemon Object Creator
class Pokemon(object):
	def __init__(self, name, element, health, move1, move2, move3, move4):
		self.name = name
		self.element = element
		self.health = health
		self.move1 = move1
		self.move2 = move2
		self.move3 = move3
		self.move4 = move4
	def __repr__(self):
		return "I am a Pokemon"

#Creation of Pokemons
Pikachu = Pokemon("Pikachu", "electric", 60, "Thunderbolt", "Electro Ball", "Iron Tail", "Volt Tackle")
Charmander = Pokemon("Charmander", "fire", 60, "Flamethrower", "Skull Bash", "Tackle", "Heat Crash")

#Explanation of Pokemons
print("Pikachu is of type", Pikachu.element + ".", "It has", str(Pikachu.health) + " health.", "It knows", Pikachu.move1, ",", Pikachu.move2, ",", Pikachu.move3, ",and", Pikachu.move4 + ".")
print("Charmander is of type", Charmander.element + ".", "It has", str(Charmander.health) + " health.", "It knows", Charmander.move1, ",", Charmander.move2, ",", Charmander.move3, ",and", Charmander.move4 + ".", "\n")

#Asking User Input for which Pokemon they want to battle with
yourPick = str(input("Which Pokemon would you like to play with? Pick 'P' for Pikachu or 'C' for Charmander."))
opponentPick = None

#Setting a Pokemon to user
if yourPick == "P":
    yourPick = Pikachu #NOTE: yourPick inherits methods of the other Poké
    opponentPick = Charmander
    print("You have picked to play with", yourPick.name)
elif yourPick == "C":
    yourPick = Charmander
    opponentPick = Pikachu
    print("You have picked to play with", yourPick.name)
else:
	print("That is not a Pokemon. Try again")

#Game Loop
while(yourPick.health >= 0 and opponentPick.health >= 0):
    print(yourPick.name, "has", yourPick.health, "health left.", opponentPick.name, "has", opponentPick.health, "health left.")
    print(yourPick.name, "knows:\n", yourPick.move1, "\n", yourPick.move2, "\n", yourPick.move3, "\n", yourPick.move4)
    yourMove = int(input("Type the number of the move you would like to use corresponding to the name as it appeared above.\n"))
    if(yourMove == 1):
        opponentPick.health -= 10
        print(yourPick.name, "used", yourPick.move1, "\n")
    elif(yourMove == 2):
        opponentPick.health -= 12
        print(yourPick.name, "used", yourPick.move2, "\n")
    elif(yourMove == 3):
        opponentPick.health -= 20
        print(yourPick.name, "used", yourPick.move3, "\n")
    elif(yourMove == 4):
        opponentPick.health -= 15
        yourPick.health -= 5
        print(yourPick.name, "used", yourPick.move4, "\n")
    else:
        print("That is not a move")
        
    opponentMove = random.randint(1,4)

    if opponentMove == 1:
        yourPick.health -= 10
        print(opponentPick.name, "used", opponentPick.move1, "\n")
    elif(opponentMove == 2):
        yourPick.health -= 12
        print(opponentPick.name, "used", opponentPick.move2, "\n")
    elif(opponentMove == 3):
        yourPick.health -= 20
        print(opponentPick.name, "used", opponentPick.move3, "\n")
    elif(opponentMove == 4):
        yourPick.health -= 15
        opponentPick.health -= 5
        print(opponentPick.name, "used", opponentPick.move4, "\n")
    else:
        print("That is not a move")
    
if yourPick.health >= 0 and opponentPick.health <= 0:
    print(yourPick.name, "won!")
    print(opponentPick.name, "fainted.")
else:
    print("Sorry, better luck next time!")
    print(yourPick.name, "fainted.")