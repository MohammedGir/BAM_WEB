$(document).ready(function () {
    var datatable =  $('#dataTable').DataTable({
        "columns": [
            { "data": "id" },
            { "data": "adresse" },
            { "data": "type" },
            { "data": "cp" },
            { "data": "etat" },
            {
                "data":"tournee.numero",
                "defaultContent": "Empty"
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
    $('#site').on('change',function () {
        var id = $(this).val();

        $.ajax({
            method: "GET",
            url: "/tournee/bySite/"+id,
            dataType: 'json',
            success:function (data) {
                console.log(data)
                var $ville = $('#tournee');
                $ville.empty();
                for(var i = 0; i < data.length; i++)
                {
                    $ville.append($("<option></option>")
                        .attr("value",data[i].id)
                        .text(data[i].numero));
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
            url: "/bls/bySite/"+id,
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
    $('#tournee').on('change',function () {
        var id = $(this).val();
        $.ajax({
            method: "GET",
            url: "/bls/byTournee/"+id,
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