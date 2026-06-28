function guardarCategoria() {


const categoria = {
    nombre: document.getElementById("nombre").value
};

fetch("http://localhost:8080/categorias", {

    method: "POST",

    headers: {
        "Content-Type": "application/json"
    },

    body: JSON.stringify(categoria)

})
.then(response => {

    if (response.ok) {

        alert("Categoría guardada correctamente.");

        document.getElementById("nombre").value = "";

        cargarCategorias();

    } else {

        alert("No se pudo guardar la categoría.");

    }

});


}

function cargarCategorias() {

fetch("http://localhost:8080/categorias")
    .then(response => response.json())
    .then(categorias => {

        let filas = "";

        categorias.forEach(c => {

            filas += `
                <tr>
                    <td>${c.id}</td>
                    <td>${c.nombre}</td>
                </tr>
            `;

        });

        document.getElementById("tablaCategorias").innerHTML = filas;

    });


}

cargarCategorias();
