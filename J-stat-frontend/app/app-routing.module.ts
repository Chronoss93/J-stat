import {NgModule} from "@angular/core";
import {RouterModule, Routes} from "@angular/router";
import {DashboardComponent} from "./components/dashboard.component/dashboard.component";
import {HeroesComponent} from "./components/heroes-component/heroes.component";
import {HeroDetailComponent} from "./components/hero-detail-component/hero-detail.component";
import {TableComponent} from "./components/table-component/table.component";
import {UploadComponent} from "./components/upload-component/upload.component";
import {TableListComponent} from "./components/table-list-component/table.list.component";

const routes: Routes = [
    {path: '', redirectTo: '/dashboard', pathMatch: 'full'},
    {path: 'dashboard', component: DashboardComponent},
    {path: 'detail/:id', component: HeroDetailComponent},
    {path: 'heroes', component: HeroesComponent},
    {path: 'upload', component: UploadComponent},
    {path: 'table/:id', component: TableComponent},
    {path: 'allTables', component: TableListComponent},
    {path: 'table', component: TableListComponent}

];
@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule {
}