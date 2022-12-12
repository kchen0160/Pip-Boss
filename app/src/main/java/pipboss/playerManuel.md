# PIP Boss
This project is modeled after the game Las Vegas Royale and has some features that make it different than Las Vegas Royale, hence the name PIP Boss. This project was made by Kevin, Tyler, Andrew, and Estefani. 


## Contents
- [PIP Boss](#pip-boss)
  - [Contents](#contents)
  - [Game Setup](#game-setup)
  - [Game Rules](#game-rules)
  - [Phase 0](#phase-0)
  - [Phase 1](#phase-1)
  - [Phase 2](#phase-2)
  - [Phase 3](#phase-3)
  - [Phase 4](#phase-4)
  - [Phase 5](#phase-5)
  - [Phase 6](#phase-6)
  - [Phase 7](#phase-7)
  - [Phase 8](#phase-8)
  - [Phase 9](#phase-9)
  - [Phase 10](#phase-10)
  - [Phase 11](#phase-11)



## Game Setup
There are 6 casinos which are numbered from 1 to 6. Each casino gets assigned a pair of money and the pair with the highest sum is assigned to casino 6 and the lowest sum is assigned to casino 1. Each player starts 7 standard dice and one big dice. In phase 2 of the game each player starts with 2 chips. In Phase 3 there are three AI players that are added to the game. In Phase 5 minigames are added and they are first assigned to casino 1, with each minigame added there will be a random chance that each casino ends up with a minigame. The minigames are assigned to the lowest casinos first.
## Game Rules 
At the start of each turn the player rolls all of their dice. They can pick a number that they want to place in the corresponding casino. If they pick the number they place every dice that rolled the number in the casino. If the player does not want to place any dice in the casino, they can play a chip which they lose after they play it. The round ends when all players run out of dice. At the end of the round the player with the most dice gets the money that is worth more at the casino and the 2nd place get the lower value. If there are players with the same amount of dice in each Casino, then the next highest number of dice would earn the high value. The players that are tied don't get money from the casino. There are two agressive AI opponents that the player plays against. There is the ability to play 3 rounds instead of only 1 round.
## Phase 0
The user should be able to play a console version of the game that lasts only a single round, has only a single player, and that player has only 7 standard dice and no chips.
## Phase 1
Same as Phase 0 but now the player gains 2 chips at the start of the round.
## Phase 2
Same as Phase 1 but now the player has 1 large die as well as the 7 regular dice.
## Phase 3
Same as Phase 2 but now the player has 2 AI opponents that play aggressively, where they always place the most dice possible each turn.
## Phase 4
Same as Phase 3 but with 3 rounds instead of only 1 (with chips allocated accordingly each round).
## Phase 5
Same as Phase 4, but now the minigame Jackpot should be added to Casino 1. The first jackpot is 3 and the maximum jackpot is $7. In the jackpot minigame the way a player can win jackpot is if they roll 7 or a double(which is the same number twice). This is done with a seperate pair of dice, if jackpot is not won the jackpot prize is raised by 1. The minigame is always triggered when a die is placed in the casino 1. 
 
## Phase 6
Same as Phase 5, but now the minigame Pay Day should be added (randomly assigning it to Casino 1 or 2 with Jackpot assigned to the other). Count the casinos (not tiles!) that contain at least one die of your color. This includes the activated casino. Multiply the number of casinos by $1. If the total is $1 or $2, you receive
1 or 2 chips. For $3-$6 take that much money from the bank.
## Phase 7
Same as Phase 6, but now the minigame Fifty Fifty should be added (randomly assigning the 3 minigames each to one of the lowest 3 casinos). To play Fifty Fifty, throw both extra dice and move the counter one space to the right. Then, if you choose to end your turn, you get the reward indicated below the counter ($0-$6).
However, you can gamble and try to increase your reward. Before you roll the dice again, you must bet higher or lower. Then you throw the dice and advance the counter.
– If you win your bet, you may choose again whether you want to
take the reward or gamble.
– If you lose your bet, your turn ends and you get nothing.
– At your turn ́s end place the counter back on the first space.
If you roll the same number twice in a row, you lose the bet!
## Phase 8
Same as Phase 7, but now the minigame Lucky Punch should be added (dropping Jackpot and randomly assigning the other 3 as before). The player chooses 1, 2, or 3.  The player to your left must guess which number was selected. If they guess correctly, you get nothing. If they guess wrong, you get the reward: either 2 chips or $3 or $4.
## Phase 9
Same as Phase 8, but now the minigame High Five should be added (dropping Pay Day and randomly assigning the other 3 as before). When you place your fifth die (or 3 and your Big Die) in this casino, take the token. Exchange it during payout for $10 from the bank.
## Phase 10
Same as Phase 9, but now the minigame Black Box should be added (dropping Fifty Fifty and randomly assigning the other 3 as before). The player to the left of this casino’s winner takes all 6 tokens and separates them into two piles (3+3, 4+2, or 5+1 tokens), as he wishes. The winner of the casino chooses one of the face down piles. They receive the reward shown on the choosen tokens: 2 chips or money ($4, $6, $8 or even $10).
## Phase 11
Same as Phase 10, but now the minigame Block It should be added (dropping Lucky Punch and randomly assigning the other 3 as before). Choose one dice space cluster, take all blank dice from it and place them in one casino of your choice. During this round and
during payout, treat any blank dice in casinos as belonging to an imaginary player.