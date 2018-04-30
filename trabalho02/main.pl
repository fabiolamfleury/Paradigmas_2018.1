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
                W = LaneGame,
                write('Voce escolheu a lane: '),
                write(W),
                write('\n'),
                write('\n').

enemyTeam( [A | B ],EnemyInLane) :-
                    tab(15),write(A),write(' inimigo'),nl,nl,
                    read(Aa),
                    champ(Aa,ChampID),
                    findall(IdStats, participant(IdStats, _ , ChampID, _,A),L),
                %TODO: criar um functor  enemy(L), que guarda a lista criada
                    EnemyInLane = Aa,
                    write('Inimigo no: '),write(A),write(" "),
                    write(EnemyInLane),
                    write('\n'),
                    write('\n'),
                    enemyTeam(B, NewEnemyInLane).

menu:-champName(Z),opponentInLane(U),
                   lanePlayed(W),findall(InfluencedBy,influenceInLane(W, InfluencedBy),L),
                   enemyTeam(L,EnemyInLane).
