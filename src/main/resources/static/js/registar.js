$(document).ready(function() {
    // on ready
});

/*async function registrarUsuario() {
    let datos = {};
    datos.name = document.getElementById('txtName').value;
    datos.lastName = document.getElementById('txtLastName').value;
    datos.email = document.getElementById('txtEmail').value;
    datos.phone = document.getElementById('txtPhone').value;
    datos.password = document.getElementById('txtPassword').value;

    let reapeatPassword = document.getElementById('txtRepeatPassword').value;

    if(reapeatPassword != datos.password){
    alert("Password incorrect");
    return;
    }

    const rawResponse = await fetch('api/usuarios', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(datos)
    });
    alert("Registered user successfully!!");
    window.location.href = 'login.html';
}*/

async function registrarUsuario() {
    let datos = {};
    datos.name = document.getElementById('txtName').value;
    datos.lastName = document.getElementById('txtLastName').value;
    datos.email = document.getElementById('txtEmail').value;
    datos.phone = document.getElementById('txtPhone').value;
    datos.password = document.getElementById('txtPassword').value;

    let reapeatPassword = document.getElementById('txtRepeatPassword').value;

    if (reapeatPassword != datos.password) {
        alert("Password incorrect");
        return;
    }

    const rawResponse = await fetch('api/usuarios', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(datos)
    });

    const response = await rawResponse.text();
    console.log("Response from server:", response); // Agrega este registro

    alert("Registered user successfully!!");
    window.location.href = 'login.html';
}
