package com.bustrans.backend.service;



import com.bustrans.backend.dto.ForfaitVerificationDTO;
import com.bustrans.backend.model.ForfaitVerification;
import com.bustrans.backend.repository.ForfaitVerificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ForfaitVerificationService {

    @Autowired
    private ForfaitVerificationRepository forfaitVerificationRepository;

    // Enregistrer une nouvelle vérification de forfait
    public ForfaitVerification saveForfaitVerification(ForfaitVerificationDTO forfaitVerificationDTO) {
        ForfaitVerification verification = new ForfaitVerification(
                forfaitVerificationDTO.getNomClient(),
                forfaitVerificationDTO.getRfid(),
                forfaitVerificationDTO.getStatutForfait(),
                forfaitVerificationDTO.getAndroidId(),
                forfaitVerificationDTO.getRoleUtilisateur(),
                forfaitVerificationDTO.getNomUtilisateur(),
                forfaitVerificationDTO.isForfaitActiverParClient()  // **Prise en compte de la nouvelle propriété**
        );

        return forfaitVerificationRepository.save(verification);
    }

    // Récupérer toutes les vérifications de forfaits
    public List<ForfaitVerification> getAllForfaitVerifications() {
        return forfaitVerificationRepository.findAll();
    }
}
