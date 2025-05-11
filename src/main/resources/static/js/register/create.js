window.onload = function() {

    console.log("create.js");

    const abrirModalConfirmacao = document.getElementById("registrar");
    const cancelar = document.getElementById("cancelar");

    let modalConfirmacao = new bootstrap.Modal(document.getElementById("confirmarRegistro"));

    abrirModalConfirmacao.addEventListener('click', function () {

        let formularioRegistro = document.getElementById("formularioRegistro");

        let name = formularioRegistro.name.value;
        let kills = formularioRegistro.kills.value;

        document.getElementById("paragrafoName").innerHTML = name;
        document.getElementById("paragrafoKills").innerHTML = kills;

        modalConfirmacao.show();

    });


    function fecharModal() {
        modalConfirmacao.hide();
    }

    cancelar.addEventListener('click', function () {
        window.location.href = "/";
    });

}