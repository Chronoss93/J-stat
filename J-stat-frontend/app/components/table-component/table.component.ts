import {Component, OnInit} from "@angular/core";
import {Location} from "@angular/common";
import {StatDataService} from "../../services/stat-data.service";
import {TableDTO} from "../../domain/table-dto";
import {ActivatedRoute, Params} from "@angular/router";

@Component({
    moduleId: module.id,
    selector: 'my-table',
    templateUrl: 'table.component.html',
    styleUrls: ['table.component.css'],
    providers: [StatDataService]
})
export class TableComponent implements OnInit {

    table: TableDTO;

    constructor(private statDataService: StatDataService,
                private route: ActivatedRoute,
                private location: Location) {
    }

    ngOnInit(): void {

        this.getStatData();
    }

    private getStatData() {
        this.route.params.forEach((params: Params) => {
            var id = params['id'];
            this.statDataService.getTable(id)
                .then(table => this.table = table);
        });
        // this.statDataService.getStatData().then(data => this.table = data);
    }

    goBack(): void {
        this.location.back();
    }
    someMeth(){
        window.alert(this.table);
        console.log(this.table.columnHeaders);
    }

}
