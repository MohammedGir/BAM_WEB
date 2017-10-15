$(document).ready(function () {
    $("#datepicker").datepicker();
    var datatable = $('#dataTable').DataTable({
        "columns": [
            { "data": "id" },
            { "data": "numero" },
            {
                "data": "dateTournee",
                "render": function (data) {
                    var date = new Date(data);
                    var month = date.getMonth() + 1;
                    return (month.length > 1 ? month : "0" + month) + "/" + date.getDate() + "/" + date.getFullYear();
                }
            },
            { "data": "trajetLongeur" },
            { "data": "mntIndemnite" },
            {
                "data":"site.nom",
                "defaultContent": "Empty"
            },
            {
                "data":"facteur.nom",
                "defaultContent": ""
            },
            {
                "data":"cyclo.matricule",
                "defaultContent": ""
            }
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

    $('#ville').on('change',function () {
        var id = $(this).val();

        $.ajax({
            method: "GET",
            url: "/site/byVille/"+id,
            dataType: 'json',
            success:function (data) {
                console.log(data)
                var $ville = $('#site');
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
    $('#site').on('change',function () {
        var id = $(this).val();
        $.ajax({
            method: "GET",
            url: "/tournee/bySite/"+id,
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

    });
    $('#ville').on('change',function () {
        var id = $(this).val();
        $.ajax({
            method: "GET",
            url: "/tournee/byVille/"+id,
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

    });

});