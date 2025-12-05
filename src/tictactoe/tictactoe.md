### Tic Tac Toe LLD

This can be solved in two different ways 
1. component wise.(how you break down system and implement it with code quality)
  Time Complextiy - O(1) Space Complexity - O(N)
2. algorithmic wise.(how you optimize user operations)

Game : Be the first player who draws a line
horizontally, vertically or diagonally with your marks (X's or O's)

Rules:
- the game is won by the player who places their symbol in row , column or diagonal
- the first player to get three symbols in a row wins a game.
- once this condition is meet , the game ends immediately.

Draw condition:
if all grid cells are filled and no player has three symbols in a row , the game ends in a tie.

#### Illegal Moves: 
A player cannot :
- place cannot overwrite a symbol (either own or opponent's)
- move to a non-empty cell.

### Interview Setting LLD:

Candidate Flow:

### 1. Understand the system (concise enact of system):
   - we have 3x3 grid
   - two players take alternate turns marking spaces with X's and O's
   - game continues until:
     - one player gets three of their marks in a row.
     - the grid is completely filled,resulting draw.

Is this the kind of flow you had in mind?

### 2. Clarify Requirements (Keeping Extensibilty and concurrency in mind): ]
- Are we focusing on standard 3x3 board?
- will this be two player human game?  
- Timed game?
- Undo Operations?
- Spectate option?
- Statistics?

### 3. confirm the aligned requirements: 
- 3x3 board
- two human players
- alternating turns between x and o
- move validation to ensure no invalid moves
- detection of win or draw scenarios

### 4. Identify Key Components:
- Board with size nxn
- game
- player
- piece

Winner States:
- First
- second
- draw
- undecided

Board:
- init()
- getWinner()
- getBoardStatus()
- currentPlayer()
- makeMove(Move m) // algorithmic point 

User:
- userId
- stats
- updateStats()

Game:
- gameId
- userId1
- userId2
- List<Moves> ops
- init()
- undo()
- startGame()


### Intuition behind makeMove() and checking winner condition:

---

since we need to check for winner status each time we place a piece. it is evident that when we place a piece we need to squares in row wise, column wise , diagonal and reverse diagonal ways.
and let's say we are placing a piece at (0,2) in 3x3 board of tic tac toe
then we need to check row wise (0,0) (0,1) and (0,2)(row,col++) , column wise (0,2)(1,2)(2,2),(row++,col)
diagonal wise (0,0) (1,1) (2,2)(row++,col++)(if row==col) , and then reverse diagonal (0,2),(1,1),(2,0) (row++,n-i-1)

for any approach checking for valid move , valid player is same

check if it is going out of bounds , not correct player and overwriting condition(i.e. not empty cell)


##### Bruteforce :
- pick current player , and boolean variable win init with true.
- now check row wise , changing row and keeping col same . at any point if board has diff player than curr player. then change win to false and break out of loop(since we don't have consecutive same pieces in row).
- now check col wise , changing col and keeping row same . at any point if board has diff player than curr player. then change win to false and break out of loop(since we don't have consecutive same pieces in col).
- now check diagonal , if row and col same then only we check diagonal by changing both row and col with same pointer 
- similarly we need to check for reverse diagonal , if we are in (i,n-i-1) position.

This will make the algo to be O(4N).


##### Better:
- since runnning a loop and checking for win is same for all conditions.
- so we maintain 4 variables for 4 ways and check for conditions in single pass.
- if anything matches we change winner variable to false but here we won't break out of loop. since we need to check for other conditions as well.

Time Complexity - O(N)

Space Complexity - O(1)


##### Optimal:
- since we are running loop and checking each condition ,instead if we maintain a prefix sum kind of thing for each move he makes then we don't need to run a loop and check all cells in row,col,diag and rev diag.
- maintain rowSum and colSum array since they change in only one pointer . and maintain diag and reverseDiag variables since they are common in any situation.
- each time player makes a move , we check if sum 






     


