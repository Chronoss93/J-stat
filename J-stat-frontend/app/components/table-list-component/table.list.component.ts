import {Component, OnInit} from "@angular/core";
import {Router} from "@angular/router";
import {StatDataService} from "../../services/stat-data.service";
import {TableDTO} from "../../domain/table-dto";

@Component({
    moduleId: module.id,
    selector: 'my-tables',
    templateUrl: 'table.list.component.html',
    styleUrls: ['table.list.component.css'],
    providers: [StatDataService]
})

export class TableListComponent implements OnInit {

    tables: TableDTO[];

    constructor(private router: Router,
                private statDataService: StatDataService) {
    }

    ngOnInit(): void {
        this.getTables();
    }

    private getTables(): void {
        this.statDataService.getAllTables().then(tables => this.tables = tables);
    }

    gotoDetail(table: TableDTO): void {
        this.router.navigate(['/table', table.tableName]);
    }
}
