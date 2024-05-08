$.ajax({
  url: "localhost:8080/api/area/all"
})
  .done(function( data ) {
      console.log( "Sample of data:", data);
	  var area = data;
	  let cad = '';
	  area.forEach(function(area, index) {
		html+='<option value="'+area.ard_id+'">'+area.ard_descri+'</option>'
	});

	$("#ard_id").html(cad);
});