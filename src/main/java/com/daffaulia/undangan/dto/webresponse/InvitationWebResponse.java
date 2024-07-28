package com.daffaulia.undangan.dto.webresponse;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //termasuk setter getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InvitationWebResponse {
    private Long id;
    private String name;
    private String relation;
    private Integer numberOfGuest;
}
