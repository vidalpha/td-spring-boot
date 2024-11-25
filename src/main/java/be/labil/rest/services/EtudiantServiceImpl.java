package be.labil.rest.services;

import be.labil.rest.domain.entities.Etudiant;
import be.labil.rest.repositories.interfaces.IEtudiantRepository;
import be.labil.rest.services.interfaces.IEtudiantService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EtudiantServiceImpl implements IEtudiantService {

    private final IEtudiantRepository iEtudiantRepository;


    @Override
    public Etudiant insert(Etudiant etudiant) {
        return iEtudiantRepository.save(etudiant);
    }

    @Override
    public List<Etudiant> list() {
        return iEtudiantRepository.findAll();
    }

    @Override
    public Etudiant update(Long id, Etudiant etudiant) {
        return iEtudiantRepository.findById(id)
                .map(e -> {
                    e.setNom(etudiant.getNom());
                    e.setPrenom(etudiant.getPrenom());
                    e.setMatricule(etudiant.getMatricule());
                    e.setMasterType(etudiant.getMasterType());
                    return iEtudiantRepository.save(etudiant);
                }).orElseThrow(()-> new RuntimeException("Etudiant inconnu"));
    }

    @Override
    public Boolean delete(Long id) {
        iEtudiantRepository.deleteById(id);
        return true;
    }
}

