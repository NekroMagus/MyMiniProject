$(document).ready(function () {
    $("#searchLess").submit(function (event) {
        event.preventDefault();
        let search = {};
        search['maxPrice'] = $('#search-less').val();
        submitAjax("/search/maxPrice", search);
    });
});

$(document).ready(function(){
    $('#searchGreater').submit(event => {
        event.preventDefault();
        let search = {};
        search['minPrice'] = $('#search-greater').val();
        submitAjax("/search/minPrice",search);
    });
});

$(document).ready(function(){
    $('#searchAll').submit(event => {
        event.preventDefault();
        submitAjax("/search/all",null);
    });
});

$(document).ready(function(){
    $('#searchBetween').submit(event => {
        event.preventDefault();
        let search = {};
        search['minPrice'] = $('#search-min').val();
        search['maxPrice'] = $('#search-max').val();
        submitAjax("/search/betweenPrice",search);
    });
});

function submitAjax(url, data) {
    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: url,
        data: JSON.stringify(data),
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