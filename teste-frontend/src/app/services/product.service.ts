import { Injectable } from "@angular/core";
import { HttpClient } from '@angular/common/http';
import { Observable } from "rxjs";
import { ProductDTO } from "../model/product/ProductDTO.model";


@Injectable({
    providedIn: 'root'
})
export class ProductService {

    private url = "http://localhost:8080";

    constructor(private http: HttpClient) {}

    public getAllProducts(): Observable<ProductDTO[]> {
        return this.http.get<ProductDTO[]>(`${this.url}/product/`);
    }

    public filterSearch(targetMarkets: string[], technologies: string[]): Observable<ProductDTO[]> {
        return this.http.post<ProductDTO[]>(`${this.url}/product/search/`, {targetMarkets, technologies});
    }

}