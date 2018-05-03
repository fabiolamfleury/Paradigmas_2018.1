:-consult('knowledge.pl').

intersec([], _, []).
intersec([H1|T1], L2, [H1|Res]) :-
                    member(H1, L2), intersec(T1, L2, Res).
intersec([_|T1], L2, Res) :-
              intersec(T1, L2, Res).


find_champs_in_same_match(L1,L2,L3):-intersec(L1,L2,L3),!.

take_list_tail([ _ | Tail], Return):- Return = Tail.

find_participant([LaneH|LaneT], [ParticipantH|ParticipantT]):-
  findall(MatchId,participant(_,MatchId,ParticipantH,_,LaneH),Lista),
  nth0(0, ParticipantT, Part),
  nth0(0, LaneT, PartLane),
  findall(MatchId2,participant(_,MatchId2,Part,_,PartLane),Lista2),
  find_champs_in_same_match(Lista,Lista2,Matches1),
  take_list_tail(LaneT, LaneNext),
  take_list_tail(ParticipantT, EnemyNext),
  find_participants(LaneNext, EnemyNext, Matches1).

/*Matches4 é lista com os matchs ID da composição selecionada
Stats é a lista com os idStats*/
find_participants([],_, Answer):-getStats(Answer,[],Stats),
                                write(Stats),
                                write('\n'),
                                write(Answer),
                                nl,nl,nl,
                                divide_teams(Answer, Stats).
find_participants([LaneH|LaneT], [EnemyH|EnemyT], Answer):-
                                        findall(MatchIds,participant(_,MatchIds,EnemyH,_,LaneH),List),
                                        find_champs_in_same_match(List,Answer,NewAnswer),
                                        find_participants(LaneT, EnemyT, NewAnswer).

divide_teams([], _).
divide_teams([MatchId | Tail], Stats):- div(Stats, MatchParticipants, Rest, 10, N2),
                                        match_info(MatchParticipants, MatchId),
                                        divide_teams(Tail, Rest).

match_info(MatchParticipants, MatchId):- div(MatchParticipants, Team1, Team2, 5, 5),
                                         write('Partida de Número: '), write(MatchId), nl,
                                         check_if_teams_are_match(MatchId, Team1, Team2).
div(L, A, B, N1, N2) :-
    append(A, B, L),
    length(A, N1),
    length(B, N2).

check_if_teams_are_match(MatchId, Team1, Team2):- b_getval(selectLanes, Lanes), b_getval(selectChamps, Champs),
                                                 enemy_team(Team1, Team2, MatchId, Lanes, Champs).

enemy_team(Team1, Team2, MatchId,[ _ | Lanes], [ _ | Champs]):-
    (  all_in_team(Team1, MatchId, Lanes, Champs) -> nl,write('O time inimigo ganhou!'), nl,write_teams(Team1, Team2)
    ;  all_in_team(Team2, MatchId, Lanes, Champs) -> nl,write('O time inimigo PERDEU!'), nl,write_teams(Team1, Team2)
    ;  nl,write('Match retirada.'),nl
     ).

all_in_team(_,_,[],_).
all_in_team(Team, MatchId, [Lane | LaneNexts], [Champ | ChampNexts]):- member_of_team(MatchId, Team, Champ, Lane),
                                                                       all_in_team(Team, MatchId, LaneNexts, ChampNexts).

member_of_team(MatchId, Team, ChampId, Lane):- participant(IdStats, MatchId, ChampId, _, Lane),
                                               member(IdStats, Team).

write_teams(Team1, Team2):-  write('Time vencedor: '),
                             nl,
                             write_team(Team1),
                             nl,
                             write('Time perdedor: '),
                             nl,
                             write_team(Team2),
                             nl.
write_team([]).
write_team([Head | Tail]):- participant(Head, _, ChampionId, Role, Position),
                            champ(Champion, ChampionId),
                            write('Champion: '),
                            write(Champion),
                            write('\t Role: '),
                            write(Role),
                            write('\tPosition: '),
                            write(Position),
                            nl,
                            write_team(Tail).



getStats([],L2,Return):-append([],L2,Return).
getStats([H|T],L2,Return):-findall(IdStats,participant(IdStats,H,_,_,_),L),
                              append(L,L2,Result),
                              getStats(T,Result,Return).
