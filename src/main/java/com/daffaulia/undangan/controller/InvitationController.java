package com.daffaulia.undangan.controller;

import com.daffaulia.undangan.dto.webrequest.InvitationWebRequest;
import com.daffaulia.undangan.dto.webresponse.InvitationWebResponse;
import com.daffaulia.undangan.entity.Invitation;
import com.daffaulia.undangan.service.InvitationService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
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

    @PostMapping("/add")
    public ResponseEntity<InvitationWebResponse> postInvitation(@RequestBody InvitationWebRequest request){
        Invitation book = invitationService.postInvitation(request);
        InvitationWebResponse response = InvitationWebResponse.builder().build();
        BeanUtils.copyProperties(book, response);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/allGuest")
    public ResponseEntity<List<InvitationWebResponse>> getInvitations(@RequestHeader(value = "page", required = false, defaultValue="0") Integer page,
                                                                      @RequestHeader(value = "size", required = false, defaultValue="1000") Integer size,
                                                                      @RequestHeader(value = "sortBy", required = false, defaultValue="id") String sortBy,
                                                                      @RequestHeader(value = "direction", required = false, defaultValue="DESC") String direction){
        List<InvitationWebResponse> responses = invitationService.getInvitations(page, size, sortBy, direction);
        return ResponseEntity.ok(responses);
    }
}
