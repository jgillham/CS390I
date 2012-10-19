PROJECT TITLE: Hangman
PURPOSE OF PROJECT: To turn in as a class assignment
VERSION or DATE: 9-17-12
HOW TO START THIS PROJECT:
In BlueJ, run SetupUI.main( null );
TODO:
Documentation coverage.
Testing Evil Logic

AUTHORS: Josh Gillham
ASSIGNMENT:
Extend the Hangman project with another version of the game in which the program delays selecting a single target word as long as possible. Instead of choosing a target word, the program should continually maintain a set of candidate words that match the previous guesses. When necessary, the program should choose a random entry from that set of words to reveal as the target word.

Note that for this assignment you may choose to turn in the project as late as 11:55PM on October 21. However, be aware that scores for assignments turned in between 11:55PM on October 19 and 11:55PM on October 21 will be multiplied by 0.75 so this should be considered a tactic of last resort. Note also that any assignments turned in after 11:55PM on October 21 will receive a score of 0.

Submit one file, named evilhangman.zip, that is a zipped archive of an entire BlueJ project directory. Ensure that your source code has proper javadoc comments (including @author tags for the classes) and at least some basic unit tests in associated test classes.

Include a reflection about learning that occurred during the experience of completing this assignment in the Notes section.

Add new features to the original game. The program will wait until later to decide the game word.

When the player makes a guess the program will divide the words into a set that contains the guess and ones that don't.

The program will select the set with most words.

When the next guess occurs the program repeats this process with the selected sets.

When the selected set only has one word left, then program choose it as the game word.


This will cause the odds to always be stacked against the player at every guess.


GOALS/TODO:

Test coverage in testGame.

Test coverage in testManager.

Test coverage in testPlayer.

Test coverage in testDictionary.

Test coverage in testFormGameSetup.

Test coverage in testFormGamePlay.

Test coverage in testHangman.

Update and improve README.TXT.

Update documentation.



VOCABULARY:

Player Up - the player who has the turn to guess.

Team - each player in the game belongs to a team and each team has a manager. A team must have at least one player.

Manager - has the information about the team like the score and also a team roster.

Roster - each team has a list of players.

Game Word - the word that players in the game will try to guess.

Status Word - the word that has the same length of the game word but starts with underscores masking the real letters and as players find the letters, they will be replaced.

Active Team - the team who has the turn to guess.

Line Up - the order on which players are listed on the roster.

DESCRIPTION:

The game of hangman has a setup where the teams are picked and players are added to the teams. The maximum guesses and length of the word is decided. This is all the information needed to setup the game.

For a game with only one team, there is only one player. That player will make all the guesses in the game.

For a game with more than one team, the teams will compete and try to guess the game word. The game rotates through each team allowing them to guess. For example, the game starts with one team guessing first and then the second and so on. After the last team has guessed then the order repeats.

Within a team, there is a player roster. The order of the roster decides which player is first. When a team guesses, the first player on the roster guesses. The next time the team guesses the second player will guess and so on. After the last player has guessed, the first player guesses again.

When a team guesses the word, they win the game. They can win either by guessing the word, by guessing all the letters in the word, or a combination of the two.

Teams can also give up (or resign) from the game. The resigning team automatically looses. The game will continue without the resigning team unless there are no teams left in the game. A team maybe forced to resign when all the players resign.

VISION:

The main will setup (bootstrap) the game. The dictionary will be initialized and the setup form will be launched. This form will prompt the user for the length of the word, and the maximum attempts to solve. The player choose to have different teams and add players to each team, but, the default is to have only one player. Currently, the game will support only one player. When the user hits the start button, the UI will signal through the GameEvent callback.
 
Once the setup is completed successfully, a new game window will show up and the game will begin. The game defaults to having the first added team and player go first. The first team will make a guess. The player may guess the entire word or only a letter. When guessing the entire word, a good guess wins the game for the team. When guessing a single letter, a good guess will change the status word to show the letter's positions. After the guess is made, the manager designates the next player on the roster to guess later on and the game rotates to the next team. The guessing continues while the total guesses is below the maximum attempts.

If the player makes an invalid guess like, for example, an '?'. The player will be alerted. The game will signal this through an exception.

FUNCTIONAL BEHAVIOR:

Dictionary class:


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

UICallback class:

Calls to playerToMakeGuess( char ) will make a call to Game.makeGuess( char ) when the player using the UI makes a letter guess. Will throw an error if the input is bad.

Calls to playerToMakeGuess( String ) will make a call to Game.makeGuess( String ) when the player using the UI wants to guess the whole word. Will throw an error if the input is bad.

Calls to setupComplete( int, int ) will create a new instance of the Game class with the appropriate parameters. Will throw an error if the input is bad.

UI class:

Calls to gameOver() will update the UI showing the player that the game is over.

Calls to teamUp( Manager ) will show which team is up for guessing.

Calls to playerUp() will show which player is up for guessing.

Calls to gameWinner( Manager ) announces which team has won.



