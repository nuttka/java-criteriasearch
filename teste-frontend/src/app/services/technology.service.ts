import { Injectable } from "@angular/core";
import { HttpClient } from '@angular/common/http';
import { Observable } from "rxjs";
import { TechnologyDTO } from "../model/technology/TechnologyDTO.model";


@Injectable({
    providedIn: 'root'
})
export class TechnologyService {

    private url = "http://localhost:8080";

    constructor(private http: HttpClient) {}

    public getAllTechnologies(): Observable<TechnologyDTO[]> {
        return this.http.get<TechnologyDTO[]>(`${this.url}/technology/`);
    }

}