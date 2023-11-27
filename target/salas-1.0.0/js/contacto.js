function seleccionarRed(red) {
    // Reiniciar todos los logotipos a su color original
    document.querySelectorAll('.logotipo').forEach(function(elemento) {
        elemento.style.backgroundColor = '#4c74af';
    });

    // Cambiar el color del logotipo seleccionado
    document.querySelector(`.logotipo.${red}`).style.backgroundColor = '#555';
}

function enviarFormulario(event) {
    event.preventDefault(); // Evitar el envío del formulario por defecto

    // Aquí podrías agregar lógica para enviar los datos del formulario al servidor si es necesario

    // Mostrar el mensaje de agradecimiento y limpiar el formulario
    document.getElementById('agradecimiento').style.display = 'block';
    document.getElementById('contactoForm').reset();

    // Puedes reiniciar también los colores de los logotipos si lo deseas
    document.querySelectorAll('.logotipo').forEach(function(elemento) {
        elemento.style.backgroundColor = '#4c74af';
    });
}
