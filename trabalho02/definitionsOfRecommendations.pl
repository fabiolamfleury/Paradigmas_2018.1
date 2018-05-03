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
                                %TODO: Criar varias listas de 10 elementos, para depois serem divididos em dois times
                                div(Stats, Team1, Team2),
                                write('Time vencedor: '),
                                write(Team1),
                                nl,
                                write_result(Team1),
                                write('Time perdedor: '),
                                write_result(Team2),
                                write(Team2),
                                b_getval(selectLanes, Lanes),
                                write(Lanes),
                                b_getval(selectChamps, Champs),
                                write(Champs),
                                nl.
find_participants([LaneH|LaneT], [EnemyH|EnemyT], Answer):-
                                        findall(MatchIds,participant(_,MatchIds,EnemyH,_,LaneH),List),
                                        find_champs_in_same_match(List,Answer,NewAnswer),
                                        find_participants(LaneT, EnemyT, NewAnswer).

write_result([]).
write_result([Head | Tail]):- stats(Head, Win),
                              write(Win),
                              nl,
                              write_result(Tail).

div(L, A, B) :-
    append(A, B, L),
    length(A, 5),
    length(B, 5).


group_by_team([], _, _, _).
group_by_team([MatcheshHead | MatchesTail], [], _, _).
group_by_team(Matches, Participants, Team1, Team2):-Team1 = [],
                                    Team2 = [].

getStats([],L2,Return):-append([],L2,Return).
getStats([H|T],L2,Return):-findall(IdStats,participant(IdStats,H,_,_,_),L),
                              append(L,L2,Result),
                              getStats(T,Result,Return).
