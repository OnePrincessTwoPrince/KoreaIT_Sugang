window.onload = () => {
    SearchService.getInstance().loadCategories();
<<<<<<< HEAD
}

let searchObj = {
    page: 1,
    searchValue: null,
    category: null,
    count: 10
}

=======
    SearchService.getInstance().clearCourseList();
    SearchService.getInstance().loadOpenCourse();

    ComponentEvent.getInstance().addClickEventCategoryRadios();
} 

const searchObj = {
    page: 1,
    classification: new Array(),
    searchValue: "",
    limit: "Y",
    count: 8
}

>>>>>>> parent of a4913de (지금까지 한거 올린거)
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
<<<<<<< HEAD
=======

    getTotalCount(searchObj) {
        let returnData = null;

        $.ajax({
            async: false,
            type: "get",
            url: "http://localhost:8000/api/search/total",
            data: searchObj,
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

    getOpenCourse() {
        let responseData = null;

        $.ajax({
            async: false,
            type: "get",
            url: "http://localhost:8000/api/open",
            data: searchObj,
            dataType: "json",
            success : response => {
                responseData = response.data;
            },
            error : error => {
                console.log(error);
            }
        });
        return responseData;
    }
>>>>>>> parent of a4913de (지금까지 한거 올린거)
}
class SearchService {
    static #instance = null;
    static getInstance() {
        if(this.#instance == null) {
            this.#instance = new SearchService();
        }
        return this.#instance;
    }

<<<<<<< HEAD
=======
    setMexPage() {
        const totalCount = SearchApi.getInstance().getTotalCount();
        maxPage = totalCount % 10 == 0 ? totalCount / 10 : Math.floor(totalCount / 10) + 1;
    }
    
>>>>>>> parent of a4913de (지금까지 한거 올린거)
    loadCategories() {
        const categoryList = document.querySelector(".info");
        categoryList.innerHTML = ``;
        
        const responseData = SearchApi.getInstance().getCategory();
        
        responseData.forEach((categoryObj,index) => {
          
            categoryList.innerHTML += `
                <input type="radio" name="test1" class="info-radio" id="${categoryObj}" value="${categoryObj}">
                <label for="${categoryObj}">${categoryObj}</label>
            `;

            if(responseData.length -1 == index) {
                categoryList.innerHTML += `
                    <input type="radio" name="test1" class="info-radio" id="${categoryObj}" value="${categoryObj}">
                    <label for="${categoryObj}">장바구니</label>
                ` 
            }
        });
<<<<<<< HEAD

=======
    }

    clearCourseList(){
        const pageController = document.querySelector(".opened-table tbody");
        pageController.innerHTML = "";
    }
    

    loadOpenCourse() {
        const responseData = SearchApi.getInstance().getOpenCourse();
        const openTable = document.querySelector(".opened-table tbody");

        openTable.innerHTML = ``;

        responseData.forEach((data, index) => {
            openTable.innerHTML +=`
            <tr>
                <td><button type="submit" class="submit-button1">신청</button></td>
                <td>${data.classification}</td>
                <td>${data.subjectCode}</td>
                <td>${data.subjectName}</td>
                <td>${data.credit}</td>
                <td>${data.professorName}</td>
                <td>${data.building} / ${data.lectureTime}</td>
                <td></th>
                <td>Y</th>
                <td></th>
            </tr>
            `;
        });
        this.loadPageController();
        
    }

    loadPageController() {
        const pageController = document.querySelector(".page-controller");
        pageController.innerHTML = "";

        const totalCount = SearchApi.getInstance().getTotalCount(searchObj);
        const maxPageNumber = totalCount % searchObj.count == 0 
                            ? Math.floor(totalCount / searchObj.count) 
                            : Math.floor(totalCount / searchObj.count) + 1; 

        pageController.innerHTML = `
            <a href="javascript:void(0)" class="pre-button disabled">이전</a>
            <ul class="page-numbers">
            </ul>
            <a href="javascript:void(0)" class="next-button disabled">다음</a>
        `;
        
        if(searchObj.page != 1) {
            const preButton = pageController.querySelector(".pre-button");
            
            preButton.onclick = () => {
                searchObj.page--;
                SearchService.getInstance().clearCourseList();
                this.loadOpenCourse();
            }
        }

        if(searchObj.page != maxPageNumber) {
            const nextButton = pageController.querySelector(".next-button");
            
            nextButton.onclick = () => {
                searchObj.page++;
                SearchService.getInstance().clearCourseList();
                this.loadOpenCourse();
            }
        }

        const startIndex = searchObj.page % 5 == 0 
                        ? searchObj.page - 4 
                        : searchObj.page - (searchObj.page % 5) + 1;
        
        const endIndex = startIndex + 4 <= maxPageNumber ? startIndex + 4 : maxPageNumber;

        const pageNumbers = document.querySelector(".page-numbers");

        for(let i = startIndex; i <= endIndex; i++) {
            pageNumbers.innerHTML += ` 
                <a href="javascript:void(0)"class ="page-button ${i == searchObj.page ? "disabled" : ""}"><li>${i}</li></a>
            `;
        }

        const pageButtons = document.querySelectorAll(".page-button");
        pageButtons.forEach(button => {
            const pageNumber = button.textContent;
            if(pageNumber != searchObj.page) {
                button.onclick = () => {
                    searchObj.page = pageNumber;
                    SearchService.getInstance().clearCourseList();
                    this.loadOpenCourse();
                }
            }
        });
>>>>>>> parent of a4913de (지금까지 한거 올린거)
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

<<<<<<< HEAD
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
=======
    addClickEventCategoryRadios() {
        const radios = document.querySelectorAll(".info-radio");
        radios.forEach(radio => {
            radio.onclick = () => {
                searchObj.classification.splice(0);
                if(radio.checked) {
                    searchObj.classification.push(radio.value);
                    SearchService.getInstance().loadOpenCourse();
                }
                else {
                    const index = searchObj.classification.indexOf(radio.value);
                    searchObj.classification.splice(index, 1);
                    SearchService.getInstance().clearCourseList();
                }
            }
            
        });
    }
}
>>>>>>> parent of a4913de (지금까지 한거 올린거)
