"use strict";
import DoubleSlider from "./double-slider.js";

//
let priceMin = 0;
let priceMax = 2200;
let priceRange = priceMax - priceMin;

let slider1 = new DoubleSlider({
    track: id_sliderTrack,
    handleOne: id_sliderHandleMin,
    handleTwo: id_sliderHandleMax,
    rangeLine: id_sliderRangeLine
});

// ____________________________________________________________________________

function init() {
    setSliderValueFromPriceInputs();

    id_priceInputMin.min = priceMin;
    id_priceInputMax.min = priceMin;
    id_priceInputMin.max = priceMax;
    id_priceInputMax.max = priceMax;
    id_priceInputMin.value = 5;
    id_priceInputMax.value = 5540;

    setSliderValueFromPriceInputs();
}

// ____________________________________________________________________________

document.addEventListener("onDoubleSliderChangeValue", function(args) {
    id_priceInputMin.value = Math.round(args.detail.value.min * priceRange + priceMin);
    id_priceInputMax.value = Math.round(args.detail.value.max * priceRange + priceMin);
});

id_priceInputMin.oninput = id_priceInputMax.oninput = e => {
    if (id_priceInputMin.value < priceMin || id_priceInputMin.value > priceMax) {
        id_priceInputMin.value = priceMin;
    }
    if (id_priceInputMax.value < priceMin || id_priceInputMax.value > priceMax) {
        id_priceInputMax.value = priceMax;
    }

    setSliderValueFromPriceInputs();
};

function setSliderValueFromPriceInputs() {
    let min = (id_priceInputMin.value - priceMin) / priceRange;
    let max = (id_priceInputMax.value - priceMin) / priceRange;

    slider1.setValue(min, max);
}

// ____________________________________________________________________________

formCatalogFilter.onsubmit = e => {
    e.preventDefault();

    let formData = new FormData(formCatalogFilter);

    formData.forEach((value, key) => {
        console.log("key: " + key);
        console.log("value: " + value);
    });
};

formCatalogFilter.onclick = e => {
    if (e.target === formCatalogFilter) return;

    let trackClientRect = id_verticalTrack.getBoundingClientRect();
    let showModelsBtnClientRect = id_showModelsBtn.getBoundingClientRect();
    let offsetY = id_showModelsBtn.getBoundingClientRect().height / 2;
    let y = e.pageY - trackClientRect.top - offsetY - scrollY;

    if (y < 0) y = 0;
    if (y + showModelsBtnClientRect.height > trackClientRect.height) {
        y = trackClientRect.height - showModelsBtnClientRect.height;
    }

    id_showModelsBtn.style.transform = `translateY(${y}px)`;
    id_showModelsBtn.classList.remove("hidden");
};


/* AJAX */
$(document).ready( async function () {
    setPrice('/search/min', '#id_priceInputMin');
    setPrice('/search/max','#id_priceInputMax');
    await init();
});

function setPrice(url, id) {
    $.ajax({
        type : 'GET',
        url,
        timeout: 60000,
        success: data => {
            $(id).val(+data);
            if(id === '#id_priceInputMin') {
                priceMin = +data;
            } else if (id === '#id_priceInputMax'){
                priceMax = +data;
            }
        },
        error: err => {
           $(id).html(err.responseText);
        }
    });
}


function getResult(data) {
    console.log(data);
}