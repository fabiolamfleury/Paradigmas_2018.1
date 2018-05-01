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
influenceInLane('TOP','MID'). % top influenced by mid
influenceInLane('TOP','JUNGLE').
influenceInLane('TOP','BOT').
influenceInLane('MID','JUNGLE').
influenceInLane('MID','TOP').
influenceInLane('MID','BOT').
influenceInLane('BOT','TOP').
influenceInLane('BOT','MID').
influenceInLane('BOT','JUNGLE').
influenceInLane('JUNGLE','TOP').
influenceInLane('JUNGLE','MID').
influenceInLane('JUNGLE','BOT').
