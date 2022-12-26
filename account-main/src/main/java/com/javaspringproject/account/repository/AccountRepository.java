package com.javaspringproject.account.repository;

import com.javaspringproject.account.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, String> {
}
