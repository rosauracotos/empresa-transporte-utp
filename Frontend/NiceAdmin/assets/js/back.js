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
	url: "http://localhost:8080/api/comisionafp/listar"
	})
	.done(function( data ) {
		var comafp = data;
		let html = '<option selected>-- Seleccione --</option>';
		comafp.forEach(function(comafp, index) {
			html+='<option value="'+comafp.id+'">'+comafp.descripcion+'</option>'
		});
	$("#caf_id").html(html);
});

$.ajax({
	url: "http://localhost:8080/api/turno/all"
	})
	.done(function( data ) {
		var turnos = data;
		let html = '<option selected>-- Seleccione --</option>';
		turnos.forEach(function(turnos, index) {
			html+='<option value="'+turnos.id+'">'+turnos.descripcion+'</option>'
		});
	$("#tur_id").html(html);
});

$.ajax({
	url: "http://localhost:8080/api/ubigeoProvincia/departamento/"
	})
	.done(function( data ) {
		var ubidep = data;
		let html = '<option selected>-- Seleccione --</option>';
		ubidep.forEach(function(ubidep, index) {
			html+='<option value="'+ubidep.id+'">'+ubidep.descripcion+'</option>'
		});
	$("#ude_id").html(html);
});

$("#ude_id").on("change",function(){
	let selectProvincia = $("#upr_id");
	selectProvincia.html("<option selected>-- Seleccione --</option>").attr("disabled",true);

	let selectDitrito = $("#udi_id");
	selectDitrito.html("<option selected>-- Seleccione --</option>").attr("disabled",true);

	let ude_id = $(this).val();
	if(ude_id!=null){
		$.ajax({
			url: "http://localhost:8080/api/ubigeoProvincia/departamento/"+ude_id
			})
			.done(function( data ) {
				let proDep = data;
				let html = '<option selected>-- Seleccione --</option>';
				proDep.forEach(function(proDep, index) {
					html+='<option value="'+proDep.id+'">'+proDep.descripcion+'</option>'
				});
			$("#upr_id").attr("disabled",false);
			$("#upr_id").html(html);
		});
	}
	else{
		let html = '<option selected>-- Seleccione --</option>';

		$("#upr_id").attr("disabled",true);
		$("#upr_id").html(html);

		$("#udi_id").attr("disabled",true);
		$("#udi_id").html(html);
	}
});

$("#upr_id").on("change",function(){
	let selectDistrito = $("#udi_id");
	selectDistrito.html("<option selected>-- Seleccione --</option>").attr("disabled",true);

	let upr_id = $(this).val();
	if(upr_id!=null){
		$.ajax({
			url: "http://localhost:8080/api/ubigeoDistrito/provincia/"+upr_id
			})
			.done(function( data ) {
				let disPro = data;
				let html = '<option selected>-- Seleccione --</option>';  
				disPro.forEach(function(disPro, index) {
					html+='<option value="'+disPro.id+'">'+disPro.descripcion+'</option>'
				});
			$("#udi_id").attr("disabled",false);
			$("#udi_id").html(html);
		});
	}
	else{
		let html = '<option selected>-- Seleccione --</option>';

		$("#udi_id").attr("disabled",true);
		$("#udi_id").html(html);
	}
});