"""
PokemonBattleSimulator.py

Play Pokemon in Python! You can choose wether to play with Pikachu or Charmander, and your opponent will always be the other Pokemon. Now with FIRE-WATER-GRASS type pokemon and type effectivity bonuses!
"""
import random

#Pokemon Object Constructor
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

#Pokemon Move Function fire-water-grass effectivity
def Attack(yourDamage, opponentDamage):
	if yourPick.element == 'water' and opponentPick.element == 'fire':
		yourTypeBonus = 2.0
		opponentTypeBonus = 0.5
	elif yourPick.element == 'fire' and opponentPick.element == 'water':
		yourTypeBonus = 0.5
		opponentTypeBonus = 2.0
	elif yourPick.element == 'grass' and opponentPick.element == 'fire':
		yourTypeBonus = 0.5
		opponentTypeBonus = 2.0
	elif yourPick.element == 'fire' and opponentPick.element == 'grass':
		yourTypeBonus = 2.0
		opponentTypeBonus = 0.5
	elif yourPick.element == 'water' and opponentPick.element == 'grass':
		yourTypeBonus = 0.5
		opponentTypeBonus = 2.0
	elif yourPick.element == 'grass' and opponentPick.element == 'water':
		yourTypeBonus = 2.0
		opponentTypeBonus = 0.5
	yourPick.health -= yourDamage * opponentTypeBonus
	opponentPick.health -= opponentDamage * yourTypeBonus

#Creation of Pokemon
Squirtle = Pokemon("Squirtle", "water", 120, "Water Gun", "Hydro Cannon", "Skull Bash", "Aqua Jet")
Charmander = Pokemon("Charmander", "fire", 120, "Flamethrower", "Skull Bash", "Tackle", "Heat Crash")
Bulbasaur = Pokemon("Bulbasaur", "grass", 120, "Vine Whip", "Grass Knot", "Tackle", "Energy Ball")

#Explanation of Pokemon
print("Squirtle is of type", Squirtle.element + ".", "It has", str(Squirtle.health) + " health.", "It knows", Squirtle.move1, ",", Squirtle.move2, ",", Squirtle.move3, ",and", Squirtle.move4 + ".", "\n")
print("Charmander is of type", Charmander.element + ".", "It has", str(Charmander.health) + " health.", "It knows", Charmander.move1, ",", Charmander.move2, ",", Charmander.move3, ",and", Charmander.move4 + ".", "\n")
print("Bulbasaur is of type", Bulbasaur.element + ".", "It has", str(Bulbasaur.health) + " health.", "It knows", Bulbasaur.move1, ",", Bulbasaur.move2, ",", Bulbasaur.move3, ",and", Bulbasaur.move4 + ".", "\n")

#Asking User Input for which Pokemon they want to battle with
yourSelection = int(input("Which Pokemon would you like to play with? Pick the corresponding number for that Pokemon"))
opponentSelection = random.random()

#Setting a Pokemon to user
if yourSelection == 1:
    yourPick = Squirtle #NOTE: yourPick inherits methods of the other Poké
    if opponentSelection >= 0.5:
    	opponentPick = Charmander
    else:
    	opponentPick = Bulbasaur
    print("You have picked to play with", yourPick.name)
elif yourSelection == 2:
    yourPick = Charmander
    if opponentSelection >= 0.5:
    	opponentPick = Squirtle
    else:
    	opponentPick = Bulbasaur
    print("You have picked to play with", yourPick.name)
elif yourSelection == 3:
	yourPick = Bulbasaur
	if opponentSelection >= 0.5:
		opponentPick = Charmander
	else:
		opponentPick = Squirtle
	print("You have picked to play with", yourPick.name)
else:
	print("That is not a Pokemon. Try again")
print("Your opponent is", opponentPick.name)

#Game Loop
while(yourPick.health >= 0 and opponentPick.health >= 0):
    print(yourPick.name, "has", yourPick.health, "health left.", opponentPick.name, "has", opponentPick.health, "health left.")
    print(yourPick.name, "knows:\n", yourPick.move1, "\n", yourPick.move2, "\n", yourPick.move3, "\n", yourPick.move4)
    yourMove = int(input("Type the number of the move you would like to use corresponding to the name as it appeared above. Pick '5' to regen 6% of your max health.\n"))
    yourRegen = 0.06 * yourPick.health
    opponentRegen = 0.06 * opponentPick.health
    if(yourMove == 1):
        Attack(0, 20)
        print(yourPick.name, "used", yourPick.move1, "\n")
    elif(yourMove == 2):
        Attack(0, 22)
        print(yourPick.name, "used", yourPick.move2, "\n")
    elif(yourMove == 3):
        Attack(10, 30)
        print(yourPick.name, "used", yourPick.move3, "\n")
    elif(yourMove == 4):
        Attack(4, 25)
        print(yourPick.name, "used", yourPick.move4, "\n")
    elif(yourMove == 5):
        Attack(-1 * yourRegen, 0)
        print(yourPick.name, "regenerated", yourRegen, "health points!")
    else:
        print("That is not a move")
        
    opponentMove = random.randint(1,5)

    if (opponentMove == 1):
        Attack(20, 0)
        print(opponentPick.name, "used", opponentPick.move1, "\n")
    elif(opponentMove == 2):
        Attack(22, 0)
        print(opponentPick.name, "used", opponentPick.move2, "\n")
    elif(opponentMove == 3):
        Attack(30, 10)
        print(opponentPick.name, "used", opponentPick.move3, "\n")
    elif(opponentMove == 4):
        Attack(25, 4)
        print(opponentPick.name, "used", opponentPick.move4, "\n")
    elif(opponentMove == 5):
        Attack(0, -1 * opponentRegen)
        print(opponentPick.name, "regenerated", opponentRegen, "health points!")
    else:
        print("That is not a move")
if yourPick.health >= 0 and opponentPick.health <= 0:
    print(yourPick.name, "won!")
    print(opponentPick.name, "fainted.")
else:
    print("Sorry, better luck next time!")
    print(yourPick.name, "fainted.")