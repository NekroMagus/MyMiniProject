"use strict";
//
let priceMin = 10000;
let priceMax = 150000;
//
let currentSliderHandle;
//
let sliderTrackClientRect = id_sliderTrack.getBoundingClientRect();
let sliderHandleWidth = id_sliderHandleMin.getBoundingClientRect().width;
//
id_sliderHandleMin.addEventListener("mousedown", sliderHandleMouseDown);
id_sliderHandleMax.addEventListener("mousedown", sliderHandleMouseDown);
//
init();

// ____________________________________________________________________________

function init() {
    id_priceInputMin.min = priceMin;
    id_priceInputMax.min = priceMin;
    id_priceInputMin.max = priceMax;
    id_priceInputMax.max = priceMax;
    id_priceInputMin.value = 20000;
    id_priceInputMax.value = 90000;

    setSliderHandlesPositions(getPercentsFromPriceInputs());
}

// ____________________________________________________________________________

id_priceInputMin.oninput = id_priceInputMax.oninput = e => {
    if (id_priceInputMin.value < priceMin || id_priceInputMin.value > priceMax) {
        id_priceInputMin.value = priceMin;
    }
    if (id_priceInputMax.value < priceMin || id_priceInputMax.value > priceMax) {
        id_priceInputMax.value = priceMax;
    }

    setSliderHandlesPositions(getPercentsFromPriceInputs());
};

// ____________________________________________________________________________

function sliderHandleMouseDown(e) {
    if (e.which !== 1) return;
    currentSliderHandle = e.target;

    document.onmousemove = function(e) {
        let x = e.pageX - sliderTrackClientRect.left - sliderHandleWidth / 2;

        if (e.pageX < sliderTrackClientRect.left) x = 0 - sliderHandleWidth / 2;
        if (e.pageX > sliderTrackClientRect.right)
            x = sliderTrackClientRect.width - sliderHandleWidth / 2;

        currentSliderHandle.style.transform = `translateX(${x}px)`;

        let percentes = getPercentsFromSliderHandles();
        setPrices(percentes);
    };

    document.onmouseup = function() {
        document.onmousemove = document.onmouseup = null;
    };
}

// ____________________________________________________________________________

function getPercentsFromSliderHandles() {
    let x1 =
        id_sliderHandleMin.getBoundingClientRect().left -
        sliderTrackClientRect.left;

    let x2 =
        id_sliderHandleMax.getBoundingClientRect().left -
        sliderTrackClientRect.left;

    let percent1 = (x1 + sliderHandleWidth / 2) / sliderTrackClientRect.width;
    let percent2 = (x2 + sliderHandleWidth / 2) / sliderTrackClientRect.width;

    return { percent1: percent1, percent2: percent2 };
}

// ____________________________________________________________________________

function getPercentsFromPriceInputs() {
    let priceRange = priceMax - priceMin;

    let percent1 = (id_priceInputMin.value - priceMin) / priceRange;
    let percent2 = (id_priceInputMax.value - priceMin) / priceRange;

    return { percent1: percent1, percent2: percent2 };
}

// ____________________________________________________________________________

function setPrices(percentes) {
    let priceRange = priceMax - priceMin;
    let minValue = Math.round(
        priceRange * Math.min(percentes.percent1, percentes.percent2) + priceMin
    );
    let maxValue = Math.round(
        priceRange * Math.max(percentes.percent1, percentes.percent2) + priceMin
    );

    id_priceInputMin.value = minValue;
    id_priceInputMax.value = maxValue;
}

// ____________________________________________________________________________

function setSliderHandlesPositions(percentes) {
    let width = sliderTrackClientRect.width;
    let x1 = width * percentes.percent1 - sliderHandleWidth / 2;
    let x2 = width * percentes.percent2 - sliderHandleWidth / 2;
    id_sliderHandleMin.style.transform = `translateX(${x1}px)`;
    id_sliderHandleMax.style.transform = `translateX(${x2}px)`;
}

// ____________________________________________________________________________

id_sliderHandleMin.ondragstart = function() {
    return false;
};

id_sliderHandleMax.ondragstart = function() {
    return false;
};

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

    id_showModelsBtn.classList.remove('hidden');

    let offsetY = (id_showModelsBtn.getBoundingClientRect().height / 2);
    let y = e.pageY - id_verticalTrack.getBoundingClientRect().top - offsetY - scrollY;

    id_showModelsBtn.style.transform = `translateY(${y}px)`;
};

// ____________________________________________________________________________

window.onresize = e => {
    sliderTrackClientRect = id_sliderTrack.getBoundingClientRect();
    setSliderHandlesPositions(getPercentsFromPriceInputs());
}