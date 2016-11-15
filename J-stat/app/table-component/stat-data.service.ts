import {Injectable} from "@angular/core";
import {StatDTO} from "../stat-dto";
import {Http} from "@angular/http";

@Injectable()
export class StatDataService {

    private statUrl = 'http://localhost:8080/getStat';

    constructor(private http: Http) {
    };

    getStatData(): Promise<StatDTO> {
        return this.http.get(this.statUrl)
            .toPromise()
            .then(response => response.json().data as StatDTO)
            .catch(this.handleError);
    }
    private handleError(error: any): Promise<any> {
        console.error('An error occurred', error); // for demo purposes only
        window.alert("ERROR")
        return Promise.reject(error.message || error);
    }
}
