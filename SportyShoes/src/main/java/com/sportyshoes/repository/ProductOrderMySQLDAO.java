package com.sportyshoes.repository;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sportyshoes.model.Product;
import com.sportyshoes.model.ProductOrder;
import com.sportyshoes.model.User;

@Repository
public class ProductOrderMySQLDAO {
	private final JdbcTemplate jdbcTemplate;
	
	public ProductOrderMySQLDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public List<ProductOrder> getAllPurchaseOrders() {
		return jdbcTemplate.query("SELECT * FROM orders", (rs, rowNum) -> {
			ProductOrder order = new ProductOrder();
			int productId = rs.getInt(2);
			int userId = rs.getInt(1);
			
			Product product = jdbcTemplate.queryForObject("SELECT * FROM product WHERE Id = ?", (rs1, rowNum1) -> {
				Product productInner = new Product();
				productInner.setId(rs1.getInt(1));
				productInner.setBrand(rs1.getString(2));
				productInner.setCategory(rs1.getString(3));
				productInner.setColor(rs1.getString(4));
				productInner.setCreatedDate(rs1.getString(5));
				productInner.setProductName(rs1.getString(6));
				productInner.setPrice(rs1.getDouble(7));
				productInner.setQuantity(rs1.getInt(8));
				return productInner;
			}, productId);
			User user = jdbcTemplate.queryForObject("SELECT * FROM user WHERE user_id = ?", (rs2, rowNum2) -> {
				User u = new User();
				u.setUserId(rs2.getInt(1));
				u.setEmail(rs2.getString(2));
				u.setPassword(rs2.getString(3));
				u.setPhoneNo(rs2.getInt(4));
				u.setUsername(rs2.getString(5));
				return u;
			}, userId);
			
			order.setProduct(product);
			order.setUser(user);
			return order;
					
		});
		
	}
	
	public List<ProductOrder> getFilteredOrders(String date, String category) {
        List<ProductOrder> orders = getAllPurchaseOrders();

        if (date != null) {
            orders = orders
                    .stream()
                    .filter(order -> order.getProduct().getCreatedDate().toString().equals(date))
                    .toList();
        }
        if (category != null) {
            orders = orders
                    .stream()
                    .filter(order -> order.getProduct().getCategory().equals(category))
                    .toList();
        }
        return orders;
    }
}
