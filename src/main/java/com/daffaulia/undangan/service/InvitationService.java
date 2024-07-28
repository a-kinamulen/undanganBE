package com.daffaulia.undangan.service;

import com.daffaulia.undangan.InvitationRepository;
import com.daffaulia.undangan.dto.webrequest.InvitationWebRequest;
import com.daffaulia.undangan.entity.Invitation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InvitationService {

    @Autowired
    private InvitationRepository bookRepository;

    public Invitation getInvitation(Long id){
        Optional<Invitation> bookOptional = bookRepository.findById(id);
        return bookOptional.orElse(null);
    }

    public Invitation postInvitation(InvitationWebRequest request) {
        Invitation invitation = Invitation.builder().build();
        BeanUtils.copyProperties(request, invitation);
        return bookRepository.save(invitation);
    }
}
