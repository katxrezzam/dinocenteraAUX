
$(document).ready(function (event) {

    $('.card-body .eBtn').on('click', function (event) {

        $('.form-modal-guardar #usuario-modal').modal()

    })
})

$(document).ready(function (event) {

    $('.card-body .table.usuario .eBtn').on('click', function (event) {
        event.preventDefault()

        let href= $(this).attr('href')

        $.get(href, function(usuario, status){
            $('.form-modal-guardar #id').val(usuario.id)
            $('.form-modal-guardar #nombre').val(usuario.nombre)
            $('.form-modal-guardar #celular').val(usuario.celular)
            $('.form-modal-guardar #email').val(usuario.email)
        })


        $('.form-modal-guardar #usuario-modal').modal()

    })
})