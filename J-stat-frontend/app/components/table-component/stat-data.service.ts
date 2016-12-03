import {Injectable} from "@angular/core";
import {StatDTO} from "../../domain/stat-dto";
import {Http, Response} from "@angular/http";
import {STATDTO} from "../../services/mock-heroes"

@Injectable()
export class StatDataService {

    private statUrl = 'http://localhost:8080/getStat';

    constructor(private http: Http) {
    };

    getStatData(): Promise<StatDTO> {
        var promiseStatDTO  =  this.http.get(this.statUrl)
            .toPromise()
            // .then(response => STATDTO)
            .then(response => response.json().data as StatDTO)
            .catch(this.handleError);
        // console.log(promiseStatDTO);

        return promiseStatDTO;
    }

    private handleError(error: Response | any) {
        // In a real world app, we might use a remote logging infrastructure
        let errMsg: string;
        if (error instanceof Response) {
            const body = error.json() || '';
            const err = body.error || JSON.stringify(body);
            errMsg = `${error.status} - ${error.statusText || ''} ${err}`;
        } else {
            errMsg = error.message ? error.message : error.toString();
        }
        window.alert(errMsg);
        // return Observable.throw(errMsg);
    }

}
