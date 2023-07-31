package com.sofrecom.operation.customer.entities;


import com.sofrecom.operation.customer.dto.Mou3inaEntityDTO;
import org.springframework.stereotype.Component;

@Component
public class Mapper {



    public Mou3inaEntityDTO mapMou3inaEntityToDto(Mou3inaEntity mou3inaEntity) {
        // Mapper les attributs de Mou3inaEntity à Mou3inaEntityDTO
        return new Mou3inaEntityDTO(  mou3inaEntity.getId(),
                mou3inaEntity.getFirstName(),
                mou3inaEntity.getLastName(),
                mou3inaEntity.getPhone(),
                mou3inaEntity.getDocumentIdType(),
                mou3inaEntity.getPhone2(),
                mou3inaEntity.getHome_Adress(),
                mou3inaEntity.getHome_Adress_GPS_long(),
                mou3inaEntity.getHome_Adress_GPS_latt(),
                mou3inaEntity.getCollaborationStatus(),
                mou3inaEntity.getInscriptionStatus(),
                mou3inaEntity.getVideo(),
                mou3inaEntity.getEmailAdress(),
                mou3inaEntity.getGradeAverage(),
                mou3inaEntity.getHasASmartPhone(),
                mou3inaEntity.getPhoto(),
                mou3inaEntity.getName(),
                mou3inaEntity.getImage(),
                mou3inaEntity.getCopie(),
                mou3inaEntity.getNbServicesDone(),
                mou3inaEntity.getNbfavoris(),
                mou3inaEntity.getSalary(),
                mou3inaEntity.getCommissionPercentage(),
                mou3inaEntity.getMorningCost(),
                mou3inaEntity.getEveningCost(),
                mou3inaEntity.getAfternoonCost(),
                mou3inaEntity.getDevice(),
                mou3inaEntity.getServiceType(),
                mou3inaEntity.getAvailibility(),
                mou3inaEntity.getCompany(),
                mou3inaEntity.getGouvernorat(),
                mou3inaEntity.getDeligation(),
                mou3inaEntity.getServicesDone(),
                mou3inaEntity.getEmploymentStatus()
                );
    }

    public Mou3inaEntity mapMou3inaEntityDtoToEntity(Mou3inaEntityDTO mou3inaEntityDTO) {
        // Mapper les attributs de Mou3inaEntityDTO à Mou3inaEntity
        return new Mou3inaEntity(mou3inaEntityDTO.getId(),
                mou3inaEntityDTO.getFirstName(),
                mou3inaEntityDTO.getLastName(),
                mou3inaEntityDTO.getPhone(),
                mou3inaEntityDTO.getDocumentIdType(),
                mou3inaEntityDTO.getPhone2(),
                mou3inaEntityDTO.getGouvernorat(),
                mou3inaEntityDTO.getDeligation(),
                mou3inaEntityDTO.getHome_Adress(),
                mou3inaEntityDTO.getHome_Adress_GPS_long(),
                mou3inaEntityDTO.getHome_Adress_GPS_latt(),
                mou3inaEntityDTO.getCollaborationStatus(),
                mou3inaEntityDTO.getInscriptionStatus(),
                mou3inaEntityDTO.getVideo(),
                mou3inaEntityDTO.getEmailAdress(),
                mou3inaEntityDTO.getGradeAverage(),
                mou3inaEntityDTO.getHasASmartPhone(),
                mou3inaEntityDTO.getPhoto(),
                mou3inaEntityDTO.getName(),
                mou3inaEntityDTO.getImage(),
                mou3inaEntityDTO.getCopie(),
                mou3inaEntityDTO.getNbServicesDone(),
                mou3inaEntityDTO.getServicesDone(),
                mou3inaEntityDTO.getNbfavoris(),
                mou3inaEntityDTO.getCommissionPercentage(),
                mou3inaEntityDTO.getSalary(),
                mou3inaEntityDTO.getMorningCost(),
                mou3inaEntityDTO.getEveningCost(),
                mou3inaEntityDTO.getAfternoonCost(),
                mou3inaEntityDTO.getDevice(),
                mou3inaEntityDTO.getServiceType(),
                mou3inaEntityDTO.getAvailibility(),
                mou3inaEntityDTO.getCompany(),
                mou3inaEntityDTO.getEmploymentStatus()
                );
    }

}
