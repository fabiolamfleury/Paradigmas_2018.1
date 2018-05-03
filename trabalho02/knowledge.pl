:- use_module(library(csv)).
/*Import champs.csv*/
import_champs:-
    csv_read_file('knowledgeBase/champs.csv', ChampsData, [functor(champ)]),
    maplist(assert, ChampsData).

/*Import participants.csv*/
import_participants:-
    csv_read_file('knowledgeBase/participants.csv', ParticipantsData, [functor(participant)]),
    maplist(assert, ParticipantsData).

/*Import stats1.csv*/
import_stats1:-
    csv_read_file('knowledgeBase/stats1.csv', Stats1Data, [functor(stats)]),
    maplist(assert, Stats1Data).

/*Import stats1.csv*/
import_stats2:-
    csv_read_file('knowledgeBase/stats2.csv', Stats2Data, [functor(stats)]),
    maplist(assert, Stats2Data).

/*import all data .csv*/
import_data:- import_champs(), import_participants(), import_stats1(), import_stats2().

/*lanes game*/
lane('BOT').
lane('MID').
lane('TOP').
lane('JUNGLE').

/*Influence in lanes*/
influence_in_lane('TOP','MID'). % top influenced by mid
influence_in_lane('TOP','JUNGLE').
influence_in_lane('TOP','BOT').
influence_in_lane('MID','JUNGLE').
influence_in_lane('MID','TOP').
influence_in_lane('MID','BOT').
influence_in_lane('BOT','TOP').
influence_in_lane('BOT','MID').
influence_in_lane('BOT','JUNGLE').
influence_in_lane('JUNGLE','TOP').
influence_in_lane('JUNGLE','MID').
influence_in_lane('JUNGLE','BOT').

% How many players are allowed in each lane
players_in_lane('BOT', 2).
players_in_lane('TOP', 1).
players_in_lane('JUNGLE', 1).
players_in_lane('MID', 1).
