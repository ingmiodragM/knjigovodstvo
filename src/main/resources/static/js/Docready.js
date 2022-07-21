
			$(document).ready(function() {

				$.ajax({
					url : 'http://localhost:8080/knjigovodstvo/knjigovodstvos',
					success : function(data) {
						$("#table").DataTable({
							//      ajax: 'http://localhost:8080/knjigovodstvo/knjigovodstvos',
							type : "get",
							dataType : 'json',
							data : data,
							jsonpCallback : "onJSONPLoad",
							//      "bProcessing": true,
							searching : true,
							searchBuilder : {
								enterSearch : true
							},

							columns : [ {
								"data" : "id"
							}, {
								"data" : "konto_dug"
							}, {
								"data" : "konto_pot"
							}, {
								"data" : "datum"
							}, {
								"data" : "datum_valute"
							}, {
								"data" : "br_naloga"
							}, {
								"data" : "opis"
							}, {
								"data" : "sadrzaj"
							}, {
								"data" : "duguje"
							}, {
								"data" : "potrazuje"
							}, {
								"data" : "konto"
							}, ]
						});
					},

					error : function() {
						alert('Error occurs!');
					}

				});
			$(document).ready(function() {	
			
			});
			
			
				
			});

