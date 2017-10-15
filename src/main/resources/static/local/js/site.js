$(document).ready(function() {
    $("#datepicker").datepicker();
    var datatable = $('#dataTable').DataTable({
        "columns": [
            { "data": "id" },
            { "data": "nom" },
            { "data": "cp" },
            { "data": "type" },
            { "data": "ville.nom" }

        ]
    });
    $('#dataTable tbody').on( 'click', 'tr', function () {
        if ( $(this).hasClass('selected') ) {
            $(this).removeClass('selected');
        }
        else {
            datatable.$('tr.selected').removeClass('selected');
            $(this).addClass('selected');
        }
    } );
    $('#region').on('change',function () {
        var id = $(this).val();

        $.ajax({
            method: "GET",
            url: "/ville/"+id,
            dataType: 'json',
            success:function (data) {
                console.log(data)
                var $ville = $('#ville');
                $ville.empty();
                for(var i = 0; i < data.length; i++)
                {
                   $ville.append($("<option></option>")
                       .attr("value",data[i].id)
                       .text(data[i].nom));
                }
            },
            error:function (xhr, status, err) {
                console.log(status,err);
            },

        });

    });
    $('#ville').on('change',function () {
        var id = $(this).val();
        $.ajax({
            method: "GET",
            url: "/site/byVille/"+id,
            dataType: 'json',
            success:function (data) {
                console.log(data)
                datatable.clear().draw();
                datatable.rows.add(data); // Add new data
                datatable.columns.adjust().draw(); // Redraw the DataTable

            },
            error:function (xhr, status, err) {
                console.log(status,err);
            },

        });

    })
});