package com.vektorel.eticaretweb.service;

import com.vektorel.eticaretweb.dto.request.MusteriSaveDto;
import com.vektorel.eticaretweb.dto.response.MusteriResponseDto;
import com.vektorel.eticaretweb.mapper.MusteriMapper;
import com.vektorel.eticaretweb.repository.MusteriRepository;
import com.vektorel.eticaretweb.repository.entity.Musteri;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 1- Servis ler class olarak eklenir.
 * 2- Sınıfın üzerinde @Service annotayonu eklenmelidir.
 */
@Service
public class MusteriService {

    // Not: Respository ler sınıf değildir. bu nedenle new lenemezler
    // Spring kendi interface ve diğer sınıflardan nesne üretmek için
    // @Autowired annotasyonunu kullanır. Eğer bunu eklemez iseniz.
    // nesne null döneceği için hata alırsınız.
    @Autowired
    MusteriRepository musteriRepository;

    @Autowired
    MusteriMapper musteriMapper;


    public void save(Musteri musteri){
        musteriRepository.save(musteri);
    }
    public void update(Musteri musteri){
        musteriRepository.save(musteri);
    }
    public void delete(Musteri musteri){
        musteriRepository.delete(musteri);
    }
    public List<Musteri> findAll(){
        return musteriRepository.findAll();
    }
    public void save(MusteriSaveDto dto){
        // Burada dto şeklinde gelen müşteri bilgisinin Mapper ile müşteri
        // nesnesine çevirilmesi sağlanmış ve kayıt işlemi tamamlanmıştır.
        Musteri musteri = musteriMapper.toMusteri(dto);
        musteriRepository.save(musteri);
    }
    public List<MusteriResponseDto> findAllRespose(){
        List<MusteriResponseDto> result = new ArrayList<>();
        for (Musteri musteri: musteriRepository.findAll()) {
            result.add(musteriMapper.forMusteri(musteri));
        }
        return result;
    }

    public List<Musteri> findAllName(String ad){
        return  musteriRepository.findByAdLike(ad);
    }
}
