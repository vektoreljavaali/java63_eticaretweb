package com.vektorel.eticaretweb.viewmodel;

import com.vektorel.eticaretweb.repository.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CategoryTab {

    String ad;
    List<Product> liste;
}
