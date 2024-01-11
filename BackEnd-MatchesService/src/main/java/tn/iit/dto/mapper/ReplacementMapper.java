package tn.iit.dto.mapper;

import tn.iit.dto.ReplacementDto;
import tn.iit.entity.Replacement;

public class ReplacementMapper {
    public static Replacement toReplacement(ReplacementDto replacementDto){
        Replacement replacement = new Replacement();
        replacement.setId(replacementDto.getId());
        replacement.setReplacementTime(replacementDto.getReplacementTime());
        return replacement;
    }

    public static ReplacementDto toReplacementDto(Replacement replacement){
        return ReplacementDto.builder().
                id(replacement.getId()).
                replacementTime(replacement.getReplacementTime()).
                playerOutId(replacement.getPlayerOut().getId()).
                playerInId(replacement.getPlayerIn().getId()).
                playerInFirstName(replacement.getPlayerIn().getPlayer().getFirstName()).
                playerInLastName(replacement.getPlayerIn().getPlayer().getLastName()).
                playerInNationality(replacement.getPlayerIn().getPlayer().getNationality()).
                playerOutFirstName(replacement.getPlayerOut().getPlayer().getFirstName()).
                playerOutLastName(replacement.getPlayerOut().getPlayer().getLastName()).
                playerOutNationality(replacement.getPlayerOut().getPlayer().getNationality()).
                matchId(replacement.getMatch().getId()).
                build();
    }
}
