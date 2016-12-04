import {Component, OnInit} from "@angular/core";
import {StatDataService} from "../../services/stat-data.service";
import {TableDTO} from "../../domain/table-dto";

@Component({
    moduleId: module.id,
    selector: 'my-table',
    templateUrl: 'table.component.html',
    styleUrls: ['table.component.css'],
    providers: [StatDataService]
})
export class TableComponent implements OnInit {

    table: TableDTO;

    constructor(private statDataService: StatDataService) {
    }

    ngOnInit(): void {
        this.getStatData();
    }

    private getStatData() {
        this.statDataService.getStatData().then(data => this.table = data);
    }
    someMeth(){
        window.alert(this.table);
        console.log(this.table.columnHeaders);
    }

}
