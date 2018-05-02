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

createEmptyList(List):-List = [X, Y, Z].

enemies([],_).
enemies([LaneH|LaneT], [EnemyH|EnemyT]) :- enemyTeam(LaneH, EnemyH), enemies(LaneT, EnemyT).

menu:-champName(Z,ChampSelect),opponentInLane(U,IdEnemy),
                   lanePlayed(SelectLane),findall(InfluencedBy,influenceInLane(SelectLane, InfluencedBy),Lanes),
                   /*Pega as lanes*/
                   createEmptyList(Enemies),
                   /*Pega os oponents nas lanes*/
                   enemies(Lanes, Enemies),
                   append([SelectLane, SelectLane],Lanes,AllLanes),
                   append([ChampSelect, IdEnemy],Enemies,AllChamps),
                   /*Procura todas as partidas que tem a configuração de entrada*/
                   findParticipant(AllLanes, AllChamps).
