import {Injectable} from "@angular/core";
import {TableDTO} from "../domain/table-dto";
import {Http, Response} from "@angular/http";

@Injectable()
export class StatDataService {

    private statUrl = 'http://localhost:8080/getStat';
    private tablesUrl = 'http://localhost:8080/getTables';

    constructor(private http: Http) {
    };

    getStatData(): Promise<TableDTO> {

        return this.http.get(this.statUrl)
            .toPromise()
            .then(response => response.json().data as TableDTO)
            .catch(this.handleError);
    }

    getAllTables(): Promise<TableDTO[]> {
        var tables = this.http.get(this.tablesUrl)
            .toPromise()
            .then(response => response.json().data as TableDTO[])
            .catch(this.handleError);
        console.log(tables);

        return tables;
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
