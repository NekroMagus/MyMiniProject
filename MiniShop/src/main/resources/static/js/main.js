$(document).ready(function () {
    $("#search").submit(function (event) {
        event.preventDefault();
        getPriceAjax();
    });
});

function getPriceAjax() {

    let search = {};
    search['price'] = $('#search-price').val();

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/search",
        data: JSON.stringify(search),
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: (data) => {
            let json = "<h4>Результат поиска</h4><p>"+JSON.stringify(data,null,4)+"</p>";
            $('#feedback').html(json);
        },
        error: (err) => {
            let json = "<h4>Результат поиска</h4><p>" + err.responseText + "</p>";
            $('#feedback').html(json);
        }
    })
}