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
        let responseData = null;

        $.ajax({
            async: false,
            type: "get",
            url: "http://localhost:8000/api/admin/major",
            dataType: "json",
            suceess: responese => {
                responeseData = responese.data;
            }, 
            error: error => {
                console.log(error);
            }
        });
        return responseData;
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
                <option value="${data.category}">${data.category}</option>
            `;
        });
    }
}
