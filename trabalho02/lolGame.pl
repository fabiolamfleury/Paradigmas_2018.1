

a(row(element,_),X):-element.
thir([Head|Tail]):-a(Head,X).
get_rows_data(Data):-csv_read_file('champs.csv', Data),thir(Data).
				 



