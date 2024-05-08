$.ajax({
  url: "http://localhost:8080/api/areaDenominacion/all"
  })
	.done(function( data ) {		
		var area = data;		
		let html = '<option selected>-- Seleccione --</option>';
		area.forEach(function(area, index) {
			console.log(area);
			html+='<option value="'+area.id+'">'+area.descripcion+'</option>'
		});
	$("#ard_id").html(html);
});

