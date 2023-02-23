window.onload = () => {
    SearchService.getInstance().loadCategories();
}

const searchObj = {
    page: 1,
    searchValue: null,
    category: null,
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

    getCategory() {
        let returnData = null;

        $.ajax({
            async: false,
            type: "get",
<<<<<<< HEAD
            url: "http://127.0.0.1:8000/api/admin/studyArea",
            dataType: "json",
            success: response => {
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

=======
            url: "http://127.0.0.1:8000/api/search",
            data: searchObj,
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
        
        const responseData = SearchApi.getInstance().getCategory();
        
        responseData.forEach((categoryObj,index) => {
          
            categoryList.innerHTML += `
                <input type="radio" name="test1" class="info-radio" id="${categoryObj.category}" value="${categoryObj.category}">
                <label for="${categoryObj.category}">${categoryObj.category}</label>
            `;

            if(responseData.length -1 == index) {
                categoryList.innerHTML += `
                    <input type="radio" name="test1" class="info-radio" id="${categoryObj.category}" value="${categoryObj.category}">
                    <label for="${categoryObj.category}">장바구니</label>
                ` 
            }
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
>>>>>>> 0f12c4d2b441e3f620b923b4e7ff5969b86e740b
