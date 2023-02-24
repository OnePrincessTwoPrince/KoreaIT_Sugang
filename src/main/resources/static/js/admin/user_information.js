window.onload = () => {
    UserInformationService.getInstance().loadCategories();
}


class UserInformationApi{

    static #instance = null;
    static getInstance() {
        if(this.#instance == null) {
            this.#instance = new UserInformationApi();
        }
        return this.#instance;
    }

    getMajorCategories(){
        let returnData = null;

        $.ajax({
            async: false,
            type: "get",
            url: "http://localhost:8000/api/admin",
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

class UserInformationService{
    static #instance = null;
    static getInstance() {
        if(this.#instance == null) {
            this.#instance = new UserInformationService();
        }
        return this.#instance;
    }

    loadCategories() {
        const responseData = UserInformationApi.getInstance().getMajorCategories();

        const categorySelect = document.querySelector(".category-select");
        categorySelect.innerHTML = `<option value="">전체조회</option>`;

        responseData.forEach(data => {
            categorySelect.innerHTML += `
                <option value="${data}">${data}</option>
            `;
        });
    }
}
