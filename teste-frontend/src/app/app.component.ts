import { Component, OnInit } from '@angular/core';
import { ProductDTO } from './model/product/ProductDTO.model';
import { ProductService } from './services/product.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  products : ProductDTO[] = [];
  tagertMarketFilterParams : string[] = [];
  technologyFilterParams : string[] = [];
  headElements = ["Nome", "Descrição", "Mercados alvo", "Tecnologias"];

  tableProducts: any[] = [];

  constructor(private productService: ProductService) {}

  ngOnInit(): void {
    this.getProducts();
  }

  getProducts(): void {
    this.productService.getAllProducts().subscribe((res: ProductDTO[]) => {
      this.products = res;  
      this.generateTableProducts();             
    }, error => {
      console.log("houve um erro" + error);
    })
  }

  generateTableProducts(): void {
    this.products.forEach(product => {
      let stringArray: string[] = [];
      let tableProduct = {
        name: product.name,
        description: product.description,
        technologies: stringArray,
        targetMarkets: stringArray
      };

      product.targetMarkets.forEach(targetMarket => {
        tableProduct.targetMarkets.push(targetMarket.name);
      });

      product.technologies.forEach(technology => {
        tableProduct.technologies.push(technology.name);
      });
      this.tableProducts.push(tableProduct);
    });
  }

  filter() {

  }

}
