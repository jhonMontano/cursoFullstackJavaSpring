$(document).ready(function() {
    cargarUsuarios();
    $('#usuarios').DataTable();
});

async function cargarUsuarios() {
    const rawResponse = await fetch('api/usuarios', {
        method: 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }
    });
    const usuarios = await rawResponse.json();

    let listadoHtml = '';
    for (let usuario of usuarios) {
        let botonEliminar = '<a href="#" onclick="eliminarUsuario(' + usuario.id + ')" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a>';

        let usuarioHtml = '<tr><td>' + usuario.id + '</td><td>' + usuario.name + '</td><td>' + usuario.lastName + '</td><td>' + usuario.email + '</td><td>' + usuario.phone + '</td><td>' + botonEliminar + '</td></tr>';

        listadoHtml += usuarioHtml;
    }

    document.querySelector('#usuarios tbody').insertAdjacentHTML('beforeend', listadoHtml);
}
function getHeaders() {
    return {
     'Accept': 'application/json',
     'Content-Type': 'application/json',
     'Authorization': localStorage.token
   };
}
async function eliminarUsuario(id) {
    if (!confirm('¿Desea eliminar este usuario?')) {
        return;
    }

    const request = await fetch('api/usuarios/' + id, {
        method: 'DELETE',
        headers: getHeaders()
    });

    location.reload();
}