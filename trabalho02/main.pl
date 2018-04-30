:-consult('knowledge.pl').

/*O nome do personagem deve ser escrito entre ''*/
champName(Z):-tab(15),write('Digite o nome do personagem'),nl,nl,
           read(YourChamp),
           champ(YourChamp,_),
           write('Voce escolheu o personagem: '),
           Z = YourChamp,
           write(Z),
           write('\n'),
           write('\n').

opponentInLane(U):-tab(15),write('Digite o nome do oponente'),nl,nl,
                      read(YourChamp),
                      champ(YourChamp,_),
                      write('Voce ira enfrentar o personagem: '),
                      U = YourChamp,
                      write(U),
                      write('\n'),
                      write('\n').


lanePlayed(W):-tab(15),write('Qual lane deseja jogar'),nl,nl,
                read(LaneGame),
                write('Voce escolheu a lane: '),
                W = LaneGame,
                write(W),
                write('\n'),
                write('\n').

enemyTeam(Lane,EnemyInLane):-tab(15),write(Lane),write(' inimigo'),nl,nl,
                              read(Aa),
                              champ(Aa,_),
                              EnemyInLane = Aa,
                              write('Inimigo no: '),write(Lane),write(" "),
                              write(EnemyInLane),
                              write('\n'),
                              write('\n').

getFirstElement([A,_,_],Return):-Return = A.
getSecondElement([_,A,_],Return):-Return = A.
getThirdElement([_,_,A],Return):-Return = A.

menu:-champName(Z),opponentInLane(U),
                   lanePlayed(W),findall(InfluencedBy,influenceInLane(W, InfluencedBy),L),
                   getFirstElement(L,Lane1),getSecondElement(L,Lane2),getThirdElement(L,Lane3),
                   enemyTeam(Lane1,EnemyInLane1),enemyTeam(Lane2,EnemyInLane2),enemyTeam(Lane3,EnemyInLane3).
