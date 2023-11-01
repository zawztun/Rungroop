package com.rungoop.web.service;

import com.rungoop.web.dto.ClubDto;
import com.rungoop.web.models.Club;

import java.util.List;

public interface ClubService {
    List<ClubDto> findAllClub();
    Club saveClub(Club club);
    ClubDto findClubById(long clubID);

    void updateClub(ClubDto club);
}
