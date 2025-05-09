# Candy Mountain: Extra Practice

This exercise is to give you extra practice with the basic setup of coding exercises on MarkUs
as you are learning Java.

## Specification

This coding exercise is about a game involving candy.
There is a place called Candy Mountain, which initially has a randomly chosen amount
of candies in the range 0 to 99 inclusive that are not owned by any player.
When a player gives some candies to the Candy Mountain, the player gets back twice that
number of candies from the Candy Mountain. However, if the amount owed to the player is
more than what the Candy Mountain has to give, the player will not get any candies back
(the player loses the candies they gave).

## Step 0

- Start a new IntelliJ project containing the starter code you downloaded from MarkUs.
- Complete steps 1 and 2, and upload your completed code to MarkUs.

## Step 1

Define a class `CandyPlayer` with:

- one private static variable: the number of candies in the Candy mountain (int) Note: this variable is already there in the starter code
  - a static getter, called `getMountainCandy`, for this static variable
- one private instance variable: the number of candies this CandyPlayer has (int)
  - a public getter, called `getMyCandy`, for this instance variable
- a constructor that takes one parameter that represents this CandyPlayer's initial number of candies (int)
- a method called play() that takes the number of candies to give to the Candy mountain (int) and
  returns true if and only if the input number is less than or equal to the number of candies that this CandyPlayer has.
  Update the number of candies that each of this CandyPlayer and the Candy mountain has. Refer to the following example:

```java
CandyPlayer.getMountainCandy(); // Suppose this returns 50
CandyPlayer player = new CandyPlayer(80); // player will start with 80 candies
player.play(100); // this returns false
player.play(20); // this returns true
CandyPlayer.getMountainCandy(); // this returns 30
player.getMyCandy(); // this returns 100 since the player gave 20 to the Candy mountain and got 40 from the mountain
player.play(50); // this returns true
CandyPlayer.getMountainCandy(); // this returns 80 because 100 > 80
player.getMyCandy(); // this returns 50
```

Your code should pass some of the basic tests in test/CandyPlayerTests.java. When you finish Step 2, your code should pass
all the provided tests.

## Step 2

You will now add "turns" to the game. Now, each CandyPlayer gets assigned a unique id that depends on the number of players.
The first player gets id 0. The second player gets id 1, and so on. A turn is an id of one of the players and should initially
be set to 0. A player can play the candy game only when its id is the same as the current turn.

To implement this, do the following:

- add two private static variables: the current turn (int) and the number of players in the game (int)
  - add static getters and setters for these two variables (`getTurn`, `setTurn`, `getNumberOfPlayers`, and `setNumberOfPlayers`)
- add one private instance variable: the unique id of this CandyPlayer (int)

- modify the play method from Step 1 so that it returns false if this CandyPlayer's id is not the same as the current turn or the current player tries to make an illegal play.
  If a player tries to play when it is someone else's turn, the turn is not changed.
  After a player plays its turn, the turn is increased by 1 (or goes back to 0 if the turn is equal to the number of players after
  being incremented).
  Note that even if the argument of the method play is greater than the number of candies of this CandyPlayer, the turn still moves
  to a next player. Refer to the following example:

```java
CandyPlayer.getMountainCandy(); // Suppose this returns 50
CandyPlayer player0 = new CandyPlayer(80); // player0 will start with 80 candies
CandyPlayer player1 = new CandyPlayer(20); // player1 will start with 20 candies
player0.play(100); // note: this still returns false, since it was player0's turn, but they made an illegal play
player0.play(20); // this returns false, since it was (and still is) player1's turn
player1.play(20); // this returns true, since it was player1's turn
CandyPlayer.getMountainCandy(); // this returns 30
player1.getMyCandy(); // this returns 40 since player1 gave 20 to the Candy mountain and got 40 from the mountain
player0.play(50); // this returns true, since it was player0's turn
CandyPlayer.getMountainCandy(); // this returns 80 because 100 > 80
player0.getMyCandy(); // this returns 30, since player0 gave 50 to the Candy mountain and got 0 from the mountain
```


Now your code should pass all the provided tests if implemented correctly.

**Make sure to upload your `CandyPlayer.java` file to MarkUs and run the autotests.**
