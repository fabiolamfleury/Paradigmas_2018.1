:-consult('knowledge.pl').

intersec([], _, []).
intersec([H1|T1], L2, [H1|Res]) :-
                    member(H1, L2), intersec(T1, L2, Res).
intersec([_|T1], L2, Res) :-
              intersec(T1, L2, Res).


findChampsInSameMatch(L1,L2,L3):-intersec(L1,L2,L3),!.

takeListTail([ _ | Tail], Return):- Return = Tail.

findParticipant([LaneH|LaneT], [ParticipantH|ParticipantT]):-
  findall(MatchId,participant(_,MatchId,ParticipantH,_,LaneH),Lista),
  nth0(0, ParticipantT, Part),
  nth0(0, LaneT, PartLane),
  findall(MatchId2,participant(_,MatchId2,Part,_,PartLane),Lista2),
  findChampsInSameMatch(Lista,Lista2,Matches1),
  takeListTail(LaneT, LaneNext),
  takeListTail(ParticipantT, EnemyNext),
  findParticipants(LaneNext, EnemyNext, Matches1).

/*Matches4 é lista com os matchs ID da composição selecionada
Stats é a lista com os idStats*/
findParticipants([],_, Answer):-getStats(Answer,[],Stats),write(Stats).
findParticipants([LaneH|LaneT], [EnemyH|EnemyT], Answer):-
                                        findall(MatchIds,participant(_,MatchIds,EnemyH,_,LaneH),List),
                                        findChampsInSameMatch(List,Answer,NewAnswer),
                                        findParticipants(LaneT, EnemyT, NewAnswer).


getStats([],L2,Return):-append([],L2,Return).
getStats([H|T],L2,Return):-findall(IdStats,participant(IdStats,H,_,_,_),L),
                              append(L,L2,Result),
                              getStats(T,Result,Return).
