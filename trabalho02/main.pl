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

enemyTeam(A,EnemyLaneA) :-
                    tab(15),write(A),write(' inimigo'),nl,nl,
                    read(Aa),
                    champ(Aa,_),
                    EnemyLaneA = Aa,
                    write('Inimigo no: '),write(A),write(" "),
                    write(EnemyLaneA),
                    write('\n'),
                    write('\n').

menu:-champName(Z),opponentInLane(U),
                   lanePlayed(W),influenceInLane(W,A,B,C),
                   enemyTeam(A,EnemyLaneA),
                   enemyTeam(B,EnemyLaneB),
                   enemyTeam(C,EnemyLaneC).
