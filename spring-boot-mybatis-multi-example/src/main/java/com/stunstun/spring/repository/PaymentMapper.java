
package com.stunstun.spring.repository;

import com.stunstun.spring.repository.entity.Transaction;
import com.stunstun.spring.repository.support.PaymentSchema;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author stunstun
 *
 */
@PaymentSchema
public interface PaymentMapper {

	public List<Transaction> findAll();

	public List<Transaction> findByUserName(@Param("userName") String userName);

	public Transaction findOne(Long id);

	public Boolean exists(Long id);

	public void save(Transaction transaction);

	public void update(Transaction transaction);

	public void delete(Transaction transaction);
}
