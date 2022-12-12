[![Open in Visual Studio Code](https://classroom.github.com/assets/open-in-vscode-c66648af7eb3fe8bc4f294546bfd86ef473780cde1dea487d3c4ff354943c9ae.svg)](https://classroom.github.com/online_ide?assignment_repo_id=8828933&assignment_repo_type=AssignmentRepo)


# Pip Boss
This repository has been set up to get you started in completing your capstone project.

## Contents
  * [Project Overview](#project-overview)
    + [Prioritized Features](#prioritized-features)
    + [Grading Scheme](#grading-scheme)
  * [Project Details](#project-details)
    + [Definition of Done](#definition-of-done)
    + [Prioritized Features](#prioritized-features-1)
  * [Technical Details](#technical-details)
    + [Prerequisites](#prerequisites)
    + [Building the Project](#building-the-project)
    + [Directory Structure](#directory-structure)
    + [IDE Setup](#ide-setup)
      - [Intellij](#intellij)
      - [Eclipse](#eclipse)
  * [Example Output](#example-output)


## Project Overview
-------------------
In this project, you will be creating a program that allows users to play a digital version of [Las Vegas Royale](https://boardgamegeek.com/boardgame/271319/las-vegas-royale).


### Prioritized Features
The core features for this project are broken into phases, where Phase 0 is of higher priority than Phase 1, etc. Feature 1 corresponds to Phase 0, and so forth.


### Grading Scheme
This project is worth 50 points (50% of the total grade for the course). These points are awarded in two ways. First, each of the 4 sprints end in a sprint review, at which point your team's work is evaluated. Each sprint is worth a maximum of 10 points for each member of the team. (Except in highly unusual circumstances, all members receive the same grade for a sprint.) Second, the final 10 points are determined according to how many features you complete by the project's final deadline. That scale is as follows, determined by the **final feature** that your team completes:

| Phase   | Points |
|---------|--------|
| 0       | 0      |
| 1       | 0      |
| 2       | 0      |
| 3       | 0      |
| 4       | 0      |
| 5       | 1      |
| 6       | 2      |
| 7       | 3      |
| 8       | 4      |
| 9       | 6      |
| 10      | 8      |
| 11      | 10     |
| 12      | 12     |
| 13      | 15     |

Note that it is possible to receive more than 10 points for this component, with any additional points counting as "bonus" toward the final course grade.


## Project Details
------------------

### Definition of Done
The *definition of done* for **any** feature is that it passes all automated acceptance tests, has a codebase that achieves at least 85% branch coverage from its unit tests, and has a fully documented user guide.

### Console Output
The console version of the game should always provide standardized, specific output as the game progresses. See the [example output](#example-output). In any cases where the dice must be specified, the format should be "[A, B, C]" where A, B, C, etc., where those values are digits 1-6. In the event that a large die is used, its value should be listed as "A+A" (e.g., 4+4) to denote that it represents 2 dice. In any cases where a player is specified, the format should be "PX" (e.g., P1, P2, etc.). Dollar amounts are given in units of 10,000 (e.g., $30,000 in the board game would correspond to $3 in this implementation). Finally, any singular/plural units should be output accordingly (e.g., chip/chips, die/dice, etc.).

* Lifecycle Updates - The user should be notified at each stage of the game as follows:
    * Game Start: "The game has started. It will consist of X round(s) and have Y player(s). Each player has M regular die(ce) and N large die(ce) with C chip(s) per round."
    * Round Start: "Round X has started."
    * Round End: "Round X has ended."
    * Game End: "The game is over. The final game state is below." (followed by the game state)
* Player Actions - The user should be notified of player actions as follows:
    * Dice Rolled: "PX rolled [DICE]." (where DICE is described above)
    * Dice Placed: "PX placed [DICE]." (where DICE is described above)
    * Chip Used: "PX used a chip and has Y chip(s) left."
    * Chips Added: "PX gained Y chip(s): REASON"
    * Chips Lost: "PX lost Y chip(s): REASON"
    * Money Added: "PX gained $Y: REASON"
    * Money Lost: "PX lost $Y: REASON"
* Casino Updates - The user should be notified of changes to casinos as follows:
    * Dice Added: "Casino X gained [DICE] from PY."
    * Dice Removed: "Casino X lost [DICE] from PY."
    * Minigame Added: "Casino X added the minigame NAME."
    * Minigame Updated: "The minigame NAME at Casino X has the following update: UPDATE"

The game state should have **exactly** the following format (using values for the example):
```
----------------------------      PLAYERS      ----------------------------
 player : money  dice  DICE  chips                                         
     P1 :     3     0     1      4
     P2 :     3     0     0      2
     P3 :     4     1     0      2

----------------------------      CASINOS      ----------------------------
  #   $$   $     P1   P2   P3                                              
 [1]   5   3 :  $$2                                                        
 Pay Day - Gain $1 for each casino where you have presence.                
 [2]   6   3 :       $$1                                                   
 Black Box - During payout, the winner plays a split/choose for additional 
winnings.                                                                  
 [3]   6   3 :    3    3  $$2                                              
 Lucky Punch - Choose 1, 2, or 3 to win 2 chips, $3, or $4.                
 [4]   7   3 :  $$2                                                        
 [5]   8   5 :       $$5  $ 1                                              
 [6]   8   6 :            $$5                                              
```

The player information should specify the number of remaining regular dice ("dice") and large dice ("DICE"). The casino information should specify the casino number ("#"), the large payout ("$$"), the small payout ("$"), and the number of dice belonging to each player ("P1", etc.). The current winner of the large payout should have "$$" before their allocated dice number. Likewise, the current winner of the small payout should have "$" before their allocated dice number. Any minigame at a casino should list its name and summary below the casino's row. Any line in the output has a maximum width of 75 characters and should be broken at whitespace if the line exceeds that amount.


### Prioritized Features

#### Phase 0
The user should be able to play a console version of the game that lasts only a single round, has only a single player, and that player has only 7 standard dice and no chips.  

#### Phase 1
Same as Phase 0 but now the player gains 2 chips at the start of the round.

#### Phase 2
Same as Phase 1 but now the player has 1 large die as well as the 7 regular dice.

#### Phase 3
Same as Phase 2 but now the player has 2 AI opponents that play aggressively, where they always place the most dice possible each turn.

#### Phase 4
Same as Phase 3 but with 3 rounds instead of only 1 (with chips allocated accordingly each round).

#### Phase 5
Same as Phase 4, but now the minigame Jackpot should be added to Casino 1. 

#### Phase 6
Same as Phase 5, but now the minigame Pay Day should be added (randomly assigning it to Casino 1 or 2 with Jackpot assigned to the other).

#### Phase 7
Same as Phase 6, but now the minigame Fifty Fifty should be added (randomly assigning the 3 minigames each to one of the lowest 3 casinos). The AI opponents play this game as follows:
* If the payout is $0, they roll.
* If the mark is between 5 and 8, inclusive, they stop and take the payout.
* If the mark is less than 5, they choose higher/more.
* If the mark is greater than 8, they choose lower/less.

#### Phase 8
Same as Phase 7, but now the minigame Lucky Punch should be added (dropping Jackpot and randomly assigning the other 3 as before). The AI opponents should randomly choose an option in all cases.

#### Phase 9
Same as Phase 8, but now the minigame High Five should be added (dropping Pay Day and randomly assigning the other 3 as before).

#### Phase 10
Same as Phase 9, but now the minigame Black Box should be added (dropping Fifty Fifty and randomly assigning the other 3 as before). The AI opponents should take the larger split 75% of the time when they are the active player, and they should randomly assign to the 2 groups if they are not the active player. 

#### Phase 11
Same as Phase 10, but now the minigame Block It should be added (dropping Lucky Punch and randomly assigning the other 3 as before). The AI opponents should randomly choose a group of blocking dice and assign them to a randomly chosen casino.

#### Phase 12
Same as Phase 11, but now the minigame Bad Luck should be added (dropping High Five and randomly assigning the other 3 as before).

#### Phase 13
Add a graphical user interface to allow playing the game as in Phase 12.




## Technical Details
--------------------
### Prerequisites
This project assumes that you have already [installed Java 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html) on your system. 

### Building the Project
After you have cloned the repository, you should be able to navigate to the root directory containing the **gradle.build** file. There, you can build the project by running the command

`gradlew build`

Then, you can run the unit test coverage report.

`gradlew jacocoTestReport`

Then, you can run the acceptance tests. 

`gradlew cucumber`

You can even do multiple things in one statement:

`gradlew build jacocoTestReport cucumber`

When you want to get rid of all of the temporary files (like compiled class files and such), you can say

`gradlew clean`

If you want to do a full build and reporting from a clean project, you can just string it all together:

`gradlew clean build jacocoTestReport cucumber`

If you want to create the generated documentation (based on your Javadoc comments), you can say

`gradlew javadoc`

If you want to run the application, you can say, for example,

`gradlew app/build/libs/pipboss.jar phase0`
java -jar app/build/libs/pipboss.jar phase0

The program uses command-line arguments to determine the phase to run, which must be supplied.


## Example Output
-----------------
```
The game has started. It will consist of 3 rounds and has 3 players.       
Each player has 7 regular and 1 large dice with 2 chips per round.         
Casino 1 added the minigame Pay Day.                                       
Casino 2 added the minigame Black Box.                                     
Casino 3 added the minigame Lucky Punch.                                   
P1 gained 2 chips: Chips for Round 1.                                      
P2 gained 2 chips: Chips for Round 1.                                      
P3 gained 2 chips: Chips for Round 1.                                      
Round 1 has started.                                                       
----------------------------      PLAYERS      ----------------------------
 player : money  dice  DICE  chips                                         
     P1 :     0     7     1      2
     P2 :     0     7     1      2
     P3 :     0     7     1      2

----------------------------      CASINOS      ----------------------------
  #   $$   $     P1   P2   P3                                              
 [1]   5   3 :                                                             
 Pay Day - Gain $1 for each casino where you have presence.                
 [2]   6   3 :                                                             
 Black Box - During payout, the winner plays a split/choose for additional 
winnings.                                                                  
 [3]   6   3 :                                                             
 Lucky Punch - Choose 1, 2, or 3 to win 2 chips, $3, or $4.                
 [4]   7   3 :                                                             
 [5]   8   5 :                                                             
 [6]   8   6 :                                                             

P1 placed [4, 4].                                                          
Casino 4 gained [4, 4] from P1.                                            
P2 rolled [5, 5, 5, 4, 5, 4, 5, 4+4].                                      
P2 placed [5, 5, 5, 5, 5].                                                 
Casino 5 gained [5, 5, 5, 5, 5] from P2.                                   
P3 rolled [6, 3, 6, 3, 2, 6, 3, 6+6].                                      
P3 placed [6, 6, 6, 6+6].                                                  
Casino 6 gained [6, 6, 6, 6+6] from P3.                                    
----------------------------      PLAYERS      ----------------------------
 player : money  dice  DICE  chips                                         
     P1 :     0     5     1      2
     P2 :     0     2     1      2
     P3 :     0     4     0      2

----------------------------      CASINOS      ----------------------------
  #   $$   $     P1   P2   P3                                              
 [1]   5   3 :                                                             
 Pay Day - Gain $1 for each casino where you have presence.                
 [2]   6   3 :                                                             
 Black Box - During payout, the winner plays a split/choose for additional 
winnings.                                                                  
 [3]   6   3 :                                                             
 Lucky Punch - Choose 1, 2, or 3 to win 2 chips, $3, or $4.                
 [4]   7   3 :  $$2                                                        
 [5]   8   5 :       $$5                                                   
 [6]   8   6 :            $$5                                              

P1 placed [3, 3, 3].                                                       
Casino 3 gained [3, 3, 3] from P1.                                         
P1 gained 2 chips: Lucky Punch (chose 2 chips and P2 guessed $3).          
The minigame Lucky Punch at Casino 3 has the following update: P1 chose 2  
chips and P2 guessed $3.                                                   
P2 rolled [3, 2, 3+3].                                                     
P2 placed [3, 3+3].                                                        
Casino 3 gained [3, 3+3] from P2.                                          
P2 gained $3: Lucky Punch (chose $3 and P3 guessed $4).                    
The minigame Lucky Punch at Casino 3 has the following update: P2 chose $3 
and P3 guessed $4.                                                         
P3 rolled [3, 4, 3, 1].                                                    
P3 placed [3, 3].                                                          
Casino 3 gained [3, 3] from P3.                                            
P3 gained $4: Lucky Punch (chose $4 and P1 guessed 2 chips).               
The minigame Lucky Punch at Casino 3 has the following update: P3 chose $4 
and P1 guessed 2 chips.                                                    
----------------------------      PLAYERS      ----------------------------
 player : money  dice  DICE  chips                                         
     P1 :     0     2     1      4
     P2 :     3     1     0      2
     P3 :     4     2     0      2

----------------------------      CASINOS      ----------------------------
  #   $$   $     P1   P2   P3                                              
 [1]   5   3 :                                                             
 Pay Day - Gain $1 for each casino where you have presence.                
 [2]   6   3 :                                                             
 Black Box - During payout, the winner plays a split/choose for additional 
winnings.                                                                  
 [3]   6   3 :    3    3  $$2                                              
 Lucky Punch - Choose 1, 2, or 3 to win 2 chips, $3, or $4.                
 [4]   7   3 :  $$2                                                        
 [5]   8   5 :       $$5                                                   
 [6]   8   6 :            $$5                                              

P1 placed [1, 1].                                                          
Casino 1 gained [1, 1] from P1.                                            
P1 gained $3: Pay Day (has presence at 3 casinos).                         
The minigame Pay Day at Casino 1 has the following update: P1 has presence 
at 3 casinos.                                                              
P2 rolled [2].                                                             
P2 placed [2].                                                             
Casino 2 gained [2] from P2.                                               
P3 rolled [6, 5].                                                          
P3 placed [5].                                                             
Casino 5 gained [5] from P3.                                               
----------------------------      PLAYERS      ----------------------------
 player : money  dice  DICE  chips                                         
     P1 :     3     0     1      4
     P2 :     3     0     0      2
     P3 :     4     1     0      2

----------------------------      CASINOS      ----------------------------
  #   $$   $     P1   P2   P3                                              
 [1]   5   3 :  $$2                                                        
 Pay Day - Gain $1 for each casino where you have presence.                
 [2]   6   3 :       $$1                                                   
 Black Box - During payout, the winner plays a split/choose for additional 
winnings.                                                                  
 [3]   6   3 :    3    3  $$2                                              
 Lucky Punch - Choose 1, 2, or 3 to win 2 chips, $3, or $4.                
 [4]   7   3 :  $$2                                                        
 [5]   8   5 :       $$5  $ 1                                              
 [6]   8   6 :            $$5                                              

P1 placed [1+1].                                                           
Casino 1 gained [1+1] from P1.                                             
P1 gained $3: Pay Day (has presence at 3 casinos).                         
The minigame Pay Day at Casino 1 has the following update: P1 has presence 
at 3 casinos.                                                              
P3 rolled [2].                                                             
P3 placed [2].                                                             
Casino 2 gained [2] from P3.                                               
P3 gained $10: Black Box (chose 00226 out of 0|00226).                     
The minigame Black Box at Casino 2 has the following update: P1 split as   
0|00226 and P3 chose 00226.                                                
P3 gained $8: Payout from Casino 6 for Round 1.                            
P2 gained $8: Payout from Casino 5 for Round 1.                            
P3 gained $5: Payout from Casino 5 for Round 1.                            
P1 gained $7: Payout from Casino 4 for Round 1.                            
P3 gained $6: Payout from Casino 3 for Round 1.                            
P1 gained $5: Payout from Casino 1 for Round 1.                            
Round 1 has ended.                                                         
----------------------------      PLAYERS      ----------------------------
 player : money  dice  chips                                               
     P1 :    18     0      4
     P2 :    11     0      2
     P3 :    33     0      2

----------------------------      CASINOS      ----------------------------
  #   $$   $     P1   P2   P3                                              
 [1]   5   3 :  $$4                                                        
 Pay Day - Gain $1 for each casino where you have presence.                
 [2]   6   3 :         1    1                                              
 Black Box - During payout, the winner plays a split/choose for additional 
winnings.                                                                  
 [3]   6   3 :    3    3  $$2                                              
 Lucky Punch - Choose 1, 2, or 3 to win 2 chips, $3, or $4.                
 [4]   7   3 :  $$2                                                        
 [5]   8   5 :       $$5  $ 1                                              
 [6]   8   6 :            $$5                                              

Casino 1 added the minigame Jackpot.                                       
Casino 2 added the minigame High Five.                                     
Casino 3 added the minigame Fifty Fifty.                                   
P1 gained 2 chips: Chips for Round 2.                                      
P2 gained 2 chips: Chips for Round 2.                                      
P3 gained 2 chips: Chips for Round 2.                                      
Round 2 has started.                                                       
P3 rolled [5, 4, 4, 3, 6, 3, 4, 5+5].                                      
P3 placed [4, 4, 4].                                                       
Casino 4 gained [4, 4, 4] from P3.                                         
----------------------------      PLAYERS      ----------------------------
 player : money  dice  DICE  chips                                         
     P1 :    18     7     1      6
     P2 :    11     7     1      4
     P3 :    33     4     1      4

----------------------------      CASINOS      ----------------------------
  #   $$   $     P1   P2   P3                                              
 [1]   5   4 :                                                             
 Jackpot - Roll doubles or 7 to win $3.                                    
 [2]   8   3 :                                                             
 High Five - The first player to place at least 5 dice here wins $10.      
 [3]   9   4 :                                                             
 Fifty Fifty - Keep rolling more/less than target or stop and take payout. 
 [4]   9   4 :            $$3                                              
 [5]  10   6 :                                                             
 [6]  10   7 :                                                             

P1 placed [2, 2].                                                          
Casino 2 gained [2, 2] from P1.                                            
P2 rolled [2, 4, 5, 2, 5, 6, 2, 6+6].                                      
P2 placed [2, 2, 2].                                                       
Casino 2 gained [2, 2, 2] from P2.                                         
P3 rolled [3, 2, 2, 6, 5+5].                                               
P3 placed [2, 2].                                                          
Casino 2 gained [2, 2] from P3.                                            
----------------------------      PLAYERS      ----------------------------
 player : money  dice  DICE  chips                                         
     P1 :    18     5     1      6
     P2 :    11     4     1      4
     P3 :    33     2     1      4

----------------------------      CASINOS      ----------------------------
  #   $$   $     P1   P2   P3                                              
 [1]   5   4 :                                                             
 Jackpot - Roll doubles or 7 to win $3.                                    
 [2]   8   3 :    2  $$3    2                                              
 High Five - The first player to place at least 5 dice here wins $10.      
 [3]   9   4 :                                                             
 Fifty Fifty - Keep rolling more/less than target or stop and take payout. 
 [4]   9   4 :            $$3                                              
 [5]  10   6 :                                                             
 [6]  10   7 :                                                             

P1 placed [1, 1, 1+1].                                                     
Casino 1 gained [1, 1, 1+1] from P1.                                       
The minigame Jackpot at Casino 1 has the following update: [5, 6] was      
rolled. Potential payout is now $4.                                        
P2 rolled [2, 5, 5, 2, 2+2].                                               
P2 placed [2, 2, 2+2].                                                     
Casino 2 gained [2, 2, 2+2] from P2.                                       
P2 gained $10: High Five.                                                  
The minigame High Five at Casino 2 has the following update: P2 has claimed 
$10.                                                                       
P3 rolled [2, 4, 6+6].                                                     
P3 placed [2].                                                             
Casino 2 gained [2] from P3.                                               
----------------------------      PLAYERS      ----------------------------
 player : money  dice  DICE  chips                                         
     P1 :    18     3     0      6
     P2 :    21     2     0      4
     P3 :    33     1     1      4

----------------------------      CASINOS      ----------------------------
  #   $$   $     P1   P2   P3                                              
 [1]   5   4 :  $$4                                                        
 Jackpot - Roll doubles or 7 to win $4.                                    
 [2]   8   3 :    2  $$7  $ 3                                              
 High Five - The payout has already been claimed.                          
 [3]   9   4 :                                                             
 Fifty Fifty - Keep rolling more/less than target or stop and take payout. 
 [4]   9   4 :            $$3                                              
 [5]  10   6 :                                                             
 [6]  10   7 :                                                             

P1 placed [1, 1].                                                          
Casino 1 gained [1, 1] from P1.                                            
The minigame Jackpot at Casino 1 has the following update: [6, 4] was      
rolled. Potential payout is now $5.                                        
P2 rolled [1, 5].                                                          
P2 placed [1].                                                             
Casino 1 gained [1] from P2.                                               
P2 gained $5: Jackpot ([2, 2] -> $5).                                      
The minigame Jackpot at Casino 1 has the following update: [2][2] was      
rolled, and payout was $5. Potential payout is $3.                         
P3 rolled [6, 1+1].                                                        
P3 placed [1+1].                                                           
Casino 1 gained [1+1] from P3.                                             
P3 gained $3: Jackpot ([3, 4] -> $3).                                      
The minigame Jackpot at Casino 1 has the following update: [3][4] was      
rolled, and payout was $3. Potential payout is $3.                         
----------------------------      PLAYERS      ----------------------------
 player : money  dice  chips                                               
     P1 :    18     1      6
     P2 :    26     1      4
     P3 :    36     1      4

----------------------------      CASINOS      ----------------------------
  #   $$   $     P1   P2   P3                                              
 [1]   5   4 :  $$6    1  $ 2                                              
 Jackpot - Roll doubles or 7 to win $3.                                    
 [2]   8   3 :    2  $$7  $ 3                                              
 High Five - The payout has already been claimed.                          
 [3]   9   4 :                                                             
 Fifty Fifty - Keep rolling more/less than target or stop and take payout. 
 [4]   9   4 :            $$3                                              
 [5]  10   6 :                                                             
 [6]  10   7 :                                                             

P1 placed [6].                                                             
Casino 6 gained [6] from P1.                                               
P2 rolled [2].                                                             
P2 placed [2].                                                             
Casino 2 gained [2] from P2.                                               
P3 rolled [4].                                                             
P3 placed [4].                                                             
Casino 4 gained [4] from P3.                                               
P1 gained $10: Payout from Casino 6 for Round 2.                           
P3 gained $9: Payout from Casino 4 for Round 2.                            
P2 gained $8: Payout from Casino 2 for Round 2.                            
P3 gained $3: Payout from Casino 2 for Round 2.                            
P1 gained $5: Payout from Casino 1 for Round 2.                            
P3 gained $4: Payout from Casino 1 for Round 2.                            
Round 2 has ended.                                                         
----------------------------      PLAYERS      ----------------------------
 player : money  dice  chips                                               
     P1 :    33     0      6
     P2 :    34     0      4
     P3 :    52     0      4

----------------------------      CASINOS      ----------------------------
  #   $$   $     P1   P2   P3                                              
 [1]   5   4 :  $$6    1  $ 2                                              
 Jackpot - Roll doubles or 7 to win $3.                                    
 [2]   8   3 :    2  $$8  $ 3                                              
 High Five - The payout has already been claimed.                          
 [3]   9   4 :                                                             
 Fifty Fifty - Keep rolling more/less than target or stop and take payout. 
 [4]   9   4 :            $$4                                              
 [5]  10   6 :                                                             
 [6]  10   7 :  $$1                                                        

Casino 1 added the minigame Black Box.                                     
Casino 2 added the minigame Pay Day.                                       
Casino 3 added the minigame High Five.                                     
P1 gained 2 chips: Chips for Round 3.                                      
P2 gained 2 chips: Chips for Round 3.                                      
P3 gained 2 chips: Chips for Round 3.                                      
Round 3 has started.                                                       
----------------------------      PLAYERS      ----------------------------
 player : money  dice  DICE  chips                                         
     P1 :    33     7     1      8
     P2 :    34     7     1      6
     P3 :    52     7     1      6

----------------------------      CASINOS      ----------------------------
  #   $$   $     P1   P2   P3                                              
 [1]   7   3 :                                                             
 Black Box - During payout, the winner plays a split/choose for additional 
winnings.                                                                  
 [2]   6   5 :                                                             
 Pay Day - Gain $1 for each casino where you have presence.                
 [3]   7   5 :                                                             
 High Five - The payout has already been claimed.                          
 [4]   8   6 :                                                             
 [5]   9   5 :                                                             
 [6]  10   4 :                                                             

P1 placed [6, 6, 6, 6].                                                    
Casino 6 gained [6, 6, 6, 6] from P1.                                      
P2 rolled [3, 5, 3, 5, 3, 1, 3, 4+4].                                      
P2 placed [3, 3, 3, 3].                                                    
Casino 3 gained [3, 3, 3, 3] from P2.                                      
P3 rolled [2, 5, 1, 6, 5, 5, 2, 4+4].                                      
P3 placed [5, 5, 5].                                                       
Casino 5 gained [5, 5, 5] from P3.                                         
----------------------------      PLAYERS      ----------------------------
 player : money  dice  DICE  chips                                         
     P1 :    33     3     1      8
     P2 :    34     3     1      6
     P3 :    52     4     1      6

----------------------------      CASINOS      ----------------------------
  #   $$   $     P1   P2   P3                                              
 [1]   7   3 :                                                             
 Black Box - During payout, the winner plays a split/choose for additional 
winnings.                                                                  
 [2]   6   5 :                                                             
 Pay Day - Gain $1 for each casino where you have presence.                
 [3]   7   5 :       $$4                                                   
 High Five - The payout has already been claimed.                          
 [4]   8   6 :                                                             
 [5]   9   5 :            $$3                                              
 [6]  10   4 :  $$4                                                        

P1 placed [5, 5, 5].                                                       
Casino 5 gained [5, 5, 5] from P1.                                         
P2 rolled [1, 4, 4, 4+4].                                                  
P2 placed [4, 4, 4+4].                                                     
Casino 4 gained [4, 4, 4+4] from P2.                                       
P3 rolled [3, 6, 5, 3, 1+1].                                               
P3 placed [3, 3].                                                          
Casino 3 gained [3, 3] from P3.                                            
----------------------------      PLAYERS      ----------------------------
 player : money  dice  DICE  chips                                         
     P1 :    33     0     1      8
     P2 :    34     1     0      6
     P3 :    52     2     1      6

----------------------------      CASINOS      ----------------------------
  #   $$   $     P1   P2   P3                                              
 [1]   7   3 :                                                             
 Black Box - During payout, the winner plays a split/choose for additional 
winnings.                                                                  
 [2]   6   5 :                                                             
 Pay Day - Gain $1 for each casino where you have presence.                
 [3]   7   5 :       $$4  $ 2                                              
 High Five - The payout has already been claimed.                          
 [4]   8   6 :       $$4                                                   
 [5]   9   5 :    3         3                                              
 [6]  10   4 :  $$4                                                        

P1 placed [3+3].                                                           
Casino 3 gained [3+3] from P1.                                             
P2 rolled [4].                                                             
P2 placed [4].                                                             
Casino 4 gained [4] from P2.                                               
P3 rolled [5, 3, 2+2].                                                     
P3 placed [2+2].                                                           
Casino 2 gained [2+2] from P3.                                             
P3 gained $3: Pay Day (has presence at 3 casinos).                         
The minigame Pay Day at Casino 2 has the following update: P3 has presence 
at 3 casinos.                                                              
P3 rolled [6, 5].                                                          
P3 placed [5].                                                             
Casino 5 gained [5] from P3.                                               
P3 rolled [2].                                                             
P3 placed [2].                                                             
Casino 2 gained [2] from P3.                                               
P3 gained $3: Pay Day (has presence at 3 casinos).                         
The minigame Pay Day at Casino 2 has the following update: P3 has presence 
at 3 casinos.                                                              
P1 gained $10: Payout from Casino 6 for Round 3.                           
P3 gained $9: Payout from Casino 5 for Round 3.                            
P1 gained $5: Payout from Casino 5 for Round 3.                            
P2 gained $8: Payout from Casino 4 for Round 3.                            
P2 gained $7: Payout from Casino 3 for Round 3.                            
P3 gained $6: Payout from Casino 2 for Round 3.                            
Round 3 has ended.                                                         
----------------------------      PLAYERS      ----------------------------
 player : money  dice  chips                                               
     P1 :    48     0      8
     P2 :    49     0      6
     P3 :    73     0      6

----------------------------      CASINOS      ----------------------------
  #   $$   $     P1   P2   P3                                              
 [1]   7   3 :                                                             
 Black Box - During payout, the winner plays a split/choose for additional 
winnings.                                                                  
 [2]   6   5 :            $$3                                              
 Pay Day - Gain $1 for each casino where you have presence.                
 [3]   7   5 :    2  $$4    2                                              
 High Five - The payout has already been claimed.                          
 [4]   8   6 :       $$5                                                   
 [5]   9   5 :  $ 3       $$4                                              
 [6]  10   4 :  $$4                                                        

The game is over. The final game state is below.                           
----------------------------      PLAYERS      ----------------------------
 player : money  dice  chips                                               
     P1 :    48     0      8
     P2 :    49     0      6
     P3 :    73     0      6

----------------------------      CASINOS      ----------------------------
  #   $$   $     P1   P2   P3                                              
 [1]   7   3 :                                                             
 Black Box - During payout, the winner plays a split/choose for additional 
winnings.                                                                  
 [2]   6   5 :            $$3                                              
 Pay Day - Gain $1 for each casino where you have presence.                
 [3]   7   5 :    2  $$4    2                                              
 High Five - The payout has already been claimed.                          
 [4]   8   6 :       $$5                                                   
 [5]   9   5 :  $ 3       $$4                                              
 [6]  10   4 :  $$4                                                        
```
