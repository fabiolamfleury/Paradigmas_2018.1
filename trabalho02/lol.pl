:- use_module(library(csv)).
import_champs:-
    csv_read_file('knowledge/champs.csv', ChampsData, [functor(champ)]),
    maplist(assert, ChampsData).

import_participants:-
    csv_read_file('knowledge/participants.csv', ParticipantsData, [functor(participant)]),
    maplist(assert, ParticipantsData).

import_stats1:-
    csv_read_file('knowledge/stats1.csv', Stats1Data, [functor(stats)]),
    maplist(assert, Stats1Data).

import_stats2:-
    csv_read_file('knowledge/stats2.csv', Stats2Data, [functor(stats)]),
    maplist(assert, Stats2Data).

import_data:- import_champs(), import_participants(), import_stats1(), import_stats2().
