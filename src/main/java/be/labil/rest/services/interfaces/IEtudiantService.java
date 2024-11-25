package be.labil.rest.services.interfaces;

import be.labil.rest.domain.entities.Etudiant;

import java.util.List;

public interface IEtudiantService {

    Etudiant insert(Etudiant etudiant);

    List<Etudiant> list();

    Etudiant update(Long id, Etudiant etudiant);

    Boolean delete(Long id);
}