package com.workbook.demo.directory;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DirectoryRepository extends JpaRepository<String,Long> {
}
