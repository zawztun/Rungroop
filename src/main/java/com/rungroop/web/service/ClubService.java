package com.rungroop.web.service;

import com.rungroop.web.dto.ClubDto;
import com.rungroop.web.models.Club;

import java.util.List;

public interface ClubService {
    List<ClubDto> findAllClub();
    Club saveClub(ClubDto clubDto);
    ClubDto findClubById(long clubID);

    void updateClub(ClubDto club);
   void delete(Long clubId);

   List<ClubDto> searchClubs(String query);
}
