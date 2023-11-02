$(document).ready(function() {
    // on ready
});

async function iniciarSesion() {
    let datos = {};
    datos.email = document.getElementById('txtEmail').value;
    datos.password = document.getElementById('txtPassword').value;

    const rawResponse = await fetch('api/login', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(datos)
    });

    const response = await rawResponse.text();
    if(response != 'FAIL') {
        localStorage.token = response;
        localStorage.email = datos.email;
        window.location.href = 'usuarios.html';
    } else {
        alert("User or password incorrect. Please try again.");
    }
}
