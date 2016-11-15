import {Component, OnInit} from "@angular/core";
import {StatDataService} from "./stat-data.service";
import {StatDTO} from "../stat-dto";

@Component({
    moduleId: module.id,
    selector: 'my-table',
    templateUrl: 'table.component.html',
    styleUrls: ['table.component.css'],
    providers: [StatDataService]
})
export class TableComponent implements OnInit {

    metricsTableData: StatDTO;

    constructor(private statDataService: StatDataService) {
    }

    ngOnInit(): void {
        this.getStatData();
    }

    private getStatData() {
        this.statDataService.getStatData().then(data => this.metricsTableData = data);
    }
    someMeth(){
        window.alert(this.metricsTableData);
        console.log(this.metricsTableData.columnHeaders);
    }

}
