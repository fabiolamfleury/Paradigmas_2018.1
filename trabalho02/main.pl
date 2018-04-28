:-consult('knowledge.pl').

/*o certo vai ser entrar como o nome do personagem só esta
com numero pra ajudar no desenvolvimento.*/

champName(Z):-tab(15),write('Digite o numero do personagem'),nl,nl,
           read(YourChamp),
           champ(Y,YourChamp),
           write('Voce escolheu o personagem: '),
           Z = Y,
           write(Y),
           write('\n'),
           write('\n').

opponentInLane(U):-tab(15),write('Digite o numero do oponente'),nl,nl,
                      read(YourChamp),
                      champ(Y,YourChamp),
                      write('Voce ira enfrentar o personagem: '),
                      U = Y,
                      write(Y),
                      write('\n'),
                      write('\n').


lanePlayed(W):-tab(15),write('Qual lane deseja jogar'),nl,nl,
                read(LaneGame),
                W = LaneGame,
                write('Voce escolheu a lane: '),
                write(W),
                write('\n'),
                write('\n').

menu:-champName(Z),opponentInLane(U),lanePlayed(W),influenceInLane(W,A,B,C),
                                     write(A),write(" "),
                                     write(B),write(" "),
                                     write(C),write(" ").
