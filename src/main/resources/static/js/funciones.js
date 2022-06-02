function eliminar(id){
	swal({
			title:"¿Está seguro de Eliminar?",
			text : "Una vez eliminado, no podrá recuperar este dato.",
			icon: "warning",
			buttons: true,
			dangerMode: true,
		})
		.then((OK) =>{
			if (OK) {
				$.ajax({
					url: "/eliminar/" + id,
					success: function(res) {
						console.log(res);
					},
				});
				swal("Se eliminó correctamente", {
					icon: "success",
				}).then((ok) => {
					if (ok) {
						location.href = "/listarPerfil";
					}
				});
			} else{
				swal("Proceso de eliminación canselado. Su dato está a salvo")
			}
	});
}