### Tic Tac Toe LLD

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

### 3. confirm the aligned requirements: 
- 3x3 board
- two human players
- alternating turns between x and o
- move validation to ensure no invalid moves
- detection of win or draw scenarios

### 4. Identify Key Components:
- 

     


