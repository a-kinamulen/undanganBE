package com.daffaulia.undangan.controller;

import com.daffaulia.undangan.dto.webrequest.InvitationWebRequest;
import com.daffaulia.undangan.dto.webresponse.InvitationWebResponse;
import com.daffaulia.undangan.entity.Invitation;
import com.daffaulia.undangan.service.InvitationService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class InvitationController {

    @Autowired
    private InvitationService invitationService;

    @GetMapping("/{id}")
    public ResponseEntity<InvitationWebResponse> getInvitationById(@PathVariable Long id){
        Invitation invitation = invitationService.getInvitation(id);
        if (invitation != null) {
            InvitationWebResponse response = InvitationWebResponse.builder().build();
            BeanUtils.copyProperties(invitation, response);
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<InvitationWebResponse> postInvitation(@RequestBody InvitationWebRequest request){
        Invitation book = invitationService.postInvitation(request);
        InvitationWebResponse response = InvitationWebResponse.builder().build();
        BeanUtils.copyProperties(book, response);
        return ResponseEntity.ok(response);
    }
}
