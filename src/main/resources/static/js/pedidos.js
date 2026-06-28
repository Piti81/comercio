const API_PEDIDOS = "http://localhost:8080/pedidos";
const API_PRODUCTOS = "http://localhost:8080/productos";

async function cargarProductos() {


const respuesta = await fetch(API_PRODUCTOS);
const productos = await respuesta.json();

const combo = document.getElementById("producto");
combo.innerHTML = "";

productos.forEach(p => {

    combo.innerHTML += `
        <option value="${p.id}">
            ${p.nombre}
        </option>
    `;

});


}

async function cargarPedidos() {


const respuesta = await fetch(API_PEDIDOS);
const pedidos = await respuesta.json();

let filas = "";

pedidos.forEach(p => {

    filas += `
        <tr>
            <td>${p.id}</td>
            <td>${p.cliente}</td>
            <td>${p.fecha}</td>
            <td>${p.tipoEntrega}</td>
        </tr>
    `;

});

document.getElementById("tablaPedidos").innerHTML = filas;


}

async function guardarPedido() {


const pedido = {

    cliente: document.getElementById("cliente").value,

    tipoEntrega: document.getElementById("tipoEntrega").value,

    lineas: [
        {
            cantidad: Number(document.getElementById("cantidad").value),
            producto: {
                id: Number(document.getElementById("producto").value)
            }
        }
    ]

};

const respuesta = await fetch(API_PEDIDOS, {

    method: "POST",

    headers: {
        "Content-Type": "application/json"
    },

    body: JSON.stringify(pedido)

});

if (respuesta.ok) {

    alert("Pedido guardado correctamente.");

    document.getElementById("cliente").value = "";
    document.getElementById("cantidad").value = 1;

    await cargarPedidos();

} else {

    alert("No se pudo guardar el pedido.");

}


}

cargarProductos();
cargarPedidos();
