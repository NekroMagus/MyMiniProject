"use strict";

id_showModelsBtn.onclick = async function() {
    let response = await fetch("https://jsonplaceholder.typicode.com/users");

    if (response.ok) {
        let json = await response.json();
        createProductListItems(id_productList, json);
    } else {
        alert("Ошибка HTTP: " + response.status);
    }

    id_showModelsBtn.classList.add('hidden');
};

function createProductListItems(parentElement, list) {
    let firstChild = parentElement.firstElementChild.cloneNode(true);

    while (parentElement.firstChild) {
        parentElement.removeChild(parentElement.firstChild);
    }

    for (const item of list) {
        let cloneEl = firstChild.cloneNode(true);
        let descriptionElement = cloneEl.querySelector(
            ".product-list__item-description"
        );
        let numberElement = cloneEl.querySelector(".product-list__item-number");

        numberElement.textContent = item.id;
        descriptionElement.textContent = item.username;
        parentElement.append(cloneEl);
    }
}