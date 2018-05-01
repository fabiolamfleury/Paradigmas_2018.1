:-consult('knowledge.pl').
:-consult('definitionsOfRecommendations.pl').

/*O nome do personagem deve ser escrito entre ''*/
champName(Z,Id):-tab(15),write('Digite o nome do personagem'),nl,nl,
           read(YourChamp),
           champ(YourChamp,ChampId),
           write('Voce escolheu o personagem: '),
           Z = YourChamp,
           Id = ChampId,
           write(Z),
           write('\n'),
           write('\n').

opponentInLane(U,IdEnemy):-tab(15),write('Digite o nome do oponente'),nl,nl,
                      read(YourChamp),
                      champ(YourChamp,ChampIdEnemy),
                      write('Voce ira enfrentar o personagem: '),
                      U = YourChamp,
                      IdEnemy = ChampIdEnemy,
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
                              champ(Aa,IdEnemy),
                              EnemyInLane = IdEnemy,
                              write('Inimigo no: '),write(Lane),write(" "),
                              write(EnemyInLane),
                              write('\n'),
                              write('\n').

getFirstElement([A,_,_],Return):-Return = A.
getSecondElement([_,A,_],Return):-Return = A.
getThirdElement([_,_,A],Return):-Return = A.

menu:-champName(Z,ChampSelect),opponentInLane(U,IdEnemy),
                   lanePlayed(SelectLane),findall(InfluencedBy,influenceInLane(SelectLane, InfluencedBy),L),
                   /*Pega as lanes*/
                   getFirstElement(L,Lane1),getSecondElement(L,Lane2),getThirdElement(L,Lane3),
                   /*Pega os oponents nas lanes*/
                   enemyTeam(Lane1,EnemyInLane1),enemyTeam(Lane2,EnemyInLane2),enemyTeam(Lane3,EnemyInLane3),
                   /*Procura todas as partidas que tem a configuração de entrada*/
                   findParticipants(ChampSelect,SelectLane,IdEnemy,Lane1,EnemyInLane1,Lane2,EnemyInLane2,Lane3,EnemyInLane3).
