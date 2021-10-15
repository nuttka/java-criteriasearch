package com.gubee.teste.repository.criteria;

import java.util.List;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.gubee.teste.entity.Product;
import com.gubee.teste.entity.TargetMarket;
import com.gubee.teste.filter.FilterProduct;

import org.springframework.beans.factory.annotation.Autowired;

public class ProductRepositoryImpl implements ProductRepositoryCustom {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Product> searchByFilter(FilterProduct filterProduct) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Product> criteriaQuery = criteriaBuilder.createQuery(Product.class);
        Root<Product> product = criteriaQuery.from(Product.class);

        Join<Product, TargetMarket> productTargetMarketJoin = product.join("targetMarkets", JoinType.INNER);
        Join<Product, TargetMarket> productTechnologiesJoin = product.join("technologies", JoinType.INNER);

        List<Predicate> predicates = new ArrayList<Predicate>();


        if (filterProduct.getTargetMarkets() != null) {
            for (String targetMarket : filterProduct.getTargetMarkets()) {
                predicates.add(criteriaBuilder.like(productTargetMarketJoin.get("name"), targetMarket));
            }
        }

        if (filterProduct.getTechnologies() != null) {
            for (String technology : filterProduct.getTechnologies()) {
                predicates.add(criteriaBuilder.like(productTechnologiesJoin.get("name"), technology));
            }
        }

        criteriaQuery.select(product).distinct(true)
            .where(criteriaBuilder.or(predicates.toArray(new Predicate[predicates.size()])));

        return entityManager.createQuery(criteriaQuery)
            .getResultList();
    }
    
}
