package BankProject.repository;

import BankProject.domain.entity.Agreement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface AgreementRepository extends JpaRepository<Agreement, Integer> {

}
