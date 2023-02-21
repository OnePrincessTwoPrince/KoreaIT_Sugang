window.onload = () => {

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
            
        });
    }
}