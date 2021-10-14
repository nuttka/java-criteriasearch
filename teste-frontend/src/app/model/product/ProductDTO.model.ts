import { TargetMarketDTO } from "../targetMarket/TargetMarketDTO.model";
import { TechnologyDTO } from "../technology/TechnologyDTO.model";

export class ProductDTO {
    constructor(
        public id: number, 
        public name: string,
        public description: string,
        public targetMarkets: Array<TargetMarketDTO>,
        public technologies: Array<TechnologyDTO>
    ){}
}