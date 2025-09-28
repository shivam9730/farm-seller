package com.choice.reigster.shared.utility.Repository;

import com.choice.reigster.shared.utility.entity.CodeGroupDesc;
import org.springframework.data.jpa.repository.JpaRepository;



public interface CodeGroupDescRepository extends JpaRepository<CodeGroupDesc, Long> {
    CodeGroupDesc findByCodeId(Long idValue);
}
