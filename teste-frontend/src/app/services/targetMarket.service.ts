import { Injectable } from "@angular/core";
import { HttpClient } from '@angular/common/http';
import { Observable } from "rxjs";
import { TargetMarketDTO } from "../model/targetMarket/TargetMarketDTO.model";


@Injectable({
    providedIn: 'root'
})
export class TargetMarketService {

    private url = "http://localhost:8080";

    constructor(private http: HttpClient) {}

    public getAllTargetMarkets(): Observable<TargetMarketDTO[]> {
        return this.http.get<TargetMarketDTO[]>(`${this.url}/product/`);
    }

}