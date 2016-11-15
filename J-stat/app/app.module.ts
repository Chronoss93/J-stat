import {NgModule} from "@angular/core";
import {BrowserModule} from "@angular/platform-browser";
import {FormsModule} from "@angular/forms";
import {AppComponent} from "./app-component/app.component";
import {HeroDetailComponent} from "./hero-detail-component/hero-detail.component";
import {HeroService} from "./hero.service";
import {HeroesComponent} from "./heroes-component/heroes.component";
import {DashboardComponent} from "./dashboard.component/dashboard.component";
import {AppRoutingModule} from "./app-routing.module";
import {TableComponent} from "./table-component/table.component";
import {NavComponent} from "./nav-component/nav.component";
import {UploadComponent} from "./upload-component/upload.component";
import {HttpModule} from "@angular/http";
import all = webdriver.promise.all;

@NgModule({
    imports: [
        BrowserModule,
        FormsModule,
        HttpModule,
        AppRoutingModule,
    ],
    declarations: [AppComponent, HeroDetailComponent, HeroesComponent, DashboardComponent,
        TableComponent, NavComponent, UploadComponent],
    bootstrap: [AppComponent],
    providers: [HeroService]
})

export class AppModule {
}

