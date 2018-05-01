:-consult('knowledge.pl').

intersec([], _, []).
intersec([H1|T1], L2, [H1|Res]) :-
                    member(H1, L2), intersec(T1, L2, Res).

intersec([_|T1], L2, Res) :-
              intersec(T1, L2, Res).

findChampsInSameMatch(L1,L2,L3):-intersec(L1,L2,L3),!.


findParticipants(ChampId,Lane,EnemyId):-findall(MatchId,participant(_,MatchId,114,_,Lane),Lista),
                                        findall(MatchId2,participant(_,MatchId2,24,_,Lane),Lista2),
                                        findChampsInSameMatch(Lista,Lista2,Matches1),
                                        findall(MatchId3,participant(_,MatchId3,121,_,'JUNGLE'),Lista3),
                                        findChampsInSameMatch(Lista3,Matches1,Matches2),
                                        findall(MatchId4,participant(_,MatchId4,161,_,'MID'),Lista4),
                                        findChampsInSameMatch(Matches2,Lista4,Matches3),
                                        findall(MatchId5,participant(_,MatchId5,44,_,'BOT'),Lista5),
                                        findChampsInSameMatch(Matches3,Lista5,Matches4), write(Matches4).
