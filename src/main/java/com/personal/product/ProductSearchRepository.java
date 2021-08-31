package com.personal.product;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Database Access Object for Product table.
 * <p/>
 */
@Repository
public interface ProductSearchRepository extends CrudRepository<ProductDO, Long> {

}
