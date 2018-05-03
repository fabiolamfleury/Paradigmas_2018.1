:-consult('knowledge.pl').
:-consult('definitionsOfRecommendations.pl').

/*O nome do personagem deve ser escrito entre ''*/
champ_name(Z,Id):-tab(15),write('Digite o nome do personagem'),nl,nl,
           read(YourChamp),
           champ(YourChamp,ChampId),
           write('Voce escolheu o personagem: '),
           Z = YourChamp,
           Id = ChampId,
           write(Z),
           nl,
           nl.

opponent_in_lane(U,IdEnemy):-tab(15),write('Digite o nome do oponente'),nl,nl,
                      read(YourChamp),
                      champ(YourChamp,ChampIdEnemy),
                      write('Voce ira enfrentar o personagem: '),
                      U = YourChamp,
                      IdEnemy = ChampIdEnemy,
                      write(U),
                      nl,
                      nl.


lane_played(W):-tab(15),write('Qual lane deseja jogar'),nl,nl,
                read(LaneGame),
                write('Voce escolheu a lane: '),
                W = LaneGame,
                write(W),
                nl,
                nl.

enemy_team(Lane,EnemyInLane):-tab(15),write(Lane),write(' inimigo'),nl,nl,
                              read(Aa),
                              champ(Aa,IdEnemy),
                              EnemyInLane = IdEnemy,
                              write('Inimigo no: '),write(Lane),write(" "),
                              write(EnemyInLane),
                              nl,
                              nl.

createEmptyList(List):-List = [X, Y, Z].

enemies([],_).
enemies([LaneH|LaneT], [EnemyH|EnemyT]) :- enemy_team(LaneH, EnemyH), enemies(LaneT, EnemyT).

menu:-champ_name(Z,ChampSelect),opponent_in_lane(U,IdEnemy),
                   lane_played(SelectLane),findall(InfluencedBy,influence_in_lane(SelectLane, InfluencedBy),Lanes),
                   /*Pega as lanes*/
                   createEmptyList(Enemies),
                   /*Pega os oponents nas lanes*/
                   enemies(Lanes, Enemies),
                   append([SelectLane, SelectLane],Lanes,AllLanes),
                   append([ChampSelect, IdEnemy],Enemies,AllChamps),
                   b_setval(selectLanes, AllLanes),
                   b_setval(selectChamps, AllChamps),
                   /*Procura todas as partidas que tem a configuração de entrada*/
                   find_participant(AllLanes, AllChamps).
