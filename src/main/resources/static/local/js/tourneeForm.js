$(document).ready(function () {
    $("#datepicker").datepicker();
    $('#site').on('change',function () {
        var id = $(this).val();

        $.ajax({
            method: "GET",
            url: "/cyclo/bySite/"+id,
            dataType: 'json',
            success:function (data) {
                console.log(data)
                var $ville = $('#cyclo');
                $ville.empty();
                for(var i = 0; i < data.length; i++)
                {
                    $ville.append($("<option></option>")
                        .attr("value",data[i].id)
                        .text(data[i].matricule));
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
            url: "/facteur/bySite/"+id,
            dataType: 'json',
            success:function (data) {
                console.log(data)
                var $ville = $('#facteur');
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
});