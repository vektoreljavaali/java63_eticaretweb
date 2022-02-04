package com.vektorel.eticaretweb.repository;

import com.vektorel.eticaretweb.repository.entity.Musteri;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 1- Repositoryler Interface olmalı
 * 2- JpaRepository den miras almalı
 * 3- Repository hangi sınıfı kullanoyor ise o jpa ya verilmeli
 * 4- ID nin türü ne ise(String, Long,Intsger v.s.) jpa ya eklenmeli
 * 5- @Repository annotasyonu eklenmeli
 * NOT: bir şey eksik ise, hiç açışmaz ya da çalışma zamanında respository
 * null döndü diye hata verir.
 */
@Repository
public interface MusteriRepository extends JpaRepository<Musteri,Long> {

    // Kişinin adına göre arama
    // Adına ve soyadına göre arama
    List<Musteri> findByAdLike(String ad);
    // Bu şekilde özel methodlar yazarken Dikkat edilmesi gerek hususlar
    // 1- findBy ile başlayın
    // 2- Değişken adlarını yazarkan ilk harfler büyük olmalı zira kodu bu şekilde
    // analiz edebiliyor. Bu arada değişken adları, Entity de olan değiken isimleridir.
    // burada kullanılan keyword ler spring tarafından desteklenen anahtar kelimeler
    // olmalıdır.
    List<Musteri> findByAdAndSoyad(String ad,String soyad);


}
