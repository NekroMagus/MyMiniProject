$(document).ready(function () {
    $("#searchLess").submit(function (event) {
        event.preventDefault();
        let search = {};
        search['maxPrice'] = $('#search-less').val();
        submitAjax("/search/maxPrice", search);
    });
});

$(document).ready(function () {
    $('#searchGreater').submit(event => {
        event.preventDefault();
        let search = {};
        search['minPrice'] = $('#search-greater').val();
        submitAjax("/search/minPrice", search);
    });
});

$(document).ready(function () {
    $('#searchAll').submit(event => {
        event.preventDefault();
        submitAjax("/search/all", null);
    });
});


$(document).ready(function () {
    $('#searchModel').on('change',function () {
        let search = {model: []};
        $('#searchModel input:checked').each(function() {
            search.model.push($(this).attr('name'));
        });
        submitAjax("/search/model", search);
    });
});

$(document).ready(function () {
    $('#sellerPhone').submit(event => {
        event.preventDefault();
        let search = {};
        search['phoneSeller'] = $('#phone').val();
        submitAjax('/search/phone',search);
    });
});

$(document).ready(function () {
    $('#searchBetween').submit(event => {
        event.preventDefault();
        let search = {};
        search['minPrice'] = $('#search-min').val();
        search['maxPrice'] = $('#search-max').val();
        submitAjax("/search/betweenPrice", search);
    });
});

$(document).ready(function () {
    $('#searchAllCriteria').change(event => {
        event.preventDefault();
        let search = {
            minPrice: $('#minPrice').val(),
            maxPrice: $('#maxPrice').val(),
            phoneSeller: $('#phoneSeller').val(),
            model:[]
        };
        $('#searchAllCriteria input:checked').each(function() {
            search.model.push($(this).attr('name'));
        });
        submitAjax('/search/allCriteria', search);
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
            let json = "<h4>Результат поиска</h4>";
            if (data.length === 0) {
                json += "<p>" + "Ничего не найдено" + "</p>";
            } else {
                json += "<p>" + JSON.stringify(data, null, 4) + "</p>";
            }
            $('#feedback').html(json);
        },
        error: (err) => {
            let json = "<h4>Результат поиска</h4><p>" + err.responseText + "</p>";
            $('#feedback').html(json);
        }
    })
}