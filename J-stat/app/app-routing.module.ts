import {NgModule} from "@angular/core";
import {RouterModule, Routes} from "@angular/router";
import {DashboardComponent} from "./dashboard.component/dashboard.component";
import {HeroesComponent} from "./heroes-component/heroes.component";
import {HeroDetailComponent} from "./hero-detail-component/hero-detail.component";
import {TableComponent} from "./table-component/table.component";
import {UploadComponent} from "./upload-component/upload.component";

const routes: Routes = [
    {path: '', redirectTo: '/dashboard', pathMatch: 'full'},
    {path: 'dashboard', component: DashboardComponent},
    {path: 'detail/:id', component: HeroDetailComponent},
    {path: 'heroes', component: HeroesComponent},
    {path: 'upload', component: UploadComponent},
    {path: 'table', component: TableComponent}

];
@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule {
}