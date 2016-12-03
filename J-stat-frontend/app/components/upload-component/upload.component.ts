import {Component} from "@angular/core";
import {FileUploader} from "ng2-file-upload/ng2-file-upload";

const URL = 'http://localhost:8080/upload';

@Component({
    moduleId: module.id,
    selector: 'my-upload',
    templateUrl: 'upload.component.html',
    styleUrls: ['upload.component.css'],
})
export class UploadComponent {
    public uploader: FileUploader = new FileUploader({url: URL});
    public hasBaseDropZoneOver: boolean = false;

    public fileOverBase(e: any): void {
        this.hasBaseDropZoneOver = e;
    }

}