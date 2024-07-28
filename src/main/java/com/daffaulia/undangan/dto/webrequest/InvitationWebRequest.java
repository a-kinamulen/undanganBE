package com.daffaulia.undangan.dto.webrequest;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //termasuk setter getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InvitationWebRequest {
    @Column(length = 50)
    private String name;
    @Column(length = 30)
    private String relation;
    private Integer numberOfGuest;
}
