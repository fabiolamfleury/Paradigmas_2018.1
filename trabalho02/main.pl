:-consult('knowledge.pl').

/*o certo vai ser entrar como o nome do personagem só esta
com numero pra ajudar no desenvolvimento.*/

champName:-tab(15),write('Digite o numero do personagem'),nl,nl,
           read(YourChamp),
           champ(Y,YourChamp),
           write('Voce escolheu o personagem: '),
           write(Y).

opponentInLane:-tab(15),write('Digite o numero do oponente'),nl,nl,
                      read(YourChamp),
                      champ(Y,YourChamp),
                      write('Voce escolheu o personagem: '),
                      write(Y).

lanePlayed:-tab(15),write('Qual lane deseja jogar'),nl,nl,
                read(LaneGame),
                lane(LaneGame),
                write('A lane escolhida foi '),
                write(LaneGame).
