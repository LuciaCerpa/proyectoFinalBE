editOdontologo = function (
    id,
    numeroMatricula,
    nombre,
    apellido,
) {
    currentOdontologoId = id;
    document.getElementById("editNombre").value = nombre;
    document.getElementById("editApellido").value = apellido;
    document.getElementById("editNumeroMatricula").value = numeroMatricula;
    editModal.show();
};

editForm.addEventListener("submit", function (event) {
    event.preventDefault();
    const nombre = document.getElementById("editNombre").value;
    const apellido = document.getElementById("editApellido").value;
    const numeroMatricula = document.getElementById("editNumeroMatricula").value;

    fetch(`${apiURL}/odontologo/modificar`, {
        method: "PUT",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify({
            id: currentOdontologoId,
            nombre,
            apellido,
            numeroMatricula
        }),
    })
        .then((response) => response.json())
        .then((data) => {
            console.log(data);
            fetchOdontologos();
            editModal.hide();
            mostrarModal("El odontologo fue modificado exitosamente" );
        })
        .catch((error) => {
            console.error("Error editando odontologo:", error);
        });
});