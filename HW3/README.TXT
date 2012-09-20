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
ASSIGNMENT:

Your design for the Hangman application should have provided an API that includes the signatures of all publicly visible entities (e.g., interfaces, classes, methods).

1. Based on your design/API, create a BlueJ project that contains skeletal classes (that is, source code that implements all of the public classes and methods and compiles without error).

2. Create a unit test class for each of the public classes.

3. Create test methods for each publicly visible method that returns a value. Strive to create tests that adequate assess the correctness of the behaviors of the methods.

API Outline

Game - holds scores, stats, and accepts game actions.

Manager - tracks team scores, stats, and keeps a list of players.

Player - tracks player stats, scores, and accepts player actions.

Dictionary - holds word data bank and has game-related methods.


VOCABULARY:

Player Up - the player who has the turn to guess.

Team - each player in the game belongs to a team even with one player and each team has a manager.

Manager - have the information about the team like the score and also a team. roster.

Roster - each team has a list of players.

Game Word - the word that players in the game will try to guess.

Status Word - the word that has the same length of the game word but starts with underscores masking the real letters and as players find the letters, they will be replaced.

Active Team - the team who has the turn to guess.

Line Up - the order on which players are listed on the roster.



VISION:

This project is currently under development. Work is being done to create an interface that will blueprint the design for the classes in this project.
 
The current theory on the relationship of these classes is under developement. As of today it thought that the GUI will contain the main() function. 

The main will call the dictionary initialization procedure and launch the game setup form. This form will prompt the user for the length of the word, and the maximum attempts to solve. The player choose to have different teams and add players to each team, but, the default is to have only one player. The user hits the start button and the game will begin.
 
The start button will launch a new window for the game and also create a new game class. The start button will also add teams and players onto the roster of each team. Each team will have a manager class or else with just one player there will be just one manager class.  The game will select a team to go first according to its rules (random number?). The GUI can call a method to see which team is up and which player is up. Now the first round of the game begins!

The player who is first will make a guess. Players may, at their choice, guess the entire word or guess a letter. If the guess is invalid (contains non-alphabetic characters i. e. '?' or '9'), then the player should try again. If the guess is found in the game word, the player scores a point or else the player gets one wrong and in either case the player's turn is over. Now the opposite team gets to guess and they try their first player and this repeats while the max guesses have not been exceeded or the word has not been guessed.

Once the word is guessed or the max attempts have been exceeded, then the game ends and one team may be awarded.

Players may resign from the game. If all players in the team resign from the game, the team looses the
 game.

FUNCTIONAL BEHAVIOR:

Game class:

The constructor for the game class should accept two arguments: the max attempts and the game word length. It should set a the game word with the dictionary getRandomWord( withLength ) function. It should retain a copy of max attempts.

Calls to getStatusWord(), before the game begins, should return a String the length of the game word length and every character should be an underscore.  Calls to getStatusWord(), after the game has began, should show that the first value of status word has mutated with the player guesses that were found in the word.

Calls to getActiveTeam(), before the game begins, should throw an error. Calls to getActiveTeam(), after the game began, should return a Manager class and subsequencial calls should rotate teams.

Calls to startGame() should throw an error when there are empty teams in the game.

Calls to makeGuess( Player, char ) should throw an error if either the guess is invalid or the player is not front player for the active team. Otherwise, the return will be true when the letter was found and false if not. All guess will be recorded. The score will be counted. The players on the active team will be rotated with a call to nextPlayer().

Calls to makeGuess( Player, String ) should have the same behavior as the function it overloads except that String will be compared with the game word.

Calls to resignTeam( Manager ) should thow an error if the Manager is not part of the game or is null. Otherwise should remove the team from the game. The active team may be changed if it is the same as the team that was removed. If there is zero teams remaining, there is no winner. If there is one team remaining, that team is the winner.

Calls to nextTeam() should throw an error if there are no teams in the game. Otherwise move active team to the next team to make a guess.

Manager class:

The constructor for the Manager class will accept the team name. For bad names an error will be thrown. It should retain the name. The score will be set to 0.

Calls to addPlayer( String ) accept the player name. For bad names an error will be thrown. The player will be added to the roster. The return will be the new player.

Calls to getScore() will return the current score for the team.

Calls to getRosterSize() will return the List.size() for the team roster.

Calls to getPlayerUp() will throw an error when getRosterSize() is zero. Otherwise will return the player up.

Calls to nextPlayer() will throw an error when getRosterSize() is zero. Otherwise will set the player up to the next player in the line up.

Calls to resign( Player ) will throw an error when  getRosterSize() is zero or the Player is not on the roster. Otherwise will remove the player from the roster. If the Player is the player up, then the game will set the next player up. If there are no players on the roster after the removal, the Game.resign( Manager ) will be called.


Player class:

The constructor for the Player class will accept the player name and the a reference to the team Manager class. For bad names or null Manager refereneces an error will be thrown. It should retain the name and a manager reference. The score will be set to 0 and the history will be initialized. 

Calls to getHistory() will return a String with all the player's guesses or an empty String for no guesses.

Calls to getScore() will return the total guesses found in the game word.

