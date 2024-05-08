$.ajax({
  url: "http://localhost:8080/api/areaDenominacion/all"
  })
	.done(function( data ) {		
		var area = data;		
		let html = '<option selected>-- Seleccione --</option>';
		area.forEach(function(area, index) {
			html+='<option value="'+area.id+'">'+area.descripcion+'</option>'
		});
	$("#ard_id").html(html);
});

$.ajax({
	url: "http://localhost:8080/api/cargo/all"
	})
	.done(function( data ) {		
		var cargo = data;		
		let html = '<option selected>-- Seleccione --</option>';
		cargo.forEach(function(cargo, index) {
			html+='<option value="'+cargo.id+'">'+cargo.descripcion+'</option>'
		});
	$("#crg_id").html(html);
  });

$.ajax({
	url: "http://localhost:8080/api/tipoDocumento/all"
	})
	.done(function( data ) {		
		var tipdoc = data;		
		let html = '<option selected>-- Seleccione --</option>';
		tipdoc.forEach(function(tipdoc, index) {
			html+='<option value="'+tipdoc.id+'">'+tipdoc.descripcion+'</option>'
		});
	$("#tdi_id").html(html);
  });

$.ajax({
	url: "http://localhost:8080/api/grupoLaboral/all"
	})
	.done(function( data ) {		
		var grllab = data;		
		let html = '<option selected>-- Seleccione --</option>';
		grllab.forEach(function(grllab, index) {
			html+='<option value="'+grllab.id+'">'+grllab.descripcion+'</option>'
		});
	$("#grl_id").html(html);
});

$.ajax({
	url: "http://localhost:8080/api/estadoEmpleado/all"
	})
	.done(function( data ) {		
		var estemp = data;		
		let html = '<option selected>-- Seleccione --</option>';
		estemp.forEach(function(estemp, index) {
			html+='<option value="'+estemp.id+'">'+estemp.descripcion+'</option>'
		});
	$("#ese_id").html(html);
});

$.ajax({
	url: "http://localhost:8080/api/tipoDocumento/all"
	})
	.done(function( data ) {
		var tipdoi = data;
		let html = '<option selected>-- Seleccione --</option>';
		tipdoi.forEach(function(tipdoi, index) {
			html+='<option value="'+tipdoi.id+'">'+tipdoi.descripcion+'</option>'
		});
	$("#tdo_id").html(html);
});

$.ajax({
	url: "http://localhost:8080/api/tipoGenero/all"
	})
	.done(function( data ) {
		var tipgen = data;
		let html = '<option selected>-- Seleccione --</option>';
		tipgen.forEach(function(tipgen, index) {
			html+='<option value="'+tipgen.id+'">'+tipgen.descripcion+'</option>'
		});
	$("#tge_id").html(html);
});

$.ajax({
	url: "http://localhost:8080/api/estadoCivil/all"
	})
	.done(function( data ) {
		var estciv = data;
		let html = '<option selected>-- Seleccione --</option>';
		estciv.forEach(function(estciv, index) {
			html+='<option value="'+estciv.id+'">'+estciv.descripcion+'</option>'
		});
	$("#esc_id").html(html);
});

$.ajax({
	url: "http://localhost:8080/api/ubigeoDepartamento/all"
	})
	.done(function( data ) {
		var ubidep = data;
		let html = '<option selected>-- Seleccione --</option>';
		ubidep.forEach(function(ubidep, index) {
			html+='<option value="'+ubidep.id+'">'+ubidep.descripcion+'</option>'
		});
	$("#ude_id").html(html);
});

$.ajax({
	url: "http://localhost:8080/api/ubigeoDepartamento/all"
	})
	.done(function( data ) {
		var ubidep = data;
		let html = '<option selected>-- Seleccione --</option>';
		ubidep.forEach(function(ubidep, index) {
			html+='<option value="'+ubidep.id+'">'+ubidep.descripcion+'</option>'
		});
	$("#ude_id").html(html);
});

$.ajax({
	url: "http://localhost:8080/api/bancos/all"
	})
	.done(function( data ) {
		var bancos = data;
		let html = '<option selected>-- Seleccione --</option>';
		bancos.forEach(function(bancos, index) {
			html+='<option value="'+bancos.id+'">'+bancos.nombreCompleto+'</option>'
		});
	$("#ban_id").html(html);
});

$.ajax({
	url: "http://localhost:8080/api/regimenPensionario/all"
	})
	.done(function( data ) {
		var regpen = data;
		let html = '<option selected>-- Seleccione --</option>';
		regpen.forEach(function(regpen, index) {
			html+='<option value="'+regpen.id+'">'+regpen.descripcion+'</option>'
		});
	$("#rpe_id").html(html);
});

$.ajax({
	url: "http://localhost:8080/api/comisionafp/all"
	})
	.done(function( data ) {
		var comafp = data;
		let html = '<option selected>-- Seleccione --</option>';
		comafp.forEach(function(comafp, index) {
			html+='<option value="'+comafp.id+'">'+comafp.descripcion+'</option>'
		});
	$("#caf_id").html(html);
});

function traepro(){
	alert('Hola');
}
