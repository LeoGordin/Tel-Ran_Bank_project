package BankProject.domain.entity.jpa;

import BankProject.domain.entity.interfaces.Product;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "product")
@NoArgsConstructor
@AllArgsConstructor
public class JpaProduct implements Product {

    @Column(name = "id")
    private int id;

    @Column(name = "manager_id")
    private int managerId;

    @Column(name = "name")
    private String name;

    @Column(name = "status")
    private int status;

    @Column(name = "currency_code")
    private int currencyCode;

    @Column(name = "interest_rate")
    private BigDecimal interestRate;

    @Column(name = "limit")
    private BigDecimal limit;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @Override
    public int getId() {
        return id;
    }

    @Override
    public int getManagerId() {
        return managerId;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getStatus() {
        return status;
    }

    @Override
    public int getCurrencyCode() {
        return currencyCode;
    }

    @Override
    public BigDecimal getInterestRate() {
        return interestRate;
    }

    @Override
    public BigDecimal getLimit() {
        return limit;
    }

    @Override
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    @Override
    public Timestamp getUpdatedAt() {
        return updatedAt;
    }
}
