
package org.example.service;

import org.example.dto.IdEntity;
import org.example.dto.SuccessEntity;
import org.example.entity.Hotel;

import java.util.List;

public interface HotelService {

    List<Hotel> getHotelPagedList(Integer pageNo, Integer pageSize, String sortBy); // Pagination

    List<Hotel> getAllHotels();

    Hotel getHotel(Integer id);

    List<Hotel> getAvailable(String dateFrom, String dateTo);

    IdEntity saveHotel(Hotel hotel);

    SuccessEntity deleteHotel(Integer id);

    SuccessEntity patchHotel(Hotel hotel);

    void doesReservationOverlap(Hotel hotel);

    boolean validateHotelExistenceById(Integer id);
}
