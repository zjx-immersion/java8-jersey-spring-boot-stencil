package test.functional.product;

import com.thoughtworks.gaia.Application;
import com.thoughtworks.gaia.common.constant.EnvProfile;
import com.thoughtworks.gaia.common.exception.NotFoundException;
import com.thoughtworks.gaia.product.dao.ProductDao;
import com.thoughtworks.gaia.product.entity.Product;
import com.thoughtworks.gaia.product.model.ProductModel;
import com.thoughtworks.gaia.product.service.ProductService;
import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

//@Rollback
//@Transactional
//@ActiveProfiles({EnvProfile.TEST})

@RunWith(SpringRunner.class)
@ContextConfiguration
//@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class ProductServiceFunctionalTest {
    @Test
    public void contextLoads() {
    }
//    @Autowired
//    private ProductService productService;
//
//    @Autowired
//    private ProductDao productDao;
//
//    @Test
//    public void should_get_product_with_id() throws Exception {
//        ProductModel productModel = dummyProductModel();
//        productDao.save(productModel);
//        Long productId = productModel.getId();
//
//        Product product = productService.getProduct(productId);
//
//        assertThat(product.getId()).isEqualTo(productId);
//    }
//
//    private ProductModel dummyProductModel() {
//        ProductModel productModel = new ProductModel();
//        productModel.setName("name");
//        productModel.setTimeCreated(DateTime.now().toDate());
//        return productModel;
//    }
//
//    @Test(expected = NotFoundException.class)
//    public void should_throw_exception_when_not_found() {
//        productService.getProduct(-1L);
//    }
}
