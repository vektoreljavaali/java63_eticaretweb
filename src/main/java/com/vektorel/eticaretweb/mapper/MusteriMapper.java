package com.vektorel.eticaretweb.mapper;

import com.vektorel.eticaretweb.dto.request.MusteriSaveDto;
import com.vektorel.eticaretweb.dto.response.MusteriResponseDto;
import com.vektorel.eticaretweb.repository.entity.Musteri;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * Doğası gereği bir sınıfın diğer bir sınıfa map edilerek dönüşümü sırasında
 * tüm alanların eşleşmesi beklenemez bu nedenle eşleşmeyen alanların görmezdenm
 * gelinmesi gereklidir. bunu sağlamak için IGNORE politikası seçilir.
 * Mapstruct farklı kullanımlarda farklı şekilde setting yapılandırmaları gerektirir
 * bu nedenle bileşen modeli olarak "spring" seçilmiştir. diğer kullanımlar için
 * Mapstruct ın kendi sitesinde belirilen örneklere bakınız.
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,componentModel = "spring")
public interface MusteriMapper {

    // Burada işlem istek olarak gelen musteri kısıt bilgisinden yeni bir
    // müşteri nesnesi oluşturulması durumudur.
    Musteri toMusteri(final MusteriSaveDto musteriSaveDto);
    // bir müşterinin kısıt bilgilerinin sunulması için bir dto ya
    // çevirilmesi durumudur.
    MusteriResponseDto forMusteri(final Musteri musteri);
}
