window.onload = () => {
    SearchService.getInstance().loadCategories();
}

const searchObj = {
    page: 1,
    searchValue: null,
    studyArea: new Array(),
    count: 10
}

class SearchApi {
    static #instance = null;
    static getInstance() {
        if(this.#instance == null) {
            this.#instance = new SearchApi();
        }
        return this.#instance;
    }

    getStudyArea() {
        let returnData = null;

        $.ajax({
            async: false,
            type: "get",
            url: "http://127.0.0.1:8000/api/admin/studyArea",
            dataType: "json",
            success : response => {
                console.log(response);
                returnData = response.data;
            },
            error: error => {
                console.log(error);
            }

        });
        return returnData;
    }
}
class SearchService {
    static #instance = null;
    static getInstance() {
        if(this.#instance == null) {
            this.#instance = new SearchService();
        }
        return this.#instance;
    }

    loadCategories() {
        const categoryList = document.querySelector(".info");
        categoryList.innerHTML = ``;
        
        const responseData = SearchApi.getInstance().getStudyArea();
        responseData.forEach(categoryObj => {
            categoryList.innerHTML += `
                    <input type="radio" class="info-radio" id="${categoryObj.category}" value="${categoryObj.category}">
                    <label for="${categoryObj.category}">${categoryObj.category}</label>
            `;
        });
    }
}

// class ComponentEvent {
//     static #instance = null;
//     static getInstance() {
//         if(this.#instance == null) {
//             this.#instance = new ComponentEvent();
//         }
//         return this.#instance;
//     }

//     addClickEventCategoryCheckboxs() {
//         const checkboxs = document.querySelectorAll(".category-checkbox");
        
//         checkboxs.forEach(checkbox => {
//             checkbox.onclick = () => {
//                 if(checkbox.checked) {
//                     searchObj.categories.push(checkbox.value);
//                 }else {
//                     const index = searchObj.categories.indexOf(checkbox.value)
//                     searchObj.categories.splice(index, 1);
//                 }

//             }
//         }); 
//     }
// }
