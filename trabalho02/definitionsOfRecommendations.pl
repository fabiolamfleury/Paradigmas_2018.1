:-consult('knowledge.pl').

findParticipants(ChampId,Lane,EnemyId):-findall(MatchId,participant(_,MatchId,114,_,Lane),Lista),
                                        findall(MatchId2,participant(_,MatchId2,24,_,Lane),Lista2),
                                        findChampsInSameMatch(Lista,Lista2,Matches),write(Matches).



intersec([], _, []).
intersec([H1|T1], L2, [H1|Res]) :-
                    member(H1, L2),
                    intersec(T1, L2, Res).
intersec([_|T1], L2, Res) :-
              intersec(T1, L2, Res).

findChampsInSameMatch(L1,L2,L3):-intersec(L1,L2,L3),!.
