import { elementEventFullName } from '@angular/compiler/src/view_compiler/view_compiler';
import { Component, OnInit } from '@angular/core';
import { ProductDTO } from './model/product/ProductDTO.model';
import { TargetMarketDTO } from './model/targetMarket/TargetMarketDTO.model';
import { TechnologyDTO } from './model/technology/TechnologyDTO.model';
import { ProductService } from './services/product.service';
import { TargetMarketService } from './services/targetMarket.service';
import { TechnologyService } from './services/technology.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  products: ProductDTO[] = [];
  targetMarkets: TargetMarketDTO[] = [];
  technologies: TechnologyDTO[] = [];
  tagertMarketFilterParams: string[] = [];
  technologyFilterParams: string[] = [];
  headElements = ["Nome", "Descrição", "Mercados alvo", "Tecnologias"];
  targetMarketsTechnologies: any[] = [];
  tableProducts: any[] = [];

  constructor(
    private productService: ProductService,
    private targetMarketService: TargetMarketService,
    private technologyService: TechnologyService
    ) {}

  ngOnInit(): void {
    this.getProducts();
    this.getTargetMarkets();
    this.getTechnologies();
  }

  getProducts(): void {
    this.productService.getAllProducts().subscribe((res: ProductDTO[]) => {
      this.products = res;  
      this.generateTableProducts();             
    }, error => {
      console.log("Error:" + error.toString());
    })
  }

  getTargetMarkets(): void {
    this.targetMarketService.getAllTargetMarkets().subscribe((res: TargetMarketDTO[]) => {
      this.targetMarkets = res;
      res.forEach(targetMarket => {
        let obj = {
          name: targetMarket.name,
          check: false
        }
        this.targetMarketsTechnologies.push(obj);
      });           
    }, error => {
      console.log("Error:" + error.toString());
    })
  }

  getTechnologies(): void {
    this.technologyService.getAllTechnologies().subscribe((res: TechnologyDTO[]) => {
      this.technologies = res;
      res.forEach(technology => {
        let obj = {
          name: technology.name,
          check: false
        }
        this.targetMarketsTechnologies.push(obj);
      });
    }, error => {
      console.log("Error:" + error.toString());
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

  defineSearchFilter() {
    this.targetMarketsTechnologies.forEach(targetMarketTechnology => {
      if(targetMarketTechnology.check){
        let index = this.targetMarkets.findIndex(elmnt => elmnt.name == targetMarketTechnology.name);
        if(index != -1) {
          this.tagertMarketFilterParams.push(targetMarketTechnology.name);
        } else {
          this.technologyFilterParams.push(targetMarketTechnology.name);
        }
      }
    });

    console.log(this.tagertMarketFilterParams);
    console.log(this.technologyFilterParams);
  }

  filter() {
    this.tableProducts = [];
    this.defineSearchFilter();

    this.productService.filterSearch(this.tagertMarketFilterParams, this.technologyFilterParams).subscribe((res: ProductDTO[]) => {
      this.products = res;  
      this.generateTableProducts();             
    }, error => {
      console.log("Error:" + error.toString());
    });

    this.tagertMarketFilterParams =[];
    this.technologyFilterParams = [];
    console.log(this.tableProducts);
  }


}
