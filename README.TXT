------------------------------------------------------------------------
This is the project README file. Here, you should describe your project.
Tell the reader (someone who does not know anything about this project)
all he/she needs to know. The comments should usually include at least:
------------------------------------------------------------------------

PROJECT TITLE: Hangman
PURPOSE OF PROJECT: To turn in as a class assignment
VERSION or DATE: 9-17-12
HOW TO START THIS PROJECT:
AUTHORS: Josh Gillham
USER INSTRUCTIONS:

DESCRIPTION:

This project is currently under developement. Work is being done to create an interface that will
 blueprint the design for the classes in this project.
 
The current theory on the relationship of these classes is under developement. As of today
 it thought that the GUI will contain the main() function. The main will call the dictionary
 initialization proceedure and launch the game setup form. This form will prompt the user for
 the length of the word, and the maximum attempts to solve. The user hits start and the game will begin.
 
The start button will launch a new window for the game and also create a new game class. The game class
 will in turn create a manager to handle the players. The GUI will create the teams in the game and add
 each player onto the roster for that team. The game will select a team to go first according to its
 rules (random number?). The GUI can call a method to see which team is up and which player is up. Now
 the first round of the game begins!

The player who is first will make a guess. Players may, at their choice, guess the entire word or guess
 a letter. If the guess is invalid (contains non-alphabetic characters), then the player should try
 again (i. e. '?' or '9' ). If the guess is found in the game word, the player scores a point or else
 the player gets one wrong and in either case the player's turn is over. Now the opposite team gets to
 guess and they try their first player and this repeats while the max guesses have not been exceeded or
 the word has not been guessed.

Players may resign from the game. If all players in the team resign from the game, the team looses the
 game.


