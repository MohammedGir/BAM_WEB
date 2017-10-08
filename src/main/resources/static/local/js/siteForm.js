
    $(document).ready(function () {
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

    });
