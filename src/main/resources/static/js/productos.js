const API = "http://localhost:8080/productos";

async function cargarProductos() {

    const respuesta = await fetch(API);
    const productos = await respuesta.json();

    let filas = "";

    productos.forEach(p => {

        filas += `
            <tr>
                <td>${p.id}</td>
                <td>${p.nombre}</td>
                <td>$${p.precio}</td>
                <td>${p.stock}</td>
                <td>${p.color ?? ""}</td>
            </tr>
        `;

    });

    document.getElementById("tablaProductos").innerHTML = filas;
}

async function guardarProducto() {

    const producto = {
        nombre: document.getElementById("nombre").value,
        precio: Number(document.getElementById("precio").value),
        stock: Number(document.getElementById("stock").value),
        color: document.getElementById("color").value
    };

    const respuesta = await fetch(API, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(producto)
    });

    if (respuesta.ok) {

        alert("Producto guardado correctamente.");

        document.getElementById("nombre").value = "";
        document.getElementById("precio").value = "";
        document.getElementById("stock").value = "";
        document.getElementById("color").selectedIndex = 0;

        await cargarProductos();

    } else {

        alert("No se pudo guardar el producto.");

    }
}

cargarProductos();
