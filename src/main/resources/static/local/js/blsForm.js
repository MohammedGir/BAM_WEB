$(document).ready(function () {
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
});