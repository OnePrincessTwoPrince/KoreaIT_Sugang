window.onload = () => {
    UserInformatinService.getInstance().loadCategories();
}


class UserInformatinApi{

    static #instance = null;
    static getInstance() {
        if(this.#instance == null) {
            this.#instance = new UserInformatinApi();
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
            success: responese => {
                console.log(responese);
                returnData = responese.data;
            }, 
            error: error => {
                console.log(error);
            }
        });

        return returnData;
    }

}

class UserInformatinService{
    static #instance = null;
    static getInstance() {
        if(this.#instance == null) {
            this.#instance = new UserInformatinService();
        }
        return this.#instance;
    }

    loadCategories() {
        const responeseData = UserInformatinApi.getInstance().getMajorCategories();

        const categorySelect = document.querySelector(".category-select");
        categorySelect.innerHTML = `<option value="">전체조회</option>`;

        responeseData.forEach(data => {
            categorySelect.innerHTML += `
                <option value="${data}">${data}</option>
            `;
        });
    }
}
