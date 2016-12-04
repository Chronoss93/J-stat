import {NgModule} from "@angular/core";
import {BrowserModule} from "@angular/platform-browser";
import {FormsModule} from "@angular/forms";
import {AppComponent} from "./components/app-component/app.component";
import {HeroDetailComponent} from "./components/hero-detail-component/hero-detail.component";
import {HeroService} from "./services/hero.service";
import {HeroesComponent} from "./components/heroes-component/heroes.component";
import {DashboardComponent} from "./components/dashboard.component/dashboard.component";
import {AppRoutingModule} from "./app-routing.module";
import {TableComponent} from "./components/table-component/table.component";
import {NavComponent} from "./components/nav-component/nav.component";
import {UploadComponent} from "./components/upload-component/upload.component";
import {HttpModule} from "@angular/http";
import {FileSelectDirective, FileDropDirective} from "ng2-file-upload/ng2-file-upload";
import {TableListComponent} from "./components/table-list-component/table.list.component";
import all = webdriver.promise.all;

@NgModule({
    imports: [
        BrowserModule,
        FormsModule,
        HttpModule,
        AppRoutingModule,
    ],
    declarations: [AppComponent, HeroDetailComponent, HeroesComponent, DashboardComponent,
        TableComponent, TableListComponent, NavComponent, UploadComponent, FileSelectDirective, FileDropDirective,
    ],
    bootstrap: [AppComponent],
    providers: [HeroService]
})

export class AppModule {
}

