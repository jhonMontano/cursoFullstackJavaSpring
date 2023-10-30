$(document).ready(function() {
    cargarUsuarios();
    $('#usuarios').DataTable();
});

async function cargarUsuarios(){
    const rawResponse = await fetch('usuarios', {
        method: 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }
    });
    const usuarios = await rawResponse.json();
    let listadoHtml = '';
    for(let usuario of usuarios){
        let usuarioHtml = '<tr><td>'+usuario.id+'</td><td>'+usuario.name+'</td><td>'+usuario.lastName+'</td><td>'
            +usuario.email+'</td><td>'+usuario.phone
            +'</td><td><a href="#" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a></td></tr>';

        listadoHtml += usuarioHtml;
    }

    document.querySelector('#usuarios tbody').insertAdjacentHTML('beforeend', listadoHtml);
}