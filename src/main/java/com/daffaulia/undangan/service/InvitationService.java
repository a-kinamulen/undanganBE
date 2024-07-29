package com.daffaulia.undangan.service;

import com.daffaulia.undangan.InvitationRepository;
import com.daffaulia.undangan.dto.webrequest.InvitationWebRequest;
import com.daffaulia.undangan.dto.webresponse.InvitationWebResponse;
import com.daffaulia.undangan.entity.Invitation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class InvitationService {

    @Autowired
    private InvitationRepository invitationRepository;

    public Invitation getInvitation(Long id){
        Optional<Invitation> bookOptional = invitationRepository.findById(id);
        return bookOptional.orElse(null);
    }

    public Invitation postInvitation(InvitationWebRequest request) {
        Invitation invitation = Invitation.builder().build();
        BeanUtils.copyProperties(request, invitation);
        return invitationRepository.save(invitation);
    }

    public List<InvitationWebResponse> getInvitations(Integer page, Integer size, String sortBy, String direction) {
        Pageable pageRequest = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(direction), sortBy));
        Page<Invitation> invitations = invitationRepository.findAll(pageRequest);
        return toWebResponseList(invitations.toList());
    }

    private List<InvitationWebResponse> toWebResponseList(List<Invitation> invitations) {
        List<InvitationWebResponse> responses = new ArrayList<>();
        invitations.forEach(invitation -> responses.add(toWebResponse(invitation)));
        return responses;
    }

    private InvitationWebResponse toWebResponse(Invitation invitation) {
        return InvitationWebResponse.builder()
                .id(invitation.getId())
                .name(invitation.getName())
                .relation(invitation.getRelation())
                .numberOfGuest(invitation.getNumberOfGuest())
                .build();
    }
}
