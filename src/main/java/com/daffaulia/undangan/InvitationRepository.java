package com.daffaulia.undangan;

import com.daffaulia.undangan.entity.Invitation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvitationRepository extends JpaRepository<Invitation, Long> {
    // JpaRepository<liat db entity, liat type id apa>
}
