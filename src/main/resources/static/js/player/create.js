window.onload = function() {

    console.log("create.js");

    const abrirModalConfirmacao = document.getElementById("registrar");
    const confirmarRegistro = document.getElementById("confirmar");
    const cancelar = document.getElementById("cancelar");

    let modalConfirmacao = new bootstrap.Modal(document.getElementById("confirmarRegistro"));

    abrirModalConfirmacao.addEventListener('click', function () {

        let formularioRegistro = document.getElementById("formularioRegistro");

        let name = formularioRegistro.name.value;

        document.getElementById("paragrafoName").innerHTML = name;

        modalConfirmacao.show();

    });

    function enviarFormulario() {
        let formulario = document.getElementById('formularioRegistro');
        formulario.submit();
    }

    function fecharModal() {
        modalConfirmacao.hide();
    }

    confirmarRegistro.addEventListener('click', function () {
        enviarFormulario();
    });

    cancelar.addEventListener('click', function () {
        window.location.href = "/";
    });

}