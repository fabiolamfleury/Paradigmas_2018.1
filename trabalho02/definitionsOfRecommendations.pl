:-consult('knowledge.pl').

findParticipants(ChampId,Lane):-findall(IdStats,participant(IdStats,_,ChampId,_,Lane),L),
                                
