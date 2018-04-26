
get_element_row(row(Name,_)):-print(Name).
get_header([Head|Tail]):-get_element_row(Head).
get_rows_data(Data):-csv_read_file('dataGame/champs.csv', Data),get_header(Data).
				 



