import {Injectable} from "@angular/core";
import {Hero} from "../domain/hero";
import {Http, Headers, Response} from "@angular/http";
import "rxjs/add/operator/toPromise";
import {Observable} from "rxjs";

@Injectable()
export class HeroService {
    // private heroesUrl = 'app/heroes';
    private heroesUrl = 'http://localhost:8080/heroes';

    constructor(private http: Http) {
    };

    getHeroes(): Promise<Hero[]> {
        var statDto = this.http.get(this.heroesUrl)
            .toPromise()
            .then(response => response.json().data as Hero[])
            .catch(this.handleError);
        console.log(statDto);

        return statDto;
    }
    //
    // get(): Observable<Hero[]> {
    //     return this.http
    //         .get(this.heroesUrl, {headers: this.getHeaders()})
    //         .map(mapPersons);
    // }
    //
    // getHeroesSlowly(): Promise<Hero[]> {
    //     return new Promise<Hero[]>(resolve =>
    //         setTimeout(resolve, 2000)) // delay 2 seconds
    //         .then(() => this.getHeroes());
    // }

    getHero(id: number): Promise<Hero> {
        return this.getHeroes()
            .then(heroes => heroes.find(hero => hero.id === id));
    }
    //
    // private getHeaders() {
    //     let headers = new Headers();
    //     headers.append('Accept', 'application/json');
    //     return headers;
    // }

    private handleError (error: Response | any) {
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

// function mapPersons(response: Response): Hero[] {
//     // The response of the API has a results
//     // property with the actual results
//     return response.json().results.map(toPerson)
// }
// //
// function toPerson(r: any): Hero {
//     let hero = <Hero>({
//         id: r.id,
//         name: r.name,
//     });
//     console.log('Parsed person:', hero);
//     return hero;
// }

//
// function mapPerson(response: Response): Hero {
//     // toPerson looks just like in the previous example
//     return toPerson(response.json());
// }
